package com.centerprime.quarkchainsdk.quarck.response;


import com.centerprime.quarkchainsdk.quarck.Numeric;
import com.centerprime.quarkchainsdk.quarck.Response;

import java.math.BigInteger;

/**
 * transactionCount.
 */
public class QKCGetTransactionCount extends Response<String> {

    public BigInteger getTransactionCount() {
        return Numeric.decodeQuantity(getResult());
    }
}
