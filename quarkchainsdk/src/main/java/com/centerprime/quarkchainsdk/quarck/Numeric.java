package com.centerprime.quarkchainsdk.quarck;


import android.content.Context;
import android.text.TextUtils;


import org.spongycastle.util.encoders.Hex;
import org.web3j.abi.datatypes.generated.Int32;
import org.web3j.abi.datatypes.generated.Uint32;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Message codec functions.</p>
 * <p>
 * <p>Implementation as per https://github.com/ethereum/wiki/wiki/JSON-RPC#hex-value-encoding</p>
 */
public final class Numeric {

    private static final String HEX_PREFIX = "0x";

    private Numeric() {
    }

    public static String encodeQuantity(BigInteger value) {
        if (value.signum() != -1) {
            return HEX_PREFIX + value.toString(16);
        } else {
            throw new MessageEncodingException("Negative values are not supported");
        }
    }

    public static BigInteger decodeQuantity(String value) {
        if (!isValidHexQuantity(value)) {
            throw new MessageDecodingException("Value must be in format 0x[1-9]+[0-9]* or 0x0");
        }
        try {
            return new BigInteger(value.substring(2), 16);
        } catch (NumberFormatException e) {
            throw new MessageDecodingException("Negative ", e);
        }
    }

    private static boolean isValidHexQuantity(String value) {
        if (value == null) {
            return false;
        }

        if (value.length() < 3) {
            return false;
        }

        if (!value.startsWith(HEX_PREFIX)) {
            return false;
        }

        // If TestRpc resolves the following issue, we can reinstate this code
        // https://github.com/ethereumjs/testrpc/issues/220
        // if (value.length() > 3 && value.charAt(2) == '0') {
        //    return false;
        // }

        return true;
    }

    public static String cleanHexPrefix(String input) {
        if (containsHexPrefix(input)) {
            return input.substring(2);
        } else {
            return input;
        }
    }

    //获取0x地址
    public static String prependHexPrefix(String input) {
        if (!containsHexPrefix(input)) {
            return HEX_PREFIX + input;
        } else {
            return input;
        }
    }

    public static boolean containsHexPrefix(String input) {
        return !Strings.isEmpty(input)
                && input.length() > 1
                && input.charAt(0) == '0'
                && input.charAt(1) == 'x';
    }

    public static BigInteger toBigInt(byte[] value, int offset, int length) {
        return toBigInt((Arrays.copyOfRange(value, offset, offset + length)));
    }

    public static BigInteger toBigInt(byte[] value) {
        return new BigInteger(1, value);
    }

    public static BigInteger toBigInt(String hexValue) {
        String cleanValue = cleanHexPrefix(hexValue);
        return toBigIntNoPrefix(cleanValue);
    }

    public static BigInteger toBigIntNoPrefix(String hexValue) {
        return new BigInteger(hexValue, 16);
    }

    public static String toHexStringWithPrefix(BigInteger value) {
        return HEX_PREFIX + value.toString(16);
    }

    public static String toHexStringNoPrefix(BigInteger value) {
        return value.toString(16);
    }

    public static String toHexStringNoPrefix(byte[] input) {
        return toHexString(input, 0, input.length, false);
    }

    public static String toHexStringWithPrefix(byte[] input) {
        String result = toHexString(input, 0, input.length, false);
        if (result.length() < 2) {
            result = Strings.zeros(1) + result;
        }
        return HEX_PREFIX + result;
    }

    public static String toHexStringWithPrefixSafe(BigInteger value) {
        String result = toHexStringNoPrefix(value);
        if (result.length() < 2) {
            result = Strings.zeros(1) + result;
        }
        return HEX_PREFIX + result;
    }

    //导出指定长度字符串，长度不够则前端补0补齐长度，转为0x格式
    public static String toHexStringWithPrefixZeroPadded(BigInteger value, int size) {
        return toHexStringZeroPadded(value, size, true);
    }

    //导出指定长度字符串，长度不够则前端补0补齐长度，不转为0x格式
    public static String toHexStringNoPrefixZeroPadded(BigInteger value, int size) {
        return toHexStringZeroPadded(value, size, false);
    }

    private static String toHexStringZeroPadded(BigInteger value, int size, boolean withPrefix) {
        String result = toHexStringNoPrefix(value);

        int length = result.length();
        if (length > size) {
            throw new UnsupportedOperationException(
                    "Value " + result + "is larger then length " + size);
        } else if (value.signum() < 0) {
            throw new UnsupportedOperationException("Value cannot be negative");
        }

        if (length < size) {
            result = Strings.zeros(size - length) + result;
        }

        if (withPrefix) {
            return HEX_PREFIX + result;
        } else {
            return result;
        }
    }

    public static byte[] toBytesPadded(BigInteger value, int length) {
        byte[] result = new byte[length];
        byte[] bytes = value.toByteArray();

        int bytesLength;
        int srcOffset;
        if (bytes[0] == 0) {
            bytesLength = bytes.length - 1;
            srcOffset = 1;
        } else {
            bytesLength = bytes.length;
            srcOffset = 0;
        }

        if (bytesLength > length) {
            throw new RuntimeException("Input is too large to put in byte array of size " + length);
        }

        int destOffset = length - bytesLength;
        System.arraycopy(bytes, srcOffset, result, destOffset, bytesLength);
        return result;
    }

    public static byte[] hexStringToByteArray(String input) {
        String cleanInput = cleanHexPrefix(input);

        int len = cleanInput.length();

        if (len == 0) {
            return new byte[]{};
        }

        byte[] data;
        int startIdx;
        if (len % 2 != 0) {
            data = new byte[(len / 2) + 1];
            data[0] = (byte) Character.digit(cleanInput.charAt(0), 16);
            startIdx = 1;
        } else {
            data = new byte[len / 2];
            startIdx = 0;
        }

        for (int i = startIdx; i < len; i += 2) {
            data[(i + 1) / 2] = (byte) ((Character.digit(cleanInput.charAt(i), 16) << 4)
                    + Character.digit(cleanInput.charAt(i + 1), 16));
        }
        return data;
    }

    public static String toHexString(byte[] input, int offset, int length, boolean withPrefix) {
        StringBuilder stringBuilder = new StringBuilder();
        if (withPrefix) {
            stringBuilder.append("0x");
        }
        for (int i = offset; i < offset + length; i++) {
            stringBuilder.append(String.format("%02x", input[i] & 0xFF));
        }

        return stringBuilder.toString();
    }

    public static String toHexString(byte[] input) {
        return toHexString(input, 0, input.length, true);
    }

    public static byte asByte(int m, int n) {
        return (byte) ((m << 4) | n);
    }

    public static boolean isIntegerValue(BigDecimal value) {
        return value.signum() == 0
                || value.scale() <= 0
                || value.stripTrailingZeros().scale() <= 0;
    }

    //eth地址转为QUARK地址
    public static String parseAddressToQuark(String address,Context context) {
        if (TextUtils.isEmpty(address)) {
            return address;
        }

        address = Numeric.prependHexPrefix(address);
        StringBuilder fullShardId = new StringBuilder();
        for (int i = 2; i < 42; i += 10) {
            fullShardId.append(address.substring(i, i + 2));
        }

        String totalSize = SharedPreferencesUtils.getTotalChainCount(context);
        int chainSize = toBigInt(totalSize).intValue();
        long fullShardKeyInt = Numeric.toBigInt(fullShardId.toString()).longValue();
        long chainId = (fullShardKeyInt >>> 16) % chainSize;
        long newFullShardKeyInt = (chainId << 16) + (fullShardKeyInt & ((1 << 16) - 1));
        return address + intTo4ByteHex(newFullShardKeyInt);
    }

    public static String selectChainAndShardAddress(String address, String chainId, String shardId,Context context) {
        long chain = Numeric.toBigInt(chainId).longValue();
        long shard = Numeric.toBigInt(shardId).longValue();
        return selectChainAndShardAddress(address, chain, shard,context);
    }

    public static String selectChainAndShardAddress(String address, long chain, long shard, Context context) {
        BigInteger totalShard = BigInteger.ONE;
        List<String> allShared = SharedPreferencesUtils.getTotalSharedSizes(context);
        if (allShared != null && chain < allShared.size()) {
            totalShard = Numeric.toBigInt(allShared.get((int) chain));
        }
        long shardSize = totalShard.longValue();
        long shardMask = shardSize - 1;
        if (shard >= shardSize) {
            shard = 0;
        }

        address = Numeric.prependHexPrefix(address);
        address = address.substring(0, address.length() - 8);
        StringBuilder fullShardId = new StringBuilder();
        for (int i = 2; i < 42; i += 10) {
            fullShardId.append(address.substring(i, i + 2));
        }
        long fullShardKeyInt = Numeric.toBigInt(fullShardId.toString()).longValue();

        fullShardKeyInt = (chain << 16) + (fullShardKeyInt & ((1 << 16) - 1) & (~shardMask) | shard);
        return address + intTo4ByteHex(fullShardKeyInt);
    }

    private static String intTo4ByteHex(long number) {
        // works on both signed and unsigned number, output is strictly 4-byte hex
        // number should be in range [-2147483648, 4294967295]
        if (number > 2147483647) {
            return Numeric.toHexStringNoPrefixZeroPadded(new Uint32(number).getValue(), 8);
        } else {
            return Numeric.toHexStringNoPrefixZeroPadded(new Int32(number).getValue(), 8);
        }
    }

    public static String parseAddressToEth(String address) {
        if (TextUtils.isEmpty(address)) {
            return address;
        }

        if (Numeric.cleanHexPrefix(address).length() == 40) {
            return address;
        }
        address = address.substring(0, address.length() - 8);
        return Numeric.prependHexPrefix(address);
    }

    public static byte[] stringHexToByteArray(String x) {
        if (x.startsWith(HEX_PREFIX)) {
            x = x.substring(2);
        }
        if (x.length() % 2 != 0) x = "0" + x;
        return Hex.decode(x);
    }

    public static boolean isHex(String value) {
        String cleanInput = Numeric.cleanHexPrefix(value);
        try {
            Numeric.toBigIntNoPrefix(cleanInput);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static byte[] reverseBytes(byte[] bytes) {
        int middle = bytes.length / 2;
        for (int i = 0; i < middle; i++) {
            byte b = bytes[i];
            bytes[i] = bytes[bytes.length - 1 - i];
            bytes[bytes.length - 1 - i] = b;
        }
        return bytes;
    }

    public static String beBigEndianHex(String hex) {
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            return hex;
        }
        return reverseHex(hex);
    }

    private static String reverseHex(String hex) {
        byte[] bytes = hexStringToByteArray(hex);
        bytes = reverseBytes(bytes);
        return toHexStringNoPrefix(bytes);
    }
}
