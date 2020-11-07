package com.centerprime.quarkchainsdk.quarck.response;


import com.centerprime.quarkchainsdk.quarck.Response;

public class EthSendTransaction extends Response<String> {
    public String getTransactionHash() {
        return getResult();
    }
}
