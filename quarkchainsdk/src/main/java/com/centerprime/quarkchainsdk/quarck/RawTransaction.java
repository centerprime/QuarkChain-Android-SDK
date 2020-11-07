package com.centerprime.quarkchainsdk.quarck;

import java.math.BigInteger;

/**
 * Transaction class used for signing transactions locally.<br>
 * For the specification, refer to p4 of the <a href="http://gavwood.com/paper.pdf">
 * yellow paper</a>.
 */
public class RawTransaction {

    private BigInteger nonce;
    private BigInteger gasPrice;
    private BigInteger gasLimit;
    private String to;
    private BigInteger value;
    private String data;

    private BigInteger fromFullShard;
    private BigInteger toFullShard;
    private BigInteger networkId;


    private BigInteger transferTokenId;
    private BigInteger gasTokenId;

    RawTransaction(BigInteger nonce, BigInteger gasPrice, BigInteger gasLimit, String to,
                   BigInteger value, String data,
                   BigInteger fromId, BigInteger toId, BigInteger networkId,
                   BigInteger transferToken, BigInteger gasToken) {
        this.nonce = nonce;
        this.gasPrice = gasPrice;
        this.gasLimit = gasLimit;
        this.to = to;
        this.value = value;
        this.fromFullShard = fromId;
        this.toFullShard = toId;
        this.networkId = networkId;

        this.transferTokenId = transferToken;
        this.gasTokenId = gasToken;

        if (data != null) {
            this.data = Numeric.cleanHexPrefix(data);
        }
    }

    public static RawTransaction createTransaction(
            BigInteger nonce, BigInteger gasPrice, BigInteger gasLimit, String to,
            BigInteger value, BigInteger fromShard, BigInteger toShard, String data, BigInteger networkId,
            BigInteger transferToken, BigInteger gasToken) {
        return new RawTransaction(nonce, gasPrice, gasLimit, to, value, data, fromShard, toShard, networkId, transferToken, gasToken);
    }

    public BigInteger getNonce() {
        return nonce;
    }

    public BigInteger getGasPrice() {
        return gasPrice;
    }

    public BigInteger getGasLimit() {
        return gasLimit;
    }

    public String getTo() {
        return to;
    }

    public BigInteger getValue() {
        return value;
    }

    public String getData() {
        return data;
    }

    public BigInteger getFromFullShard() {
        return fromFullShard;
    }

    public BigInteger getToFullShard() {
        return toFullShard;
    }

    public BigInteger getNetworkId() {
        return networkId;
    }

    public BigInteger getGasTokenId() {
        return gasTokenId;
    }

    public BigInteger getTransferTokenId() {
        return transferTokenId;
    }
}
