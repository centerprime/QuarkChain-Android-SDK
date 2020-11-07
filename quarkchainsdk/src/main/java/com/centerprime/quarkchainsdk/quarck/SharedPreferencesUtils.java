package com.centerprime.quarkchainsdk.quarck;


import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SharedPreferencesUtils {

    private static final String NAME = "wallet_info";
    private static final String DONATE_NAME = "donate_info";

    private static final String APP_VERSION = "app_version";

    private static final String PARAM_INSTALL_APP = "install_app";
    private static final String PARAM_CHAIN_COUNT = "chain_info_count";
    private static final String PARAM_SHARD_SIZES = "shard_info_sizes";
    private static final String PARAM_CHAIN_CURRENT = "_current_chain";
    private static final String PARAM_SHARD_CURRENT = "_current_shard";
    private static final String PARAM_BACKUP = "_backup";

    private static final String PARAM_NEW_APP = "new_app";

    private static final String PARAM_LANGUAGE = "app_language_pref_key";

    private static final String PARAM_NEW_INSTALL = "new_install";
    private static final String PARAM_SUPPORT_FINGERPRINT = "support_fingerprint";
    private static final String PARAM_NEW_FINGERPRINT = "new_fingerprint";

    private static final String PARAM_NEW_ETH_NETWORK_INDEX = "eth_network_index";
    private static final String PARAM_NEW_QKC_NETWORK_INDEX = "qkc_network_index";

    private static final String PARAM_DAPP_SHOW_TIPS = "dapp_show_tips";
    private static final String PARAM_FIRST_QKC_DAPP_SHOW_TIPS = "first_qkc_dapp_show_tips";

    private static final String PARAM_TIME_DAPP_LIST = "time_dapp_list";
    private static final String PARAM_TIME_BANNER_LIST = "time_banner_list";
    private static final String PARAM_TIME_TOKEN_LIST = "time_token_list";
    private static final String PARAM_TIME_PUBLIC_SALE_LIST = "time_public_sale_list";

    private static final String PARAM_TIME_DAPP_TIME = "time_dapp_hot";
    private static final String PARAM_CLEAR_DAPP_SHOW_TIPS = "clear_dapp_show_tips";

    private static final String PARAM_COUNTRY_CODE = "param_country_code";

    private static final String PARAM_USER_TASK_LIST = "param_user_task_list";
    private static final String PARAM_USER_TASK_LIST_TIME = "param_user_task_list_time";

    private static final String PARAM_USER_INVITE_TASK_LIST = "param_user_invite_task_list";

    private static final String PARAM_DAPP_WHITE_LIST_TIPS = "param_dapp_white_list_tips";
    private static final String PARAM_DAPP_WHITE_LIST = "param_dapp_white_list";

    private static final String PARAM_MARKET_COIN = "param_market_coin";
    private static final String PARAM_CLEAR_COIN_SHOW_TIPS = "clear_coin_show_tips";
    private static final String PARAM_MARKET_TAP = "param_market_tap";

    private static final String PARAM_SIGN_COUNT = "param_sign_count";
    private static final String PARAM_TASK_CLAIM = "param_task_claim";
    private static final String PARAM_PUSH_ACCOUNT_ADDRESS = "param_push_account_address";


    private static final String PARAM_BTC_API_URL = "btc_api_url";
    private static final String PARAM_BTC_API_URL_TIME = "btc_api_url_time";

    private static final String PARAM_MAIN_TAB_INDEX = "main_tab_index";

    private static final String PARAM_APP_LOCK_STATE = "btc_app_lock_state";

    private static final String PARAM_APP_COLD_MODE = "app_cold_mode";

    private static final String PARAM_INSTALL_NOTIFY_PERMISSION = "install_notify_permission";
    private static final String PARAM_SEND_NOTIFY_PERMISSION = "send_notify_permission";

    private static final String PARAM_SHOW_COLD_DEPICT = "cold_depict";

    public static boolean isInstall(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getBoolean(PARAM_INSTALL_APP, false);
    }

    public static void setIsInstall(Context context, boolean install) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putBoolean(PARAM_INSTALL_APP, install).apply();

    }

    //是否全新安装
    public static boolean isNewApp(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getBoolean(PARAM_NEW_APP, false);
    }

    //是否全新安装
    public static void setNewApp(Context context, boolean value) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putBoolean(PARAM_NEW_APP, value).apply();

    }

    //获取分页下标
    public static String getCurrentTransactionNext(Context context, String address) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getString(address, "");
    }

    //设置分页下标
    public static void setCurrentTransactionNext(Context context, String address, String shard) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putString(address, shard).apply();

    }


    //获取是否有提示过备份
    public static boolean isBackupByKey(Context context, String key) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getBoolean(key + PARAM_BACKUP, false);
    }

    //设置是否有提示过备份
    public static void setBackupByKey(Context context, String key) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putBoolean(key + PARAM_BACKUP, true).apply();
    }

//    //获取当前语言
//    public static String getCurrentLanguages(Context context) {
//        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
//                .getString(PARAM_LANGUAGE, ConstantLanguages.AUTO);
//    }

    public static void setCurrentLanguages(Context context, String key) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putString(PARAM_LANGUAGE, key).apply();
    }


    //是否第一次安装
    public static boolean isNewInstallApp(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getBoolean(PARAM_NEW_INSTALL, true);
    }

    public static void setIsNewInstallApp(Context context) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putBoolean(PARAM_NEW_INSTALL, false).apply();
    }

    //是否第一次进行指纹校验
    public static boolean isNewInputFingerApp(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getBoolean(PARAM_NEW_FINGERPRINT, true);
    }

    public static void setNewInputFingerApp(Context context) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putBoolean(PARAM_NEW_FINGERPRINT, false).apply();
    }

    //是否打开指纹校验
    public static void setSupportFingerprint(Context context, boolean state) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putBoolean(PARAM_SUPPORT_FINGERPRINT, state).apply();
    }

    public static boolean isSupportFingerprint(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getBoolean(PARAM_SUPPORT_FINGERPRINT, false);
    }

    public static void setEthNetworkIndex(Context context, long value) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putLong(PARAM_NEW_ETH_NETWORK_INDEX, value).apply();
    }

    public static long getEthNetworkIndex(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getLong(PARAM_NEW_ETH_NETWORK_INDEX, Constant.ETH_PUBLIC_PATH_MAIN_INDEX);
    }


    public static void setQKCNetworkIndex(Context context, int value) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putInt(PARAM_NEW_QKC_NETWORK_INDEX, value).apply();
    }

    public static int getQKCNetworkIndex(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getInt(PARAM_NEW_QKC_NETWORK_INDEX, Constant.QKC_PUBLIC_MAIN_INDEX);
    }

    public static void setQKCDonateCount(Context context, String address, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DONATE_NAME, Context.MODE_PRIVATE);
        Map<String, ?> map = sharedPreferences.getAll();
        if (map != null) {
            Set<String> keys = map.keySet();
            for (String key : keys) {
                if (key.startsWith(address + "_data_")) {
                    sharedPreferences.edit().remove(key).apply();
                }
            }
        }

        String addressKey = address + "_data_" + getTimeAddress();
        sharedPreferences.edit().putInt(addressKey, value).apply();
    }

    public static int getQKCDonateCount(Context context, String address) {
        String addressKey = address + "_data_" + getTimeAddress();
        return context.getSharedPreferences(DONATE_NAME, Context.MODE_PRIVATE)
                .getInt(addressKey, 0);
    }

    //获取日期天数
    private static String getTimeAddress() {
        return TimeUtils.getStringDate(System.currentTimeMillis(), TimeUtils.DATE_FORMAT_DAY);
    }

    //dapp时间戳
    public static long getDAppListTime(Context context, String key) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getLong(PARAM_TIME_DAPP_LIST + key, 0);
    }

    public static void setDAppListTime(Context context, String key) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putLong(PARAM_TIME_DAPP_LIST + key, System.currentTimeMillis()).apply();
    }

    //banner时间戳
    public static long getBannerListTime(Context context, String key) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getLong(PARAM_TIME_BANNER_LIST + key, 0);
    }

    public static void setBannerListTime(Context context, String key) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putLong(PARAM_TIME_BANNER_LIST + key, System.currentTimeMillis()).apply();
    }

    //首页token列表
    public static long getTokenListTime(Context context, String key) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getLong(PARAM_TIME_TOKEN_LIST + key, 0);
    }

    public static void setTokenListTime(Context context, String key) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putLong(PARAM_TIME_TOKEN_LIST + key, System.currentTimeMillis()).apply();
    }

    //Public sale列表
    public static long getPublicSaleListTime(Context context, String typeName) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getLong(PARAM_TIME_PUBLIC_SALE_LIST + typeName, 0);
    }

    public static void setPublicSaleListTime(Context context, String typeName) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putLong(PARAM_TIME_PUBLIC_SALE_LIST + typeName, System.currentTimeMillis()).apply();
    }


    //显示DApp tips
    public static boolean isShowDAppTips(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getBoolean(PARAM_DAPP_SHOW_TIPS, true);
    }

    public static void setShowDAppTips(Context context) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putBoolean(PARAM_DAPP_SHOW_TIPS, false).apply();
    }

    //显示QKC DApp tips
    public static boolean isFirstShowQKCDAppTips(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getBoolean(PARAM_FIRST_QKC_DAPP_SHOW_TIPS, true);
    }

    public static void setFirstShowQKCShowDAppTips(Context context) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putBoolean(PARAM_FIRST_QKC_DAPP_SHOW_TIPS, false).apply();
    }

    //DApp热搜
    public static long getDAppHotTime(Context context, String name) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getLong(PARAM_TIME_DAPP_TIME + name, 0);
    }

    public static void setDAppHotTime(Context context, String name) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putLong(PARAM_TIME_DAPP_TIME + name, System.currentTimeMillis()).apply();
    }

    //DApp历史记录tips
    public static boolean isShowDAppClearTips(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getBoolean(PARAM_CLEAR_DAPP_SHOW_TIPS, true);
    }

    public static void setShowDAppClearTips(Context context) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putBoolean(PARAM_CLEAR_DAPP_SHOW_TIPS, false).apply();
    }

    //DApp历史记录tips
    public static boolean isShowMarketCoinClearTips(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getBoolean(PARAM_CLEAR_COIN_SHOW_TIPS, true);
    }

    public static void setShowMarketCoinClearTips(Context context) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putBoolean(PARAM_CLEAR_COIN_SHOW_TIPS, false).apply();
    }

    //国家IP
    public static String getCountryCode(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getString(PARAM_COUNTRY_CODE, "");
    }

    public static void setCountryCode(Context context, String code) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putString(PARAM_COUNTRY_CODE, code).apply();
    }


    public static void setAppVersion(Context context, int appVersion) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putInt(APP_VERSION, appVersion).apply();
    }

    public static int getAppVersion(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getInt(APP_VERSION, 0);
    }

    public static void saveUserTaskList(Context context, String json) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putString(PARAM_USER_TASK_LIST, json).apply();
    }

    public static String getUserTaskList(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getString(PARAM_USER_TASK_LIST, "");
    }

    public static void saveUserInviteTaskList(Context context, String json) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putString(PARAM_USER_INVITE_TASK_LIST, json).apply();
    }

    public static String getUserInviteTaskList(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getString(PARAM_USER_INVITE_TASK_LIST, "");
    }

    public static void setUserTaskListTime(Context context, long time) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putLong(PARAM_USER_TASK_LIST_TIME, time).apply();
    }

    public static long getUserTaskListTime(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getLong(PARAM_USER_TASK_LIST_TIME, 0);
    }

    public static void setDAppWhiteList(Context context, Set<String> set) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putStringSet(PARAM_DAPP_WHITE_LIST, set).apply();
    }

    public static Set<String> getDAppWhiteList(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getStringSet(PARAM_DAPP_WHITE_LIST, new HashSet<>());
    }

    public static boolean isShowDAppWhiteListTips(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getBoolean(PARAM_DAPP_WHITE_LIST_TIPS, true);
    }

    public static void setShowDAppWhiteListTips(Context context) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putBoolean(PARAM_DAPP_WHITE_LIST_TIPS, false).apply();
    }


    //***************QKC chain shard 相关****************
    //Chain链数量
    public static String getTotalChainCount(Context context) {
        return context.getSharedPreferences(Constant.sNetworkId.toString(), Context.MODE_PRIVATE)
                .getString(PARAM_CHAIN_COUNT, "0x1");
    }

    //Chain链数量
    public static void setTotalChainCount(Context context, String count) {
        context.getSharedPreferences(Constant.sNetworkId.toString(), Context.MODE_PRIVATE).edit()
                .putString(PARAM_CHAIN_COUNT, count).apply();

    }

    //分片数量
    public static List<String> getTotalSharedSizes(Context context) {
        String json = context.getSharedPreferences(Constant.sNetworkId.toString(), Context.MODE_PRIVATE)
                .getString(PARAM_SHARD_SIZES, "");
        return TextUtils.isEmpty(json) ? null : new Gson().fromJson(json, new TypeToken<List<String>>() {
        }.getType());
    }

    //分片数量
    public static void setTotalSharedSizes(Context context, ArrayList<String> list) {
        context.getSharedPreferences(Constant.sNetworkId.toString(), Context.MODE_PRIVATE).edit()
                .putString(PARAM_SHARD_SIZES, new Gson().toJson(list)).apply();

    }

    //设置当前分片
    public static void setCurrentShard(Context context, String address, String shard) {
        if (!TextUtils.isEmpty(address)) {
            address = Numeric.parseAddressToEth(address);
        }
        context.getSharedPreferences(Constant.sNetworkId.toString(), Context.MODE_PRIVATE).edit()
                .putString(address + PARAM_SHARD_CURRENT, shard).apply();

    }

    //获取当前分片
    public static String getCurrentShard(Context context, String address) {
        if (!TextUtils.isEmpty(address)) {
            address = Numeric.parseAddressToEth(address);
        }
        return context.getSharedPreferences(Constant.sNetworkId.toString(), Context.MODE_PRIVATE)
                .getString(address + PARAM_SHARD_CURRENT, "0x0");
    }

    //设置当前chain
    public static void setCurrentChain(Context context, String address, String chain) {
        if (!TextUtils.isEmpty(address)) {
            address = Numeric.parseAddressToEth(address);
        }
        context.getSharedPreferences(Constant.sNetworkId.toString(), Context.MODE_PRIVATE).edit()
                .putString(address + PARAM_CHAIN_CURRENT, chain).apply();

    }

    //获取当前chain
    public static String getCurrentChain(Context context, String address) {
        if (!TextUtils.isEmpty(address)) {
            address = Numeric.parseAddressToEth(address);
        }
        return context.getSharedPreferences(Constant.sNetworkId.toString(), Context.MODE_PRIVATE)
                .getString(address + PARAM_CHAIN_CURRENT, "0x0");
    }


    //****************交易详情*******************
    //详情币种
    public static void setCurrentMarketCoin(Context context, String coin) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putString(PARAM_MARKET_COIN, coin).apply();

    }

    //详情币种 默认美元
    public static String getCurrentMarketCoin(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getString(PARAM_MARKET_COIN, "");
    }

    //详情币种 默认美元
    public static int getCurrentMarketTap(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getInt(PARAM_MARKET_TAP, 1);
    }

    public static void setCurrentMarketTap(Context context, int index) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putInt(PARAM_MARKET_TAP, index).apply();
    }

    //****************价格**************************
    public static float getCoinPrice(Context context, String coin, String priceType) {
        return context.getSharedPreferences(coin, Context.MODE_PRIVATE)
                .getFloat(priceType, 0);
    }

    public static void putCoinPrice(Context context, String coin, String priceType, float price) {
        context.getSharedPreferences(coin, Context.MODE_PRIVATE).edit()
                .putFloat(priceType, price).apply();
    }
    //****************价格**************************

    //****************用户**************************
    public static int getUserSignCount(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getInt(PARAM_SIGN_COUNT, 0);
    }

    public static void setUserSignCount(Context context) {
        int count = getUserSignCount(context) + 1;
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putInt(PARAM_SIGN_COUNT, count).apply();
    }

    public static Set<String> getUserTaskClaim(Context context) {
        Set<String> set = context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getStringSet(PARAM_TASK_CLAIM, new HashSet<>());
        return new HashSet<>(set);

    }

    public static void setUserTaskClaim(Context context, Set<String> set) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putStringSet(PARAM_TASK_CLAIM, set).apply();
    }

    //获取上报失败地址
    public static String getPushAccountAddress(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getString(PARAM_PUSH_ACCOUNT_ADDRESS, "");
    }

    //设置上报失败地址
    public static void setPushAccountAddress(Context context, String json) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putString(PARAM_PUSH_ACCOUNT_ADDRESS, json).apply();
    }

    public static void clearPushAccountAddress(Context context) {
        setPushAccountAddress(context, "");
    }
    //****************用户**************************

    //****************记录首页tab记录**************************
    public static int getMainTabIndex(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getInt(PARAM_MAIN_TAB_INDEX, -1);
    }

    public static void setMainTabIndex(Context context, int index) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putInt(PARAM_MAIN_TAB_INDEX, index).apply();
    }
    //****************记录首页tab记录**************************

    //****************锁屏状态*********************
    public static int getAppLockState(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getInt(PARAM_APP_LOCK_STATE, -1);
    }

    public static void setAppLockState(Context context, int index) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putInt(PARAM_APP_LOCK_STATE, index).apply();
    }
    //****************锁屏状态*********************

    //是否弹获取通知权限
    public static void setAlertInstallNotifyPermission(Context context) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putBoolean(PARAM_INSTALL_NOTIFY_PERMISSION, false).apply();
    }

    public static boolean isAlertInstallNotifyPermission(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getBoolean(PARAM_INSTALL_NOTIFY_PERMISSION, true);
    }

    public static void setAlertSendNotifyPermission(Context context) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putBoolean(PARAM_SEND_NOTIFY_PERMISSION, false).apply();
    }

    public static boolean isAlertSendNotifyPermission(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getBoolean(PARAM_SEND_NOTIFY_PERMISSION, true);
    }

    public static void setShowColdDepictActivity(Context context) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit()
                .putBoolean(PARAM_SHOW_COLD_DEPICT, true).apply();
    }

    public static boolean isShowColdDepictActivity(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
                .getBoolean(PARAM_SHOW_COLD_DEPICT, false);
    }
}
