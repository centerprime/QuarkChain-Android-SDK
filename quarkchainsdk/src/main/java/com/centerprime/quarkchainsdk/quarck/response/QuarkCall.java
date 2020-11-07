package com.centerprime.quarkchainsdk.quarck.response;


import com.centerprime.quarkchainsdk.quarck.Response;

/**
 * eth_call.
 */
public class QuarkCall extends Response<String> {
    public String getValue() {
        return getResult();
    }
}
