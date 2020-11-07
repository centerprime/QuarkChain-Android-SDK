package com.centerprime.quarkchainsdk.quarck.response;


import com.centerprime.quarkchainsdk.quarck.Numeric;
import com.centerprime.quarkchainsdk.quarck.Response;

import java.math.BigInteger;

public class EthGasPrice extends Response<String> {
    public BigInteger getGasPrice() {
        return Numeric.decodeQuantity(getResult());
    }
}
