package com.centerprime.quarkchainsdk.quarck.response;

public class TransactionReceipt {
//        "transactionId": "0xf6ad8a1096ec8e11a922149e456a28b66cdb2bc6f64198b76f17d526db4e476c18f9ba2c",
////        "transactionHash": "0xf6ad8a1096ec8e11a922149e456a28b66cdb2bc6f64198b76f17d526db4e476c",
////        "transactionIndex": "0x0",
////        "blockId": "0xa175995eb0ff22213b1cad350c76e951549e86feb623f40bbee77261a19e57a60000002c",
////        "blockHash": "0xa175995eb0ff22213b1cad350c76e951549e86feb623f40bbee77261a19e57a6",
////        "blockHeight": "0x27dd",
////        "cumulativeGasUsed": "0x213eb",
////        "gasUsed": "0x213eb",
////        "status": "0x1",
////        "contractAddress": "0x5756361f7216521e89f8b64d27c9fbac37565a9718f9ba2c"


    private String transactionId;
    private String transactionHash;
    private String transactionIndex;
    private String blockId;
    private String blockHash;
    private String blockHeight;
    private String cumulativeGasUsed;
    private String gasUsed;
    private String status;
    private String contractAddress;


    public TransactionReceipt() {
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash;
    }

    public String getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(String transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public String getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(String blockHeight) {
        this.blockHeight = blockHeight;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionReceipt)) return false;

        TransactionReceipt that = (TransactionReceipt) o;

        if (getTransactionId() != null ? !getTransactionId().equals(that.getTransactionId()) : that.getTransactionId() != null)
            return false;
        if (getTransactionHash() != null ? !getTransactionHash().equals(that.getTransactionHash()) : that.getTransactionHash() != null)
            return false;
        if (getTransactionIndex() != null ? !getTransactionIndex().equals(that.getTransactionIndex()) : that.getTransactionIndex() != null)
            return false;
        if (getBlockId() != null ? !getBlockId().equals(that.getBlockId()) : that.getBlockId() != null)
            return false;
        if (getBlockHash() != null ? !getBlockHash().equals(that.getBlockHash()) : that.getBlockHash() != null)
            return false;
        if (getBlockHeight() != null ? !getBlockHeight().equals(that.getBlockHeight()) : that.getBlockHeight() != null)
            return false;
        if (getCumulativeGasUsed() != null ? !getCumulativeGasUsed().equals(that.getCumulativeGasUsed()) : that.getCumulativeGasUsed() != null)
            return false;
        if (getGasUsed() != null ? !getGasUsed().equals(that.getGasUsed()) : that.getGasUsed() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null)
            return false;
        return getContractAddress() != null ? getContractAddress().equals(that.getContractAddress()) : that.getContractAddress() == null;
    }

    @Override
    public int hashCode() {
        int result = getTransactionId() != null ? getTransactionId().hashCode() : 0;
        result = 31 * result + (getTransactionHash() != null ? getTransactionHash().hashCode() : 0);
        result = 31 * result + (getTransactionIndex() != null ? getTransactionIndex().hashCode() : 0);
        result = 31 * result + (getBlockId() != null ? getBlockId().hashCode() : 0);
        result = 31 * result + (getBlockHash() != null ? getBlockHash().hashCode() : 0);
        result = 31 * result + (getBlockHeight() != null ? getBlockHeight().hashCode() : 0);
        result = 31 * result + (getCumulativeGasUsed() != null ? getCumulativeGasUsed().hashCode() : 0);
        result = 31 * result + (getGasUsed() != null ? getGasUsed().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getContractAddress() != null ? getContractAddress().hashCode() : 0);
        return result;
    }
}
