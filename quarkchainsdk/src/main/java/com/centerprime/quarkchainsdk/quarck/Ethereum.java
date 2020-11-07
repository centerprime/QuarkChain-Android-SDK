package com.centerprime.quarkchainsdk.quarck;


import com.centerprime.quarkchainsdk.quarck.response.EthCall;
import com.centerprime.quarkchainsdk.quarck.response.EthEstimateGas;
import com.centerprime.quarkchainsdk.quarck.response.EthGasPrice;
import com.centerprime.quarkchainsdk.quarck.response.EthGetBalance;
import com.centerprime.quarkchainsdk.quarck.response.EthGetTransactionCount;
import com.centerprime.quarkchainsdk.quarck.response.EthSendTransaction;
import com.centerprime.quarkchainsdk.quarck.response.Transaction;

public interface Ethereum {

    //获取eth余额
    Request<?, EthGetBalance> ethGetBalance(String address, DefaultBlockParameter defaultBlockParameter);

    Request<?, EthCall> ethCall(Transaction transaction, DefaultBlockParameter defaultBlockParameter);

    Request<?, EthGetTransactionCount> ethGetTransactionCount(String address, DefaultBlockParameter defaultBlockParameter);

    Request<?, EthSendTransaction> ethSendRawTransaction(String signedTransactionData);

    Request<?, EthGasPrice> ethGasPrice();

    Request<?, EthEstimateGas> ethEstimateGas(Transaction transaction);
}
