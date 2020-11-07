package com.centerprime.quarkchainsdk;

import android.content.Context;
import android.util.Pair;

import com.centerprime.quarkchainsdk.quarck.Constant;
import com.centerprime.quarkchainsdk.quarck.Hash;
import com.centerprime.quarkchainsdk.quarck.QWToken;
import com.centerprime.quarkchainsdk.quarck.QWTokenDao;
import com.centerprime.quarkchainsdk.quarck.QWWalletUtils;
import com.centerprime.quarkchainsdk.quarck.Sign;
import com.centerprime.quarkchainsdk.quarck.response.QKCGetAccountData;
import com.centerprime.quarkchainsdk.quarck.response.QKCSendRawTransaction;
import com.centerprime.quarkchainsdk.util.BalanceUtils;
import com.centerprime.quarkchainsdk.util.CenterPrimeUtils;
import com.centerprime.quarkchainsdk.util.Const;
import com.centerprime.quarkchainsdk.util.Erc20TokenWrapper;
import com.centerprime.quarkchainsdk.util.HyperLedgerApi;
import com.centerprime.quarkchainsdk.util.SubmitTransactionModel;
import com.centerprime.quarkchainsdk.util.Wallet;

import org.spongycastle.util.encoders.Hex;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ChainId;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.response.NoOpProcessor;
import org.web3j.tx.response.TransactionReceiptProcessor;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CenterPrime on 2020/09/19.
 */
public class QCKManager {
    private static final QCKManager ourInstance = new QCKManager();


    /**
     * Web3j Client
     */
    private Web3j web3j;


    private HyperLedgerApi hyperLedgerApi;

    /**
     * QCK node url
     */
    private String QKC_PUBLIC_PATH_MAIN = "";

    public static QCKManager getInstance() {
        return ourInstance;
    }

    public QCKManager() {
    }

    /**
     * Initialize EthManager
     *
     * @param qckMainnetUrl : QCK Url
     */
    public void init(String qckMainnetUrl) {
        this.QKC_PUBLIC_PATH_MAIN = qckMainnetUrl;
        web3j = Web3jFactory.build(new HttpService(QKC_PUBLIC_PATH_MAIN, false));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://34.231.96.72:8081")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        hyperLedgerApi = retrofit.create(HyperLedgerApi.class);
    }

    /**
     * Create Wallet by password
     */
    public Single<Wallet> createWallet(String password, Context context) {
        return Single.fromCallable(() -> {
            try {
                HashMap<String, Object> body = new HashMap<>();
                body.put("action_type", "WALLET_CREATE");
                body.put("message", "Test");
                sendEventToLedger(body);
                String walletAddress = CenterPrimeUtils.generateNewWalletFile(password, new File(context.getFilesDir(), ""), false);
                String walletPath = context.getFilesDir() + "/" + walletAddress.toLowerCase();
                File keystoreFile = new File(walletPath);
                String keystore = read_file(context, keystoreFile.getName());
                return new Wallet(walletAddress, keystore);
            } catch (CipherException | IOException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | NoSuchProviderException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    /**
     * Get Keystore by wallet address
     */
    public Single<String> getKeyStore(String walletAddress, Context context) {
        return Single.fromCallable(() -> {
            String walletPath = context.getFilesDir() + "/" + walletAddress.toLowerCase();
            File keystoreFile = new File(walletPath);
            if (keystoreFile.exists()) {
                return read_file(context, keystoreFile.getName());
            } else {
                return null;
            }
        });
    }

    /**
     * Import Wallet by Keystore
     */
    public Single<String> importFromKeystore(String keystore, String password, Context context) {
        return Single.fromCallable(() -> {
            try {
                Credentials credentials = CenterPrimeUtils.loadCredentials(password, keystore);
                String walletAddress = CenterPrimeUtils.generateWalletFile(password, credentials.getEcKeyPair(), new File(context.getFilesDir(), ""), false);

                HashMap<String, Object> body = new HashMap<>();
                body.put("action_type", "WALLET_IMPORT_KEYSTORE");
                body.put("message", "TEST");
                sendEventToLedger(body);

                return walletAddress;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    /**
     * Import Wallet with Private Key
     */
    public Single<String> importFromPrivateKey(String privateKey, Context context) {
        return Single.fromCallable(() -> {
            String password = "";
            // Decode private key
            ECKeyPair keys = ECKeyPair.create(Hex.decode(privateKey));
            try {
                Credentials credentials = Credentials.create(keys);
                String walletAddress = CenterPrimeUtils.generateWalletFile(password, credentials.getEcKeyPair(), new File(context.getFilesDir(), ""), false);

                HashMap<String, Object> body = new HashMap<>();
                body.put("action_type", "WALLET_IMPORT_PRIVATE_KEY");
                body.put("message", "TEST");
                sendEventToLedger(body);

                return walletAddress;
            } catch (CipherException | IOException e) {
                e.printStackTrace();
            }
            return null;
        });
    }


    /**
     * Load Credentials
     */
    public Single<Credentials> loadCredentials(String walletAddress, String password, Context context) {
        return getKeyStore(walletAddress, context)
                .flatMap(keystore -> {
                    try {
                        Credentials credentials = CenterPrimeUtils.loadCredentials(password, keystore);
                        return Single.just(credentials);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return Single.error(e);
                    } catch (CipherException e) {
                        e.printStackTrace();
                        return Single.error(e);
                    }
                });
    }

    /**
     * Get ERC20 Token Balance of Wallet
     */
    public Single<BigDecimal> getTokenBalance(String walletAddress, String password, String tokenContractAddress, Context context) {
        return loadCredentials(walletAddress, password, context)
                .flatMap(credentials -> {
                    TransactionReceiptProcessor transactionReceiptProcessor = new NoOpProcessor(web3j);
                    TransactionManager transactionManager = new RawTransactionManager(
                            web3j, credentials, ChainId.MAINNET, transactionReceiptProcessor);
                    Erc20TokenWrapper contract = Erc20TokenWrapper.load(tokenContractAddress, web3j,
                            transactionManager, BigInteger.ZERO, BigInteger.ZERO);
                    Address address = new Address(walletAddress);
                    Uint256 tokenBalance = contract.balanceOf(address);

                    HashMap<String, Object> body = new HashMap<>();
                    body.put("action_type", "GET_TOKEN_BALANCE");
                    body.put("message", "TEST");
                    sendEventToLedger(body);

                    return Single.just(BalanceUtils.weiToEth(tokenBalance.getValue()));
                });
    }

    /**
     * Get Nonce for Current Wallet Address
     */
    protected BigInteger getNonce(String walletAddress) throws IOException {
        EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(
                walletAddress, DefaultBlockParameterName.PENDING).send();

        return ethGetTransactionCount.getTransactionCount();
    }

    public String read_file(Context context, String filename) throws IOException {
        FileInputStream fis = context.openFileInput(filename);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    public String getQCKAddress(String address, Context context) {
        return com.centerprime.quarkchainsdk.quarck.Numeric.parseAddressToQuark(address, context);
    }

    public String getQCKAddressByChainIdAndShardId(String address, long chainId, long shardId, Context context) {
        return com.centerprime.quarkchainsdk.quarck.Numeric.selectChainAndShardAddress(address, chainId, shardId, context);
    }

    public Single<QKCGetAccountData.AccountData> getQCKBalance(String address) {
        return Single.fromCallable(() -> com.centerprime.quarkchainsdk.quarck.Web3jFactory
                .build(new com.centerprime.quarkchainsdk.quarck.HttpService(QKC_PUBLIC_PATH_MAIN, false))
                .getAccountData(address)
                .send()
                .getQKCGetAccountData())
                .subscribeOn(Schedulers.io());
    }

    public Single<Pair<BigInteger, BigInteger>> getPrivateKeyForQW(String walletAddress, String password, Context context) {
        return loadCredentials(walletAddress, password, context)
                .flatMap(credentials -> {
                    BigInteger privateKey = credentials.getEcKeyPair().getPrivateKey();
                    BigInteger publicKey = credentials.getEcKeyPair().getPublicKey();
                    return Single.just(new Pair<>(privateKey, publicKey));
                });
    }

    /**
     * @param fromQWAddress : Numeric.parseAddressToQuark(wallet.getPubKey());
     * @param toQWAddress   : receiver address
     * @param gasPrice      :  QWWalletUtils.toGWeiFrom10("amount");
     * @param gasLimit      : new BigInteger("amount")
     * @param value         : must be string
     * @param context
     */
    public Single<String> sendQCKToken(String walletAddress, String password, String fromQWAddress, String toQWAddress, BigInteger gasPrice,
                                          BigInteger gasLimit,
                                          String value, Context context) {
        return getPrivateKeyForQW(walletAddress, password, context)
                .flatMap(cred -> {

                    BigInteger nonce = com.centerprime.quarkchainsdk.quarck.Web3jFactory.build(new com.centerprime.quarkchainsdk.quarck.HttpService(QKC_PUBLIC_PATH_MAIN))
                            .getTransactionCount(fromQWAddress)
                            .send()
                            .getTransactionCount();

                    QWToken mToken = QWTokenDao.getTQKCToken();
                    BigInteger amount = QWWalletUtils.toWeiFrom10(value, mToken.getTokenUnit());
                    String data = "";
                    BigInteger networkId = Constant.sNetworkId;

                    String DEFAULT_TOKEN_ID = "0x8bb0";
                    BigInteger transferToken = Numeric.toBigInt(DEFAULT_TOKEN_ID);
                    BigInteger gasToken = Numeric.toBigInt(DEFAULT_TOKEN_ID);

                    String fromAddress = fromQWAddress.substring(0, fromQWAddress.length() - 8);
                    String fromShardStr = fromQWAddress.substring(fromQWAddress.length() - 8);

                    BigInteger fromShard = Numeric.toBigInt(fromShardStr);

                    String toAddress = toQWAddress.substring(0, toQWAddress.length() - 8);
                    String toShardStr = toQWAddress.substring(toQWAddress.length() - 8);
                    BigInteger toShard = Numeric.toBigInt(toShardStr);

                    com.centerprime.quarkchainsdk.quarck.RawTransaction rawTransaction = com.centerprime.quarkchainsdk.quarck.RawTransaction.createTransaction(nonce, gasPrice, gasLimit, toAddress, amount, fromShard, toShard,
                            data, networkId, transferToken, gasToken);

                    byte[] encoded = com.centerprime.quarkchainsdk.quarck.TransactionEncoder.encode(rawTransaction);
                    byte[] hashed = Hash.sha3(encoded);
                    System.out.println("S1 : " + Numeric.toHexString(hashed));
                    System.out.println("S2 : " + Numeric.toHexString(encoded));

                    BigInteger privateKey = cred.first;
                    BigInteger publicKey = cred.second;
                    com.centerprime.quarkchainsdk.quarck.ECKeyPair ecKeyPair = new com.centerprime.quarkchainsdk.quarck.ECKeyPair(privateKey, publicKey);
                    com.centerprime.quarkchainsdk.quarck.Credentials quarkCredentials = com.centerprime.quarkchainsdk.quarck.Credentials.create(ecKeyPair);

                    Sign.SignatureData signatureData = Sign.signMessage(hashed, quarkCredentials.getEcKeyPair(), false);

                    encoded = com.centerprime.quarkchainsdk.quarck.TransactionEncoder.encode(rawTransaction, BigInteger.ZERO, signatureData);
                    hashed = Hash.sha3(encoded);


                    String[] result = new String[]{
                            Numeric.toHexString(hashed), Numeric.toHexString(encoded)
                    };

                    System.out.println("S1! : " + Numeric.toHexString(hashed));
                    System.out.println("S2! : " + Numeric.toHexString(encoded));


                    System.out.println("Q_NONCE : " + nonce.toString());
                    System.out.println("Q_GAS_PRICE : " + gasPrice.toString());
                    System.out.println("Q_GAS_LIMIT : " + gasLimit.toString());
                    System.out.println("Q_AMOUNT : " + amount.toString());
                    System.out.println("Q_TRANSFER_TOKEN : " + transferToken.toString());
                    System.out.println("Q_GAS_TOKEN : " + gasToken.toString());
                    System.out.println("Q_DATA : " + data);
                    System.out.println("Q_NETWORK_ID : " + networkId.toString());
                    System.out.println("Q_fromShard : " + fromShard.toString());
                    System.out.println("Q_toAddress : " + toQWAddress);
                    System.out.println("Q_fromAddress : " + fromQWAddress);
                    System.out.println("Q_toShard : " + toShard.toString());


                    // TODO result[0] -> sign transaction Hash
                    // TODO result[1] -> encoded transaction Hash

                    QKCSendRawTransaction raw = com.centerprime.quarkchainsdk.quarck.Web3jFactory.build(new com.centerprime.quarkchainsdk.quarck.HttpService(QKC_PUBLIC_PATH_MAIN, true))
                            .sendRawTransaction(result[1])
                            .send();
                    if (raw.hasError()) {
                        System.out.println("ERROR : " + raw.getError().toString());
                    }
                    String resultHash = raw.getTransactionHash();

                    return Single.just(resultHash);
                });
    }

    private void sendEventToLedger(HashMap<String, Object> map) {
        try {
            SubmitTransactionModel submitTransactionModel = new SubmitTransactionModel();
            submitTransactionModel.setTx_type("QUARKCHAIN");
            submitTransactionModel.setUsername("user1");
            submitTransactionModel.setOrgname("org1");
            submitTransactionModel.setBody(map);
            hyperLedgerApi.submitTransaction(submitTransactionModel)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe((objectBaseResponse, throwable) -> {
                        System.out.println(objectBaseResponse);
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
