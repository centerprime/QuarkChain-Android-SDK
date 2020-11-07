package com.centerprime.quarkchainsdk.quarck;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;

import io.reactivex.Observable;

public class Request<S, T extends Response> {
    private static final long ID = 1;

    private String jsonrpc = "2.0";
    private String method;
    private List<S> params;
    private long id;

    // Unfortunately require an instance of the type too, see
    // http://stackoverflow.com/a/3437930/3211687
    private Class<T> responseType;

    @JsonIgnore
    private Web3jService web3jService;

    public Request() {
    }

    public Request(String method, List<S> params,
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

    public List<S> getParams() {
        return params;
    }

    public void setParams(List<S> params) {
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
