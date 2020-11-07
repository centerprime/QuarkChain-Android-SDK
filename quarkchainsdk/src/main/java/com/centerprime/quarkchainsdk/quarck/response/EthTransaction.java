package com.centerprime.quarkchainsdk.quarck.response;

public class EthTransaction {
    private String blockNumber;
    private String timeStamp;
    private String hash;
    private String nonce;
    private String blockHash;
    private String transactionIndex;
    private String from;
    private String to;
    private String value;
    private String gas;
    private String gasPrice;
    private String isError;
    private String txreceipt_status;
    private String input;
    private String contractAddress;
    private String cumulativeGasUsed;
    private String gasUsed;
    private String confirmations;

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public String getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(String transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    public String getIsError() {
        return isError;
    }

    public void setIsError(String isError) {
        this.isError = isError;
    }

    public String getTxreceipt_status() {
        return txreceipt_status;
    }

    public void setTxreceipt_status(String txreceipt_status) {
        this.txreceipt_status = txreceipt_status;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public String getCumulativeGasUsed() {
        return cumulativeGasUsed;
    }

    public void setCumulativeGasUsed(String cumulativeGasUsed) {
        this.cumulativeGasUsed = cumulativeGasUsed;
    }

    public String getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
    }

    public String getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(String confirmations) {
        this.confirmations = confirmations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EthTransaction)) return false;

        EthTransaction that = (EthTransaction) o;

        if (getBlockNumber() != null ? !getBlockNumber().equals(that.getBlockNumber()) : that.getBlockNumber() != null)
            return false;
        if (getTimeStamp() != null ? !getTimeStamp().equals(that.getTimeStamp()) : that.getTimeStamp() != null)
            return false;
        if (getHash() != null ? !getHash().equals(that.getHash()) : that.getHash() != null)
            return false;
        if (getNonce() != null ? !getNonce().equals(that.getNonce()) : that.getNonce() != null)
            return false;
        if (getBlockHash() != null ? !getBlockHash().equals(that.getBlockHash()) : that.getBlockHash() != null)
            return false;
        if (getTransactionIndex() != null ? !getTransactionIndex().equals(that.getTransactionIndex()) : that.getTransactionIndex() != null)
            return false;
        if (getFrom() != null ? !getFrom().equals(that.getFrom()) : that.getFrom() != null)
            return false;
        if (getTo() != null ? !getTo().equals(that.getTo()) : that.getTo() != null) return false;
        if (getValue() != null ? !getValue().equals(that.getValue()) : that.getValue() != null)
            return false;
        if (getGas() != null ? !getGas().equals(that.getGas()) : that.getGas() != null)
            return false;
        if (getGasPrice() != null ? !getGasPrice().equals(that.getGasPrice()) : that.getGasPrice() != null)
            return false;
        if (getIsError() != null ? !getIsError().equals(that.getIsError()) : that.getIsError() != null)
            return false;
        if (getTxreceipt_status() != null ? !getTxreceipt_status().equals(that.getTxreceipt_status()) : that.getTxreceipt_status() != null)
            return false;
        if (getInput() != null ? !getInput().equals(that.getInput()) : that.getInput() != null)
            return false;
        if (getContractAddress() != null ? !getContractAddress().equals(that.getContractAddress()) : that.getContractAddress() != null)
            return false;
        if (getCumulativeGasUsed() != null ? !getCumulativeGasUsed().equals(that.getCumulativeGasUsed()) : that.getCumulativeGasUsed() != null)
            return false;
        if (getGasUsed() != null ? !getGasUsed().equals(that.getGasUsed()) : that.getGasUsed() != null)
            return false;
        return getConfirmations() != null ? getConfirmations().equals(that.getConfirmations()) : that.getConfirmations() == null;
    }

    @Override
    public int hashCode() {
        int result = getBlockNumber() != null ? getBlockNumber().hashCode() : 0;
        result = 31 * result + (getTimeStamp() != null ? getTimeStamp().hashCode() : 0);
        result = 31 * result + (getHash() != null ? getHash().hashCode() : 0);
        result = 31 * result + (getNonce() != null ? getNonce().hashCode() : 0);
        result = 31 * result + (getBlockHash() != null ? getBlockHash().hashCode() : 0);
        result = 31 * result + (getTransactionIndex() != null ? getTransactionIndex().hashCode() : 0);
        result = 31 * result + (getFrom() != null ? getFrom().hashCode() : 0);
        result = 31 * result + (getTo() != null ? getTo().hashCode() : 0);
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        result = 31 * result + (getGas() != null ? getGas().hashCode() : 0);
        result = 31 * result + (getGasPrice() != null ? getGasPrice().hashCode() : 0);
        result = 31 * result + (getIsError() != null ? getIsError().hashCode() : 0);
        result = 31 * result + (getTxreceipt_status() != null ? getTxreceipt_status().hashCode() : 0);
        result = 31 * result + (getInput() != null ? getInput().hashCode() : 0);
        result = 31 * result + (getContractAddress() != null ? getContractAddress().hashCode() : 0);
        result = 31 * result + (getCumulativeGasUsed() != null ? getCumulativeGasUsed().hashCode() : 0);
        result = 31 * result + (getGasUsed() != null ? getGasUsed().hashCode() : 0);
        result = 31 * result + (getConfirmations() != null ? getConfirmations().hashCode() : 0);
        return result;
    }
}
