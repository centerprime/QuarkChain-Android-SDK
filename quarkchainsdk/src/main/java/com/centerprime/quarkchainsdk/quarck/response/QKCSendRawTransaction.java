package com.centerprime.quarkchainsdk.quarck.response;


import com.centerprime.quarkchainsdk.quarck.Response;

/**
 * qkc_sendTransaction.
 */
public class QKCSendRawTransaction extends Response<String> {

    public String getTransactionHash() {
        return getResult();
    }
}
