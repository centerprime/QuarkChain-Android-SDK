package com.centerprime.quarkchainsdk.quarck.response;

import com.centerprime.quarkchainsdk.quarck.Response;

/**
 * transaction
 */
public class QKCGetTransactionReceipt extends Response<TransactionReceipt> {

    public TransactionReceipt getTransaction() {
        return getResult();
    }
}
