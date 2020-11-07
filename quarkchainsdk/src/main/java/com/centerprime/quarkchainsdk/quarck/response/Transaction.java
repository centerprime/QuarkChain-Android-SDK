package com.centerprime.quarkchainsdk.quarck.response;

public class Transaction {
    private String txId;
    private String fromAddress;
    private String toAddress;
    private String value;
    private String transferTokenId;
    private String transferTokenStr;
    private String gasTokenId;
    private String gasTokenStr;
    private String blockHeight;
    private String timestamp;
    private boolean success;

    private boolean isPending;//是否为pending状态

    public Transaction() {
    }

    public Transaction(String txId, String fromAddress, String toAddress,
                       String value, String transferTokenId, String transferTokenStr,
                       String gasTokenId, String gasTokenStr,
                       String blockHeight,
                       String timestamp, boolean success, boolean isPending) {
        this.txId = txId;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.value = value;
        this.transferTokenId = transferTokenId;
        this.transferTokenStr = transferTokenStr;
        this.gasTokenId = gasTokenId;
        this.gasTokenStr = gasTokenStr;
        this.blockHeight = blockHeight;
        this.timestamp = timestamp;
        this.success = success;
        this.isPending = isPending;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTransferTokenId() {
        return transferTokenId;
    }

    public void setTransferTokenId(String transferTokenId) {
        this.transferTokenId = transferTokenId;
    }

    public String getTransferTokenStr() {
        return transferTokenStr;
    }

    public void setTransferTokenStr(String transferTokenStr) {
        this.transferTokenStr = transferTokenStr;
    }

    public String getGasTokenId() {
        return gasTokenId;
    }

    public void setGasTokenId(String gasTokenId) {
        this.gasTokenId = gasTokenId;
    }

    public String getGasTokenStr() {
        return gasTokenStr;
    }

    public void setGasTokenStr(String gasTokenStr) {
        this.gasTokenStr = gasTokenStr;
    }

    public String getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(String blockHeight) {
        this.blockHeight = blockHeight;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setPending(boolean pending) {
        isPending = pending;
    }

    public boolean isPending() {
        return isPending;
    }

    public boolean isSent(String myAddress) {
        return myAddress.equals(fromAddress);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;

        Transaction that = (Transaction) o;

        if (isSuccess() != that.isSuccess()) return false;
        if (getTxId() != null ? !getTxId().equals(that.getTxId()) : that.getTxId() != null)
            return false;
        if (getFromAddress() != null ? !getFromAddress().equals(that.getFromAddress()) : that.getFromAddress() != null)
            return false;
        if (getToAddress() != null ? !getToAddress().equals(that.getToAddress()) : that.getToAddress() != null)
            return false;
        if (getValue() != null ? !getValue().equals(that.getValue()) : that.getValue() != null)
            return false;
        if (getTransferTokenId() != null ? !getTransferTokenId().equals(that.getTransferTokenId()) : that.getTransferTokenId() != null)
            return false;
        if (getTransferTokenStr() != null ? !getTransferTokenStr().equals(that.getTransferTokenStr()) : that.getTransferTokenStr() != null)
            return false;
        if (getGasTokenId() != null ? !getGasTokenId().equals(that.getGasTokenId()) : that.getGasTokenId() != null)
            return false;
        if (getGasTokenStr() != null ? !getGasTokenStr().equals(that.getGasTokenStr()) : that.getGasTokenStr() != null)
            return false;
        if (getBlockHeight() != null ? !getBlockHeight().equals(that.getBlockHeight()) : that.getBlockHeight() != null)
            return false;
        return getTimestamp() != null ? getTimestamp().equals(that.getTimestamp()) : that.getTimestamp() == null;
    }

    @Override
    public int hashCode() {
        int result = getTxId() != null ? getTxId().hashCode() : 0;
        result = 31 * result + (getFromAddress() != null ? getFromAddress().hashCode() : 0);
        result = 31 * result + (getToAddress() != null ? getToAddress().hashCode() : 0);
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        result = 31 * result + (getTransferTokenId() != null ? getTransferTokenId().hashCode() : 0);
        result = 31 * result + (getTransferTokenStr() != null ? getTransferTokenStr().hashCode() : 0);
        result = 31 * result + (getGasTokenId() != null ? getGasTokenId().hashCode() : 0);
        result = 31 * result + (getGasTokenStr() != null ? getGasTokenStr().hashCode() : 0);
        result = 31 * result + (getBlockHeight() != null ? getBlockHeight().hashCode() : 0);
        result = 31 * result + (getTimestamp() != null ? getTimestamp().hashCode() : 0);
        result = 31 * result + (isSuccess() ? 1 : 0);
        return result;
    }
}
