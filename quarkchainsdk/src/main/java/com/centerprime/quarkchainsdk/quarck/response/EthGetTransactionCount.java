package com.centerprime.quarkchainsdk.quarck.response;


import com.centerprime.quarkchainsdk.quarck.Numeric;
import com.centerprime.quarkchainsdk.quarck.Response;

import java.math.BigInteger;

public class EthGetTransactionCount extends Response<String> {
    public BigInteger getTransactionCount() {
        return Numeric.decodeQuantity(getResult());
    }
}