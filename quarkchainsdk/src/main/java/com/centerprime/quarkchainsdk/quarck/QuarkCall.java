package com.centerprime.quarkchainsdk.quarck;


 /**
 * eth_call.
 */
public class QuarkCall extends Response<String> {
    public String getValue() {
        return getResult();
    }
}
