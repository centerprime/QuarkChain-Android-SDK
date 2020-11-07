package com.centerprime.quarkchainsdk.quarck.response;

public class TrxAllTransaction {
    private int contractType;

    private String block;
    private String hash;
    private String timestamp;
    private String ownerAddress;
    private String toAddress;
    private boolean confirmed;
    private String fee;

    private String amount = "0";

    private String contractAddress;

    private String resource;
    private String frozenDuration;

    public int getContractType() {
        return contractType;
    }

    public void setContractType(int contractType) {
        this.contractType = contractType;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getFrozenDuration() {
        return frozenDuration;
    }

    public void setFrozenDuration(String frozenBalance) {
        this.frozenDuration = frozenBalance;
    }
}
