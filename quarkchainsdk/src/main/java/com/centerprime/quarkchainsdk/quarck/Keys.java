package com.centerprime.quarkchainsdk.quarck;


import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.ECGenParameterSpec;
import java.util.Arrays;


/**
 * Crypto key utilities.
 */
public class Keys {

    static final int PRIVATE_KEY_SIZE = 32;
    static final int PUBLIC_KEY_SIZE = 64;

    public static final int ADDRESS_SIZE = 160;
    public static final int QKC_ADDRESS_SIZE = 48;
    public static final int ADDRESS_LENGTH_IN_HEX = ADDRESS_SIZE >> 2;
    public static final int QKC_ADDRESS_LENGTH_IN_HEX = ADDRESS_SIZE >> 2;
    static final int PUBLIC_KEY_LENGTH_IN_HEX = PUBLIC_KEY_SIZE << 1;
    public static final int PRIVATE_KEY_LENGTH_IN_HEX = PRIVATE_KEY_SIZE << 1;

    static {
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            Security.addProvider(new BouncyCastleProvider());
        }
    }

    private Keys() {
    }

    /**
     * Create a keypair using SECP-256k1 curve.
     * <p>
     * <p>Private keypairs are encoded using PKCS8
     * <p>
     * <p>Private keys are encoded using X.509
     */
    static KeyPair createSecp256k1KeyPair() throws NoSuchProviderException,
            NoSuchAlgorithmException, InvalidAlgorithmParameterException {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECDSA", "BC");
        ECGenParameterSpec ecGenParameterSpec = new ECGenParameterSpec("secp256k1");
        keyPairGenerator.initialize(ecGenParameterSpec, SecureRandomUtils.secureRandom());
        return keyPairGenerator.generateKeyPair();
    }

    public static ECKeyPair createEcKeyPair() throws InvalidAlgorithmParameterException,
            NoSuchAlgorithmException, NoSuchProviderException {
        KeyPair keyPair = createSecp256k1KeyPair();
        return ECKeyPair.create(keyPair);
    }

    //地址转为字符串
    public static String getAddress(ECKeyPair ecKeyPair) {
        return getAddress(ecKeyPair.getPublicKey());
    }

    public static String getAddress(BigInteger publicKey) {
        return getAddress(Numeric.toHexStringWithPrefixZeroPadded(publicKey, PUBLIC_KEY_LENGTH_IN_HEX));
    }

    private static String getAddress(String publicKey) {
        String publicKeyNoPrefix = Numeric.cleanHexPrefix(publicKey);

        if (publicKeyNoPrefix.length() < PUBLIC_KEY_LENGTH_IN_HEX) {
            publicKeyNoPrefix = Strings.zeros(
                    PUBLIC_KEY_LENGTH_IN_HEX - publicKeyNoPrefix.length())
                    + publicKeyNoPrefix;
        }
        String hash = Hash.sha3(publicKeyNoPrefix);
        return hash.substring(hash.length() - ADDRESS_LENGTH_IN_HEX);  // right most 160 bits
    }

    public static byte[] getAddress(byte[] publicKey) {
        byte[] hash = Hash.sha3(publicKey);
        return Arrays.copyOfRange(hash, hash.length - 20, hash.length);  // right most 160 bits
    }


    /**
     * Checksum address encoding as per
     * <a href="https://github.com/ethereum/EIPs/blob/master/EIPS/eip-55.md">EIP-55</a>.
     *
     * @param address a valid hex encoded address
     * @return hex encoded checksum address
     */
    public static String toChecksumAddress(String address) {
        String lowercaseAddress = Numeric.cleanHexPrefix(address).toLowerCase();
        String addressHash = Numeric.cleanHexPrefix(Hash.sha3String(lowercaseAddress));

        StringBuilder result = new StringBuilder(lowercaseAddress.length() + 2);

        result.append("0x");

        for (int i = 0; i < lowercaseAddress.length(); i++) {
            if (Integer.parseInt(String.valueOf(addressHash.charAt(i)), 16) >= 8) {
                result.append(String.valueOf(lowercaseAddress.charAt(i)).toUpperCase());
            } else {
                result.append(lowercaseAddress.charAt(i));
            }
        }

        return result.toString();
    }

    //转换qkc地址中大写字母
    public static String toChecksumHDAddress(String address) {
//        if (TronWalletClient.isTronAddressValid(address) || TronWalletClient.isTronErc10TokenAddressValid(address)) {
//            return address;
//        }

        if (WalletUtils.isValidAddress(address)) {
            return toChecksumAddress(address);
        }

        if (QWWalletUtils.isQKCValidAddress(address)) {
            String ethAddress = address.substring(0, address.length() - 8);
            ethAddress = toChecksumAddress(ethAddress);

            String qkcShared = address.substring(address.length() - 8);
            String lowercaseAddress = qkcShared.toLowerCase();
            String addressHash = Numeric.cleanHexPrefix(Hash.sha3String(lowercaseAddress));

            StringBuilder result = new StringBuilder(lowercaseAddress.length());
            int count = 0;
            int start = 40;
            while (count < 8) {
                if (Integer.parseInt(String.valueOf(addressHash.charAt(start + count)), 16) >= 8) {
                    result.append(String.valueOf(lowercaseAddress.charAt(count)).toUpperCase());
                } else {
                    result.append(lowercaseAddress.charAt(count));
                }
                count++;
            }
            return ethAddress + result.toString();
        }

        return address;
    }

    public static byte[] serialize(ECKeyPair ecKeyPair) {
        byte[] privateKey = Numeric.toBytesPadded(ecKeyPair.getPrivateKey(), PRIVATE_KEY_SIZE);
        byte[] publicKey = Numeric.toBytesPadded(ecKeyPair.getPublicKey(), PUBLIC_KEY_SIZE);

        byte[] result = Arrays.copyOf(privateKey, PRIVATE_KEY_SIZE + PUBLIC_KEY_SIZE);
        System.arraycopy(publicKey, 0, result, PRIVATE_KEY_SIZE, PUBLIC_KEY_SIZE);
        return result;
    }

    public static ECKeyPair deserialize(byte[] input) {
        if (input.length != PRIVATE_KEY_SIZE + PUBLIC_KEY_SIZE) {
            throw new RuntimeException("Invalid input key size");
        }

        BigInteger privateKey = Numeric.toBigInt(input, 0, PRIVATE_KEY_SIZE);
        BigInteger publicKey = Numeric.toBigInt(input, PRIVATE_KEY_SIZE, PUBLIC_KEY_SIZE);

        return new ECKeyPair(privateKey, publicKey);
    }
}
