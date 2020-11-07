package com.centerprime.quarkchainsdk.quarck;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.security.SecureRandom;

//import com.google.common.collect.ImmutableList;
//import com.quarkonium.qpocket.bip32.ExtendedPrivateKey;
//import com.quarkonium.qpocket.bip32.networks.Bitcoin;

//import io.github.novacrypto.bip39.SeedCalculator;
//import io.github.novacrypto.bip44.AddressIndex;
//import io.github.novacrypto.bip44.BIP44;

/**
 * Utility functions for working with Wallet files.
 */
public class WalletUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final SecureRandom secureRandom = SecureRandomUtils.secureRandom();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


//    //生成初始助记词随机数
//    public static String createNewMnemonic(Context context) {
//        byte[] initialEntropy = new byte[16];
//        secureRandom.nextBytes(initialEntropy);
//        return MnemonicUtils.generateMnemonic(context, initialEntropy);
//    }
//
//    public static String changeMnemonic(Context context, String mnemonic, Locale locale) {
//        byte[] initialEntropy = MnemonicUtils.generateEntropy(context, mnemonic);
//        return MnemonicUtils.generateMnemonic(context, initialEntropy, locale);
//    }
//
//    public static Credentials loadCredentials(String password, String source)
//            throws IOException, CipherException {
//        return loadCredentials(password, new File(source));
//    }
//
//    public static Credentials loadCredentials(String password, File source)
//            throws IOException, CipherException {
//        WalletFile walletFile = objectMapper.readValue(source, WalletFile.class);
//        return Credentials.create(Wallet.decrypt(password, walletFile));
//    }
//
//    public static Credentials loadBip39Credentials(String password, String mnemonic) {
//        byte[] seed = MnemonicUtils.generateSeed(mnemonic, password);
//        return Credentials.create(ECKeyPair.create(Hash.sha256(seed)));
//    }

    public static String getDefaultKeyDirectory() {
        return getDefaultKeyDirectory(System.getProperty("os.name"));
    }

    static String getDefaultKeyDirectory(String osName1) {
        String osName = osName1.toLowerCase();

        if (osName.startsWith("mac")) {
            return String.format(
                    "%s%sLibrary%sEthereum", System.getProperty("user.home"), File.separator,
                    File.separator);
        } else if (osName.startsWith("win")) {
            return String.format("%s%sEthereum", System.getenv("APPDATA"), File.separator);
        } else {
            return String.format("%s%s.ethereum", System.getProperty("user.home"), File.separator);
        }
    }

    public static String getTestnetKeyDirectory() {
        return String.format(
                "%s%stestnet%skeystore", getDefaultKeyDirectory(), File.separator, File.separator);
    }

    public static String getMainnetKeyDirectory() {
        return String.format("%s%skeystore", getDefaultKeyDirectory(), File.separator);
    }

    /**
     * Get keystore destination directory for a Rinkeby network.
     *
     * @return a String containing destination directory
     */
    public static String getRinkebyKeyDirectory() {
        return String.format(
                "%s%srinkeby%skeystore", getDefaultKeyDirectory(), File.separator, File.separator);
    }

    public static boolean isValidPrivateKey(String privateKey) {
        String cleanPrivateKey = Numeric.cleanHexPrefix(privateKey);
        return cleanPrivateKey.length() == Keys.PRIVATE_KEY_LENGTH_IN_HEX;
    }

    public static boolean isValidAddress(String input) {
        String cleanInput = Numeric.cleanHexPrefix(input);

        try {
            Numeric.toBigIntNoPrefix(cleanInput);
        } catch (NumberFormatException e) {
            return false;
        }

        return cleanInput.length() == Keys.ADDRESS_LENGTH_IN_HEX;
    }

    public static boolean isQKCValidAddress(String input) {
        String cleanInput = Numeric.cleanHexPrefix(input);

        try {
            Numeric.toBigIntNoPrefix(cleanInput);
        } catch (NumberFormatException e) {
            return false;
        }

        return cleanInput.length() == Keys.QKC_ADDRESS_SIZE;
    }

//    //获取私钥 长度为64
//    public static String getPrivateKeyByKeyStore(String password, String keyStore) {
//        try {
//            ECKeyPair ecKeyPair = Wallet.decrypt(password, keyStore);
//            return Numeric.toHexStringNoPrefixZeroPadded(ecKeyPair.getPrivateKey(), 64);
//        } catch (CipherException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//
//    //生成私钥
//    public static ECKeyPair generateKeyPair(int HDPathCode, int accountIndex, String mnemonics) {
//        // 1. we just need eth wallet for now
//        AddressIndex addressIndex = BIP44
//                .m()
//                .purpose44()
//                .coinType(HDPathCode)
//                .account(accountIndex)
//                .external()
//                .address(0);
//
//        // 2. calculate seed from mnemonics , then get master/root key ; Note that the bip39 passphrase we set "" for common
//        ExtendedPrivateKey rootKey = ExtendedPrivateKey.fromSeed(new SeedCalculator().calculateSeed(mnemonics, ""), Bitcoin.MAIN_NET);
//
//        // 3. get child private key deriving from master/root key
//        ExtendedPrivateKey childPrivateKey = rootKey.derive(addressIndex, AddressIndex.DERIVATION);
//
//        // 4. get key pair
//        byte[] privateKeyBytes = childPrivateKey.getKey();
//        return ECKeyPair.create(privateKeyBytes);
//    }
//
//    //生成hd钱包硬编码部分私钥
//    public static DeterministicKey generateBitCoinKeyPair(String path, String mnemonics) {
//        return generateBitCoinKeyPair(generatePath(path), mnemonics);
//    }
//
//    public static DeterministicKey generateBitCoinKeyPair(ImmutableList<ChildNumber> pathList, String mnemonics) {
//        try {
//            DeterministicSeed seed = new DeterministicSeed(mnemonics, null, "", 0L);
//            DeterministicKeyChain keyChain = DeterministicKeyChain.builder().seed(seed).build();
//            return keyChain.getKeyByPath(pathList, true);
//        } catch (UnreadableWalletException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    private static ImmutableList<ChildNumber> generatePath(String path) {
//        List<ChildNumber> list = new ArrayList<>();
//        for (String p : path.split("/")) {
//            if ("m".equalsIgnoreCase(p) || "".equals(p.trim())) {
//                continue;
//            } else if (p.charAt(p.length() - 1) == '\'') {
//                list.add(new ChildNumber(Integer.parseInt(p.substring(0, p.length() - 1)), true));
//            } else {
//                list.add(new ChildNumber(Integer.parseInt(p), false));
//            }
//        }
//
//        ImmutableList.Builder<ChildNumber> builder = ImmutableList.builder();
//        return builder.addAll(list).build();
//    }
//
//    public static ImmutableList<ChildNumber> generateParentPath(boolean segWit, boolean isTest, int accountIndex) {
//        //m/49'/0'/1'
//        //m/44'/1'/0'
//        List<ChildNumber> list = new ArrayList<>();
//        //bip标准
//        ////44,49
//        list.add(new ChildNumber(segWit ? 49 : 44, true));
//        //币种 btc主网0，测试网1
//        list.add(new ChildNumber(isTest ? 1 : 0, true));
//        //account
//        list.add(new ChildNumber(accountIndex, true));
//
//        ImmutableList.Builder<ChildNumber> builder = ImmutableList.builder();
//        return builder.addAll(list).build();
//    }
}
