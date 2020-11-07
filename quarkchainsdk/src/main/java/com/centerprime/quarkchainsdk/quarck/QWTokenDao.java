package com.centerprime.quarkchainsdk.quarck;

public class QWTokenDao {
    public static final String QKC_NAME = "QKC";
    public static final String QKC_SYMBOL = "qkc";//token符号
    private static final String QKC_TOTAL_SUPPLY = "10000000000";//总数量
    public static final String QKC_DECIMALS = "18";//有效小数
    public static final String QKC_ADDRESS = "0xEA26c4aC16D4a5A106820BC8AEE85fd0b7b2b664";
    private static final String QKC_DES_CN = "QuarkChain是一个基于分片技术来搭建的灵活、高拓展性且方便使用的区块链底层架构。它是世界上首个成功实现状态分片的公链之一。";
    private static final String QKC_DES_EN = "QuarkChain is a flexible, scalable, and user-oriented blockchain infrastructure by applying sharding technology.";

    public static final String TQKC_ADDRESS = "0x8bb0";

    public static final String ETH_NAME = "ETH";
    public static final String ETH_SYMBOL = "eth";//token符号
    private static final String ETH_TOTAL_SUPPLY = "10000000000";//总数量
    private static final String ETH_DECIMALS = "18";//有效小数
    private static final String ETH_DES_CN = "以太坊系统的基础货币。";
    private static final String ETH_DES_EN = "The crypto-fuel for Ethereum network.";

    public static final String TRX_NAME = "TRX";
    public static final String TRX_SYMBOL = "trx";//token符号
    private static final String TRX_TOTAL_SUPPLY = "100000000000";//总数量
    private static final String TRX_DECIMALS = "6";//有效小数
    private static final String TRX_DES_CN = "波场TRON是全球最大的区块链去中心化应用操作系统。";
    private static final String TRX_DES_EN = "TRON is one of the largest blockchain-based operating systems in the world.";

    public static final String BTC_NAME = "BTC";
    public static final String BTC_SYMBOL = "btc";//token符号
    private static final String BTC_TOTAL_SUPPLY = "21000000";//总数量
    private static final String BTC_DECIMALS = "8";//有效小数
    private static final String BTC_DES_CN = "一种点对点的电子现金系统";
    private static final String BTC_DES_EN = "A Peer-to-Peer Electronic Cash System";

    public static QWToken getETHERC20QKCToken() {
        QWToken token = new QWToken();
        token.setName(QKC_NAME);
        token.setSymbol(QKC_SYMBOL);
        token.setTotalSupply(QKC_TOTAL_SUPPLY);
        token.setDecimals(QKC_DECIMALS);
        token.setAddress(QKC_ADDRESS);
        token.setUrl("https://quarkchain.io/");
        token.setDescriptionCn(QKC_DES_CN);
        token.setDescriptionEn(QKC_DES_EN);
        token.setChainId(1);
        token.setIsAdd(1);
        token.setType(Constant.ACCOUNT_TYPE_ETH);

        return token;
    }

    public static QWToken getTQKCToken() {
        QWToken token = getETHERC20QKCToken();
        token.setAddress(TQKC_ADDRESS);
        token.setChainId(1);
        token.setIsNative(1);
        token.setType(Constant.ACCOUNT_TYPE_QKC);
        return token;
    }



}
