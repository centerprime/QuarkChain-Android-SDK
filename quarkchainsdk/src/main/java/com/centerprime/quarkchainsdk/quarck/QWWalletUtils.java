package com.centerprime.quarkchainsdk.quarck;

import android.content.Context;
import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 钱包工具
 */

public class QWWalletUtils {
    private static final int DECIMAL_NUMBER = 4;//保留有小数
    private static final String TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";//时间格式
    public static final String FORMAT_END = "MM/dd/yyyy HH:mm:ss";
    private static final String TOKEN_BASE = "36";

    public static String getIntTokenFromWeiUP16(String balance) {
        return getIntTokenFromWei16(balance, Convert.Unit.ETHER, DECIMAL_NUMBER, true);
    }

    public static String getIntTokenFromCongUP16(String balance) {
        return getIntTokenFromWei16(balance, Convert.Unit.CONG, DECIMAL_NUMBER, true);
    }

    //转换单位为wei的16进制数字货币为10进制int类型数据
    public static String getIntTokenFromWei16(String balance) {
        return getIntTokenFromWei16(balance, Convert.Unit.ETHER, DECIMAL_NUMBER, false);
    }

    public static String getIntTokenFromCong16(String balance) {
        return getIntTokenFromWei16(balance, Convert.Unit.CONG, DECIMAL_NUMBER, false);
    }

    public static String getIntTokenFromSun16(String balance) {
        return getIntTokenFromWei16(balance, Convert.Unit.SUN, DECIMAL_NUMBER, false);
    }

    public static String getIntTokenFromWei16(String balance, Convert.Unit unit) {
        return getIntTokenFromWei16(balance, unit, DECIMAL_NUMBER, false);
    }

    public static String getIntTokenFromWei16(String balance, Convert.Unit unit, int number) {
        return getIntTokenFromWei16(balance, unit, number, false);
    }

    public static String getIntTokenNotScaleFromWei16(String balance) {
        return getIntTokenNotScaleFromWei16(balance, Convert.Unit.ETHER);
    }

    public static String getIntTokenNotScaleFromWei16(String balance, Convert.Unit unit) {
        if (TextUtils.isEmpty(balance)) {
            return "0";
        }

        BigDecimal value = Convert.fromWei(Numeric.toBigInt(balance).toString(), unit);
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            return "0";
        }
        if (value.compareTo(BigDecimal.ONE) > 0) {
            value = value.setScale(DECIMAL_NUMBER, BigDecimal.ROUND_DOWN);
        } else {
            BigDecimal divisor = BigDecimal.ONE;
            MathContext mc = new MathContext(4, RoundingMode.DOWN);
            value = value.divide(divisor, mc);
        }
        return value.stripTrailingZeros().toPlainString();
    }

    public static String getIntTokenFromWei16(String balance, Convert.Unit unit, int number, boolean isUp) {
        if (TextUtils.isEmpty(balance)) {
            return "0";
        }

        BigDecimal value = Convert.fromWei(Numeric.toBigInt(balance).toString(), unit).setScale(number, isUp ? BigDecimal.ROUND_UP : BigDecimal.ROUND_DOWN);
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            return "0";
        }

        return value.stripTrailingZeros().toPlainString();
    }

    //转换单位为wei的10进制数字货币为10进制int类型数据
    public static String getIntTokenFromWei10(String balance) {
        return getIntTokenFromWei10(balance, Convert.Unit.ETHER, DECIMAL_NUMBER);
    }

    public static String getIntTokenFromWei10(String balance, boolean isUp) {
        return getIntTokenFromWei10(balance, Convert.Unit.ETHER, DECIMAL_NUMBER, isUp);
    }

    public static String getIntTokenFromWei10(String balance, Convert.Unit unit) {
        return getIntTokenFromWei10(balance, unit, DECIMAL_NUMBER, false);
    }

    public static String getIntTokenFromWei10(String balance, boolean isUp, int number) {
        return getIntTokenFromWei10(balance, Convert.Unit.ETHER, number, isUp);
    }

    public static String getIntTokenFromWei10(String balance, Convert.Unit unit, int number) {
        return getIntTokenFromWei10(balance, unit, number, false);
    }

    public static String getIntTokenFromWei10BTC(String balance) {
        return getIntTokenFromWei10(balance, Convert.Unit.CONG, 7, false);
    }

    public static String getIntTokenFromWei10(String balance, Convert.Unit unit, int number, boolean isUp) {
        if (TextUtils.isEmpty(balance)) {
            return "0";
        }

        BigDecimal value = Convert.fromWei(new BigDecimal(balance), unit).setScale(number, isUp ? BigDecimal.ROUND_UP : BigDecimal.ROUND_DOWN);
        if (value.compareTo(BigDecimal.ZERO) == 0) {
            return "0";
        }
        return value.stripTrailingZeros().toPlainString();
    }


    public static BigInteger toGWeiFrom10(String number) {
        String bigDecimal = Convert.toWei(number, Convert.Unit.GWEI).toString();
        return new BigDecimal(bigDecimal).toBigInteger();
    }

    public static BigInteger toWeiFrom10(String number) {
        String bigDecimal = Convert.toWei(number, Convert.Unit.ETHER).toString();
        return new BigDecimal(bigDecimal).toBigInteger();
    }

    public static BigInteger toWeiFrom10(String number, Convert.Unit unit) {
        String bigDecimal = Convert.toWei(number, unit).toString();
        return new BigDecimal(bigDecimal).toBigInteger();
    }


    //解析时间
    public static String parseTimeFor16(String time16) {
        return parseTimeFor16(time16, TIME_FORMAT);
    }

    public static String parseFullTimeFor16(String time16) {
        return parsePullTimeFor16(time16, TIME_FORMAT);
    }

    public static String parseTimeFor16(String time16, String timeFormat) {
        if (TextUtils.isEmpty(time16)) {
            return "0";
        }
        long time = Numeric.toBigInt(time16).longValue() * 1000;
        Date date = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat(timeFormat, Locale.getDefault());
        return formatter.format(date);
    }

    public static String parsePullTimeFor16(String time16, String timeFormat) {
        if (TextUtils.isEmpty(time16)) {
            return "0";
        }
        long time = Numeric.toBigInt(time16).longValue();
        Date date = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat(timeFormat, Locale.getDefault());
        return formatter.format(date);
    }

    public static String parseTimeFor10(String time10, String timeFormat) {
        if (TextUtils.isEmpty(time10)) {
            return "0";
        }
        long time = Long.parseLong(time10) * 1000;
        Date date = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat(timeFormat, Locale.getDefault());
        return formatter.format(date);
    }

    public static String parseFullTimeFor10(String time10) {
        if (TextUtils.isEmpty(time10)) {
            return "0";
        }
        long time = Long.parseLong(time10);
        Date date = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat(TIME_FORMAT, Locale.getDefault());
        return formatter.format(date);
    }

    //通过地址获取分片id
    public static String parseShardForAddress(String address, String allShard) {
        if (!TextUtils.isEmpty(allShard) && !TextUtils.isEmpty(address)) {
            BigInteger totalCount = Numeric.toBigInt(allShard);
            String mainShard = address.substring(address.length() - 4);
            BigInteger mainShardId = Numeric.toBigInt(mainShard).mod(totalCount);
            return Numeric.toHexStringWithPrefix(mainShardId);
        }
        return "";
    }

    public static String parseFullShardForAddress(String address) {
        if (!TextUtils.isEmpty(address)) {
            String mainShard = address.substring(address.length() - 8);
            return Numeric.prependHexPrefix(mainShard);
        }
        return "";
    }

    //根据地址获取链ID
    public static String parseChainForAddress(String address, BigInteger totalChain) {
        if (!TextUtils.isEmpty(address)) {
            String str = address.substring(address.length() - 8);
            String chain = str.substring(0, 4);
            BigInteger mainChain = Numeric.toBigInt(chain).mod(totalChain);
            return Numeric.toHexStringWithPrefix(mainChain);
        }
        return "0x0";
    }

    //根据地址获分片ID
    public static String parseShardForAddress(String address, BigInteger totalShard) {
        if (!TextUtils.isEmpty(address)) {
            String shard = address.substring(address.length() - 4);
            BigInteger mainShard = Numeric.toBigInt(shard).mod(totalShard);
            return Numeric.toHexStringWithPrefix(mainShard);
        }
        return "0x0";
    }

    public static BigInteger getChainByAddress(Context context, String address) {
        //chain
        String totalChain = SharedPreferencesUtils.getTotalChainCount(context.getApplicationContext());
        BigInteger chainStr = Numeric.toBigInt(totalChain);
        String currentChain = QWWalletUtils.parseChainForAddress(address, chainStr);
        return Numeric.toBigInt(currentChain);
    }

    public static BigInteger getShardByAddress(Context context, String address, BigInteger chain) {
        //shared
        BigInteger totalShard = BigInteger.ONE;
        List<String> allShared = SharedPreferencesUtils.getTotalSharedSizes(context.getApplicationContext());
        if (allShared != null && chain.intValue() < allShared.size() && chain.intValue() >= 0) {
            totalShard = Numeric.toBigInt(allShared.get(chain.intValue()));
        }
        String mainShard = QWWalletUtils.parseShardForAddress(address, totalShard);
        return Numeric.toBigInt(mainShard);
    }

    public static boolean isQKCValidAddress(String input) {
        if (TextUtils.isEmpty(input) || !input.startsWith("0x"))
            return false;
        return WalletUtils.isQKCValidAddress(input);
    }

    public static boolean isQKCNativeTokenID(String tokenID) {
        if (TextUtils.isEmpty(tokenID))
            return false;
        try {
            long id = Numeric.toBigInt(tokenID).longValue();
            return 0 <= id && id <= 4873763662273663091L;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isQKCNativeTokenName(String tokenName) {
        if (TextUtils.isEmpty(tokenName))
            return false;
        try {
            BigInteger number = new BigInteger(tokenName.toLowerCase(), 36);
            return 0 <= number.longValue() && number.longValue() <= 4873763662273663091L;
        } catch (Exception e) {
            return false;
        }
    }

    private static String repeatString(String str, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    //名字转成ID
    public static BigInteger convertTokenName2Num(String tokenName) {
        BigInteger number = new BigInteger(tokenName.toLowerCase(), 36);
        int len = tokenName.length();
        BigInteger plusNumber = new BigInteger(repeatString("1", len - 1) + "0", 36);
        return number.add(plusNumber);
    }

    //ID转成名字
    public static String convertTokenNum2Name(String tokenId) {
        if (!isQKCNativeTokenID(tokenId)) {
            return null;
        }
        BigInteger base = new BigInteger(TOKEN_BASE);
        BigInteger number = Numeric.toBigInt(tokenId);
        String tokenName = tokenCharDecode(number.mod(base).intValue());
        number = number.divide(base).subtract(BigInteger.ONE);
        while (number.compareTo(BigInteger.ZERO) >= 0) {
            tokenName = tokenCharDecode(number.mod(base).intValue()) + tokenName;
            number = number.divide(base).subtract(BigInteger.ONE);
        }
        return tokenName;
    }

    private static String tokenCharDecode(int id) {
        char result;
        if (id < 10) {
            result = (char) ('0' + id);
        } else {
            result = (char) ('A' + (id - 10));
        }
        return Character.toString(result);
    }

    public static String changeChainShardToDes(Context context, String address, String desAddress) {
        //chain
        BigInteger currentChain = QWWalletUtils.getChainByAddress(context, desAddress);
        //shared
        BigInteger currentShard = QWWalletUtils.getShardByAddress(context, desAddress, currentChain);

        return Numeric.selectChainAndShardAddress(address, currentChain.toString(16), currentShard.toString(16), context);
    }

//    public static String getCurrentWalletAddress(Context context) {
//        QWWallet wallet = initCurrentMainWallet(context);
//        return wallet != null ? wallet.getCurrentAddress() : "";
//    }
//
//    private static QWWallet initCurrentMainWallet(Context context) {
//        SharedPreferenceRepository repository = new SharedPreferenceRepository(context);
//        String key = repository.getCurrentWalletKey();
//        //无钱包
//        if (TextUtils.isEmpty(key)) {
//            return null;
//        }
//
//        QWWalletDao dao = new QWWalletDao(context);
//        return dao.queryByKey(key);
//    }

    public static boolean isJson(String json) {
        try {
            new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String parseAddressTo8Show(String address) {
        if (!TextUtils.isEmpty(address) && address.length() > 16) {
            String value = address.substring(0, 8);
            value = value + "\u2026";
            value = value + address.substring(address.length() - 8);
            return value;
        }
        return address;
    }
}
