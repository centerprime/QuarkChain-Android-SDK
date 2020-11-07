package com.centerprime.quarkchainsdk.quarck;

import java.math.BigInteger;
import java.util.HashMap;

public class Constant {
    public interface ErrorCode {
        int UNKNOWN = 1;
        int CANT_GET_STORE_PASSWORD = 2;
        int WALLET_EXIT = 3;//钱包存在
        int PRIVATE_NOT_WIF_COM = 4;//私钥不是压缩格式
        int KEYSTORE_ERROR = 5;//keystore类型错误
    }

    public static final String KEY_WALLET = "key_wallet";
    public static final String KEY_BALANCE = "key_balance";
    public static final String KEY_TRANSACTION = "key_transaction";
    public static final String KEY_TOKEN = "key_token";

    public static final String KEY_COIN = "key_coin";
    public static final String KEY_FLASH = "key_flash";

    public static final String WALLET_KEY = "wallet_key";
    public static final String WALLET_ADDRESS = "wallet_address";
    public static final String IS_EXPORT_PHRASE = "is_export_phrase";
    public static final String KEY_WALLET_ICON_PATH = "key_wallet_icon_path";
    public static final String KEY_CHOOSE_NEW_WALLET = "key_choose_new_wallet";
    public static final String KEY_CHOOSE_WALLET = "key_choose_wallet";
    public static final String KEY_DELETE_WALLET = "key_delete_wallet";
    public static final String KEY_ACCOUNT_TYPE = "key_account_type";
    public static final String KEY_CHANGE_BTC_ACCOUNT = "key_change_btc_account";

    public static final String KEY_MNEMONIC = "key_mnemonic";
    public static final String KEY_PASSWORD = "key_password";
    public static final String KEY_PASSWORD_HINT = "key_password_hint";

    public static final String KEY_TOKEN_SYMBOL = "key_token_symbol";
    public static final String KEY_TOKEN_SCALE = "key_token_scale";
    public static final String KEY_TOKEN_ADDRESS = "key_token_address";
    public static final String KEY_TOKEN_NETWORK_ID = "key_token_network_id";

    public static final String KEY_NOT_TOAST = "key_not_toast";
    public static final String KEY_FROM = "key_from";

    public static final String KEY_TRANSACTION_HASH = "key_transaction_hash";


    public static final String KEY_RESULT = "key_result";
    public static final String KEY_CHANGE_SHARD = "key_change_shard";

    public static final String KEY_CURRENT_TYPE = "key_current_type";
    public static final String KEY_SHOW_ONLY_TYPE = "key_show_only_type";

    public static final String KEY_CAPTURE_FOR_RESULT = "key_capture_for_result";
    public static final String KEY_CAPTURE_ONLY_SCAN = "key_capture_only_scan";
    public static final String KEY_CAPTURE_WATCH = "key_capture_watch";

    public static final String KEY_COLD_MODE = "key_cold_mode";

    public static final String KEY_ACCOUNT = "key_account";

//    //钱包头像
//    public static final int[] WALLET_ICON_IDS = new int[]{
//            R.drawable.icon_001,
//            R.drawable.icon_002,
//            R.drawable.icon_003,
//            R.drawable.icon_004,
//            R.drawable.icon_005,
//            R.drawable.icon_006,
//            R.drawable.icon_007,
//            R.drawable.icon_008,
//            R.drawable.icon_009,
//            R.drawable.icon_010,
//            R.drawable.icon_011,
//            R.drawable.icon_012
//    };

    public static final int REQUEST_CODE_EDIT_WALLET = 1000;
    public static final int REQUEST_CODE_EDIT_ICON = 1001;
    public static final int REQUEST_CODE_SEND_TRANSACTIONS = 1002;
    public static final int REQUEST_CODE_QCK_MERGE = 1004;

    public static final int REQUEST_CODE_SEND_QCK_MERGE = 2001;
    public static final int REQUEST_CODE_SEND_TOKEN_MERGE = 2002;
    public static final int REQUEST_CODE_SEND_PUBLIC_MERGE = 2003;

    public static final int REQUEST_CODE_SEND_TOKEN_SWITCH = 2004;
    public static final int REQUEST_CODE_SEND_PUBLIC_SWITCH = 2005;

    public static final int REQUEST_CODE_SWITCH_QR_BITMAP = 2008;

    public static final int REQUEST_CODE_CHANGE_LANGUAGE = 2009;

    public static final int REQUEST_CODE_ADD_TOKEN = 2010;

    public static final int REQUEST_CODE_FREEZE_TRX = 2012;

    public static final int REQUEST_CODE_CAPTURE = 2014;

    public static final int REQUEST_CODE_ADDRESS_BOOK = 2017;//地址本

    public static final int REQUEST_CODE_LOCK_APP_WALLET = 2018;
    public static final int REQUEST_CODE_LOCK_APP_SETTING = 2019;//地址本

    public static final String FROM_WALLET_MANAGER = "from_wallet_manager";

    public static final String QR_ETH_TITLE = "ethereum:";
    public static final String QR_TRX_TITLE = "tron:";
    public static final String QR_QKC_TITLE = "quarkchain:";
    public static final String QR_CONTRACT_ADDRESS = "contractAddress=";
    public static final String QR_NETWORK_ID = "networkId=";
    public static final String QR_DECIMAL = "decimal=";
    public static final String QR_VALUE = "value=";
    public static final String QR_AMOUNT = "amount=";

    //********************ETH*********************
    //ETh 节点地址
    public static final String ETH_PUBLIC_PATH_MAIN = "https://mainnet.infura.io/v3/d2f682d99e994090b76e26c7916100d8";
    public static final String ETH_PUBLIC_PATH_ROPSTEN = "https://ropsten.infura.io/v3/d2f682d99e994090b76e26c7916100d8";
    public static final String ETH_PUBLIC_PATH_KOVAN = "https://kovan.infura.io/v3/d2f682d99e994090b76e26c7916100d8";
    public static final String ETH_PUBLIC_PATH_RINKBY = "https://rinkeby.infura.io/v3/d2f682d99e994090b76e26c7916100d8";
    public static final int ETH_PUBLIC_PATH_MAIN_INDEX = 1;
    public static final int ETH_PUBLIC_PATH_ROPSTEN_INDEX = 3;
    public static final int ETH_PUBLIC_PATH_KOVAN_INDEX = 42;
    public static final int ETH_PUBLIC_PATH_RINKBY_INDEX = 4;
    public static final String ETH_PUBLIC_PATH_SCAN_MAIN_CN = "http://api-cn.etherscan.com/";
    public static final String ETH_PUBLIC_PATH_SCAN_MAIN = "https://api.etherscan.io/";
    public static final String ETH_PUBLIC_PATH_SCAN_ROPSTEN = "https://api-ropsten.etherscan.io/";
    public static final String ETH_PUBLIC_PATH_SCAN_KOVAN = "https://api-kovan.etherscan.io/";
    public static final String ETH_PUBLIC_PATH_SCAN_RINKBY = "https://api-rinkeby.etherscan.io/";
    public static final String ETH_SCAN_API_KEY = "GPS2H1PAD8GU4TYNXMT8UI99VAND5TNDG1";
    public static final String ETH_PUBLIC_PATH_MAIN_NAME = "Mainnet";
    public static final String ETH_PUBLIC_PATH_ROPSTEN_NAME = "Ropsten testnet";
    public static final String ETH_PUBLIC_PATH_KOVAN_NAME = "Kovan testnet";
    public static final String ETH_PUBLIC_PATH_RINKBY_NAME = "Rinkeby testnet";

    public static String sEthNetworkPath = ETH_PUBLIC_PATH_MAIN;
    public static long sETHNetworkId = ETH_PUBLIC_PATH_MAIN_INDEX;//1-4


    //********************QUARKCHAIN*********************
    //QKC 节点地址
    public static final int QKC_PUBLIC_MAIN_INDEX = 1;
    public static final int QKC_PUBLIC_DEVNET_INDEX = 255;

    public static final String QKC_PUBLIC_PATH_DEVNET_NAME = "devnet testnet";

    public static final String QKC_PUBLIC_PATH_MAIN = "http://jrpc.mainnet.quarkchain.io:38391";
    public static final String QKC_PUBLIC_PATH_DEVNET = "http://jrpc.devnet.quarkchain.io:38391";

    public final static String PATH_QKC_DONATE = "https://devnet.quarkchain.io/donate";//抽奖接口

    public static String sTransactionNext;
//    public static BigInteger sGasLimit = Numeric.toBigInt("0x7530");

    public static BigInteger sNetworkId = new BigInteger(String.valueOf(QKC_PUBLIC_MAIN_INDEX));
    public static String sQKCNetworkPath = QKC_PUBLIC_PATH_MAIN;


    public static final String QKC_TRANSACTION_STATE_SEND = "send";
    public static final String QKC_TRANSACTION_STATE_RECEIVE = "receive";
    public static final String QKC_TRANSACTION_STATE_PENDING = "pending";
    public static final String QKC_TRANSACTION_STATE_FREEZE = "freeze";
    public static final String QKC_TRANSACTION_STATE_UNFREEZE = "unfreeze";
    public static final String QKC_TRANSACTION_STATE_VOTE = "vote";
    public static final String QKC_TRANSACTION_STATE_CONTRACT = "contract";

    public static final String TOKEN_TRANSACTION_STATE_SEND = "send";
    public static final String TOKEN_TRANSACTION_STATE_BUY = "buy";

    public static final String QKC_TRANSACTION_LIMIT = "0xa";
    public static final int QKC_TRANSACTION_LIMIT_INT = 10;
    public static final String DEFAULT_GAS_PRICE = "10000000000";
    public static final String DEFAULT_GAS_TOKEN_LIMIT = "1000000";
    public static final String DEFAULT_GAS_PRICE_TO_GWEI = "10";
    public static final String DEFAULT_GAS_LIMIT = "30000";
    public static final String DEFAULT_CHINA_ID = "0x0";

    public static final String DEFAULT_PENDING_TIME = "--/--/---- --:--:--";

    public static final String FEEDBACK_EMAIL = "mailto:support@qpocket.io";

    public static final HashMap<String, String> sPasswordHintMap = new HashMap<>();


    public static boolean sIsChangeLanguage = false;

    public static final int RX_BUS_CODE_TOKEN = 1112;
    public static final int RX_BUS_CODE_TRANS_COST = 1113;
    public static final int RX_BUS_CODE_PUBLIC_SALE = 1114;

    public static final String IS_RESULT_BACKUP_PHRASE = "is_result_backup_phrase";
    public static final int RESULT_CODE_BACKUP_PHRASE = 1110;
    public static final int RX_BUS_CODE_BACKUP_PHRASE = 1115;

    public static final int MAX_AVAILABLE_TIMES = 3;

    //钱包类型
    public static final int WALLET_TYPE_HD = 0;
    public static final int WALLET_TYPE_QKC = 1;
    public static final int WALLET_TYPE_ETH = 2;
    public static final int WALLET_TYPE_TRX = 3;

    //Account类型
    public static final int ACCOUNT_TYPE_QKC = WALLET_TYPE_QKC;
    public static final int ACCOUNT_TYPE_ETH = WALLET_TYPE_ETH;
    public static final int ACCOUNT_TYPE_TRX = WALLET_TYPE_TRX;

    //钱包地址编码
    public static final int HD_PATH_CODE_ETH = 60;
    public static final int HD_PATH_CODE_QKC = 99999999;
    public static final int HD_PATH_CODE_TRX = 195;

    public static final int DONATE_COUNT = 3;//抽奖次数

    public static final int ERC_TOKEN_SEARCH_LIMIT = 30;//分页

    //token加载方式
    public static final int TOKEN_LIST_TYPE_LOAD_DB = 100;//获取db
    public static final int TOKEN_LIST_TYPE_LOAD_NOT_NULL = 101;//db为空进行网络拉取
    public static final int TOKEN_LIST_TYPE_LOAD_NET = 102;//网络拉取


    public static final String[] NOT_SUPPORT_PHONE_COUNTRY = new String[]{
            "US",//美国
            "YE",//Yemen 也门
            "VE",//Venezuela 委内瑞拉
            "LY",//Libya 利比亚
            "LB",//Lebanon 黎巴嫩
            "CF",//Central African Republic 中非共和国
            "ZW",//津巴布韦 Zimbabwe
            "SY",//叙利亚 Syria
            "SD",//苏丹	 Sudan
            "KP",//朝鲜	 North Korea
            "LR",//利比里亚	 Liberia
            "IQ",//伊拉克	 Iraq
            "IR",//伊朗	 Iran
            "CU",//古巴	 Cuba
            "MM",//缅甸	 Burma
            "BY",//白俄罗斯	 Belarus
            "SS",//南苏丹 South Sudan
            "SO",//索马里 Somalia
            "CI",//科特迪瓦 Cote D'Ivoire
            "CG",//刚果 Democratic Republic of Congo
            "RS",//塞尔维亚 Serbia
            "AL",//阿尔巴尼亚 Albania
            "MD",//摩尔多瓦 Moldova
            "HR",//克罗地亚 Croatia
            "MK",//马其顿 Macedonia
            "BA",//波斯尼亚 黑塞哥维那 Bosnia and Herzegovina
            "XK",//科索沃 Kosovo
    };

    public static final String NONE = "NONE";
    public static final String NOT_SUPPORT_DAPP_COUNTRY = "SG";//新加坡

    public static final long ONE_DAY_TIME = 24 * 60 * 60 * 1000;

    public final static String HTTP = "http://";
    public final static String HTTPS = "https://";
    public final static int MAX_SHOW_HISTORY = 10;


    public static final String CURRENT_ACCOUNT_ADDRESS = "current_account_address";

    public static final String TX_ETH_HASH_PATH = "https://etherscan.io/tx/";
    public static final String TX_ETH_ROPSTEN_HASH_PATH = "https://ropsten.etherscan.io/tx/";
    public static final String TX_ETH_KOVAN_HASH_PATH = "https://kovan.etherscan.io/tx/";
    public static final String TX_ETH_RINKEBY_HASH_PATH = "https://rinkeby.etherscan.io/tx/";
    public static final String TX_TRX_HASH_PATH = "https://tronscan.org/#/transaction/";
    public static final String TX_QKC_HASH_PATH = "http://mainnet.quarkchain.io/tx/";
    public static final String TX_QKC_HASH_DEVNET_PATH = "http://devnet.quarkchain.io/tx/";

    //*********************tron*******************
    public static final int TRX_MAIN_NETWORK = 1;
    public static final int TRX_TEST_SHASTA_NETWORK = 2;

    //jsonRpc
    public static final String TRON_MAIN_NET_PATH = "https://api.trongrid.io/wallet/";
    public static final String TRON_MAIN_NET_METHOD_TRIGGER_SMART = "triggersmartcontract";

    //GRPC
    public static final String TRON_MAIN_NET_GRPC_PATH = "grpc.trongrid.io:50051";
    public static final String TRON_MAIN_NET_GRPC_SOLIDITY_PATH = "grpc.trongrid.io:50052";

    //tron交易记录
    public static final String TRON_PUBLIC_PATH_SCAN_MAIN = "https://apilist.tronscan.org/";

    public static final int TRX_CONTRACT_TYPE_TRANSFER = 1;
    public static final int TRX_CONTRACT_TYPE_TRANSFER_TOKEN = 2;
    public static final int TRX_CONTRACT_TYPE_VOTE_ASSET = 3;
    public static final int TRX_CONTRACT_TYPE_VOTE_WITNESS = 4;
    public static final int TRX_CONTRACT_TYPE_FROZEN = 11;
    public static final int TRX_CONTRACT_TYPE_UNFROZEN = 12;
    public static final int TRX_CONTRACT_TYPE_SMART = 31;


    //获取指定Coin的指定币种价格
    public static final String MARKET_API_PATH_COIN_PRICE = "https://api.coingecko.com/api/v3/simple/price?ids=%s&vs_currencies=%s";
    //货币详情
    //https://github.com/RubyMoney/money/blob/48ddaf849b389f50d4396205a318729a9b768b9e/config/currency_iso.json
    //市值行情支持的币种
    public static final String[] MARKET_PRICE_COINS = new String[]{
            "btc",
            "eth",

            "usd", //美元
            "cny", //人民币
            "eur", //欧元
            "krw", //韩元
            "idr", //印度尼西亚卢比
            "inr", //印度卢比
            "rub", //俄罗斯卢布
            "uah", //乌克兰格里夫纳
            "vnd", // 越南盾

            "aed", //阿联酋迪拉姆
            "ars", //阿根廷比索
            "aud", //澳大利亚元
            "bdt", //孟加拉塔卡
            "bhd", //巴林第纳尔
            "bmd", //百慕大美元
            "brl", //巴西雷亚尔
            "cad", //加拿大元
            "chf",
            "clp",
            "czk",
            "dkk",
            "gbp", //英镑
            "hkd",
            "huf",
            "ils",
            "jpy", //日元
            "kwd",
            "lkr",
            "mmk",
            "mxn",
            "myr",
            "nok",
            "nzd",
            "php",
            "pkr",
            "pln",
            "sar",
            "sek",
            "sgd",
            "thb",
            "try",
            "twd",
            "vef",
            "zar"
    };
    public static final String PRICE_ABOUT = "≈ ";
    public static final String ETH_GAS_API = "https://ethgasstation.info/json/ethgasAPI.json";


    public static final String TRX_FIRST_BAND_WITH_ADDRESS = "TLoZPekn8DPyDWt8XRXPKHKu8uiSen8eHf";
    public static final String ETH_FIRST_GAS_LIMIT_ADDRESS = "0xDE484d10c3A33Ee60E371Ad2ae1961a864AA12CC";

    //********************Banner分类***************************
    public static final int BANNER_TYPE_DAPP = 1;
    public static final int BANNER_TYPE_WEALTH = 2;
    public static final int BANNER_TYPE_AIRDROP = 3;

    //DApp数据类型
    public static final String WEALTH_TYPE_DEFI = "defi";
    public static final String WEALTH_ABOUT = "~";

    //********************锁屏界面***************************
    public static final int APP_LOCK_TIME = 1000 * 60;

    public static boolean sLockAppWait = false;
    public static long sUnlockAppTime = 0;

//    public static boolean isCanLock(Context context) {
//        if (sLockAppWait) {
//            long timeEnd = new Date().getTime();
//            if (timeEnd - sUnlockAppTime >= APP_LOCK_TIME) {
//                int index = SharedPreferencesUtils.getAppLockState(context);
//                return index == UnlockManagerActivity.APP_LOCK_STATE_WALLET
//                        && SharedPreferencesUtils.isSupportFingerprint(context)
//                        && new FingerprintIdentify(context).isFingerprintEnable()
//                        && MainApplication.havePasswordWallet();
//            }
//        }
//        return false;
//    }

    public static final String QKC_NATIVE_TOKEN_INFO_ADDRESS = "0x514b43000000000000000000000000000000000200000000";
    public static final String QKC_NATIVE_TOKEN_RESERVE = "0x514B430000000000000000000000000000000003";
    public static final String EMPTY_ADDRESS = "0x0000000000000000000000000000000000000000";
    public static final int QKC_DECIMAL_NUMBER = 9;
}
