package com.centerprime.quarkchainsdk.quarck.response;


import com.centerprime.quarkchainsdk.quarck.Response;

/**
 * transaction
 */
public class QKCGetTransaction extends Response<TransactionDetail> {

    public TransactionDetail getTransaction() {
        return getResult();
    }
}
