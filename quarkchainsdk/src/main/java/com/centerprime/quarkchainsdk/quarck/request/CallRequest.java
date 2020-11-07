package com.centerprime.quarkchainsdk.quarck.request;



import com.centerprime.quarkchainsdk.quarck.RemoteCall;
import com.centerprime.quarkchainsdk.quarck.Response;
import com.centerprime.quarkchainsdk.quarck.Web3jService;

import java.io.IOException;
import java.util.concurrent.Future;

import io.reactivex.Observable;

public class CallRequest<S, T extends Response> {
    private static final long ID = 1;

    private String jsonrpc = "2.0";
    private String method;
    private S params;
    private long id;

    private Web3jService web3jService;

    // Unfortunately require an instance of the type too, see
    // http://stackoverflow.com/a/3437930/3211687
    private Class<T> responseType;

    public CallRequest() {
    }

    public CallRequest(String method, S params,
                       Web3jService web3jService, Class<T> type) {
        this.method = method;
        this.params = params;
        this.id = ID;
        this.web3jService = web3jService;
        this.responseType = type;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public S getParams() {
        return params;
    }

    public void setParams(S params) {
        this.params = params;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public T send() throws IOException {
        return web3jService.send(this, responseType);
    }

    public Future<T> sendAsync() {
        return web3jService.sendAsync(this, responseType);
    }

    public Observable<T> observable() {
        return new RemoteCall<>(this::send).observable();
    }
}
