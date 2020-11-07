package com.centerprime.quarkchainsdk.quarck;


import com.centerprime.quarkchainsdk.quarck.request.CallRequest;

import java.io.IOException;
import java.util.concurrent.Future;


/**
 * Services API.
 */
public interface Web3jService {

    /**
     * Perform a synchronous JSON-RPC request.
     *
     * @param request      request to perform
     * @param responseType class of a data item returned by the request
     * @param <T>          type of a data item returned by the request
     * @return deserialized JSON-RPC response
     * @throws IOException thrown if failed to perform a request
     */
    <T extends Response> T send(
            Request request, Class<T> responseType) throws IOException;

    <T extends Response> T send(
            CallRequest request, Class<T> responseType) throws IOException;

    /**
     * Performs an asynchronous JSON-RPC request.
     *
     * @param request      request to perform
     * @param responseType class of a data item returned by the request
     * @param <T>          type of a data item returned by the request
     * @return CompletableFuture that will be completed when a result is returned or if a
     * request has failed
     */
    <T extends Response> Future<T> sendAsync(
            Request request, Class<T> responseType);

    <T extends Response> Future<T> sendAsync(
            CallRequest request, Class<T> responseType);

    /**
     * Closes resources used by the service.
     *
     * @throws IOException thrown if a service failed to close all resources
     */
    void close() throws IOException;
}
