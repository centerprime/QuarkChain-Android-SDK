package com.centerprime.quarkchainsdk.quarck;


import com.centerprime.quarkchainsdk.quarck.request.GasLimitForBuyRequest;
import com.centerprime.quarkchainsdk.quarck.request.GasLimitRequest;
import com.centerprime.quarkchainsdk.quarck.request.TokenBalance;
import com.centerprime.quarkchainsdk.quarck.response.QKCGetAccountData;
import com.centerprime.quarkchainsdk.quarck.response.QKCGetTransaction;
import com.centerprime.quarkchainsdk.quarck.response.QKCGetTransactionCount;
import com.centerprime.quarkchainsdk.quarck.response.QKCGetTransactionReceipt;
import com.centerprime.quarkchainsdk.quarck.response.QKCGetTransactions;
import com.centerprime.quarkchainsdk.quarck.response.QKCNetworkInfo;
import com.centerprime.quarkchainsdk.quarck.response.QKCSendRawTransaction;

/**
 * Core Ethereum JSON-RPC API.
 */
public interface QuarkChain {

    //分片总数
    Request<?, QKCNetworkInfo> networkInfoSuccess();

    //获取所有分片下qkc数量 @YES
    Request<?, QKCGetAccountData> getAccountData(String address);

    //获取该地址发送交易数量
    Request<?, QKCGetTransactionCount> getTransactionCount(String address);

    //发送交易
    Request<?, QKCSendRawTransaction> sendRawTransaction(String signedTransactionData);


    //通过地址获得所有交易详情
    Request<?, QKCGetTransactions> getTransactionsByAddress(String address, String start, String limit);

    //通过地址获得所有交易详情
    Request<?, QKCGetTransactions> getTransactionsByAddress(String address, String tokenId, String start, String limit);

    //根据id获取交易记录
    Request<?, QKCGetTransaction> getTransactionById(String transactionId);

    //获取收据
    Request<?, QKCGetTransactionReceipt> getTransactionReceipt(String transactionId);

    //获取toke符号之类
//    CallRequest<?, QuarkCall> call(TokenBalance signedTransactionData);

    Request<?, QuarkCall> call(TokenBalance signedTransactionData);

    //获取gas价格
    Request<?, QuarkCall> gasPrice(String shard);

    //获取gas上限
    Request<?, QuarkCall> gasLimit(GasLimitRequest request);

    //获取gas上限
    Request<?, QuarkCall> gasLimitForBuy(GasLimitForBuyRequest request);
}
