package com.centerprime.quarkchainsdk.quarck.response;


import com.centerprime.quarkchainsdk.quarck.Numeric;
import com.centerprime.quarkchainsdk.quarck.Response;

import java.math.BigInteger;

public class EthGetBalance extends Response<String> {
    public BigInteger getBalance() {
        return Numeric.decodeQuantity(getResult());
    }
}