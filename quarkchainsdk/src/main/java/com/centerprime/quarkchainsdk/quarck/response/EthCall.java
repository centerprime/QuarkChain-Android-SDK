package com.centerprime.quarkchainsdk.quarck.response;


import com.centerprime.quarkchainsdk.quarck.Response;

public class EthCall extends Response<String> {
    public String getValue() {
        return getResult();
    }
}