package com.centerprime.quarkchainsdk.quarck.response;


import com.centerprime.quarkchainsdk.quarck.Numeric;
import com.centerprime.quarkchainsdk.quarck.Response;

import java.math.BigInteger;

public class EthEstimateGas extends Response<String> {
    public BigInteger getAmountUsed() {
        return Numeric.decodeQuantity(getResult());
    }
}
