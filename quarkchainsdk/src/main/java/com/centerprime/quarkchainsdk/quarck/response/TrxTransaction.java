package com.centerprime.quarkchainsdk.quarck.response;

public class TrxTransaction {
    //    {
//        "amount":169839005361630,
//            "transferFromAddress":"TAUN6FwrnwwmaEqYcckffC7wYmbaS6cBiX",
//            "data":"",
//            "tokenName":"_",
//            "transferToAddress":"TMuA6YqfCeX8EhbfYEg5y7S4DqzSJireY9",
//            "block":6279372,
//            "id":"",
//            "confirmed":true,
//            "transactionHash":"fbc4601cdf0c14721d2d91df183e65047a97907f2b1d39f1bdc2351cff7f6388",
//            "timestamp":1548937212000
//    }
    private String id;
    private String transactionHash;
    private String amount;
    private String data;
    private String tokenName;
    private String transferFromAddress;
    private String transferToAddress;
    private String timestamp;
    private String block;
    private boolean confirmed;

    private String cost = "0";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getTransferFromAddress() {
        return transferFromAddress;
    }

    public void setTransferFromAddress(String transferFromAddress) {
        this.transferFromAddress = transferFromAddress;
    }

    public String getTransferToAddress() {
        return transferToAddress;
    }

    public void setTransferToAddress(String transferToAddress) {
        this.transferToAddress = transferToAddress;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrxTransaction)) return false;

        TrxTransaction that = (TrxTransaction) o;

        if (isConfirmed() != that.isConfirmed()) return false;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getTransactionHash() != null ? !getTransactionHash().equals(that.getTransactionHash()) : that.getTransactionHash() != null)
            return false;
        if (getAmount() != null ? !getAmount().equals(that.getAmount()) : that.getAmount() != null)
            return false;
        if (getData() != null ? !getData().equals(that.getData()) : that.getData() != null)
            return false;
        if (getTokenName() != null ? !getTokenName().equals(that.getTokenName()) : that.getTokenName() != null)
            return false;
        if (getTransferFromAddress() != null ? !getTransferFromAddress().equals(that.getTransferFromAddress()) : that.getTransferFromAddress() != null)
            return false;
        if (getTransferToAddress() != null ? !getTransferToAddress().equals(that.getTransferToAddress()) : that.getTransferToAddress() != null)
            return false;
        if (getTimestamp() != null ? !getTimestamp().equals(that.getTimestamp()) : that.getTimestamp() != null)
            return false;
        return getBlock() != null ? getBlock().equals(that.getBlock()) : that.getBlock() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTransactionHash() != null ? getTransactionHash().hashCode() : 0);
        result = 31 * result + (getAmount() != null ? getAmount().hashCode() : 0);
        result = 31 * result + (getData() != null ? getData().hashCode() : 0);
        result = 31 * result + (getTokenName() != null ? getTokenName().hashCode() : 0);
        result = 31 * result + (getTransferFromAddress() != null ? getTransferFromAddress().hashCode() : 0);
        result = 31 * result + (getTransferToAddress() != null ? getTransferToAddress().hashCode() : 0);
        result = 31 * result + (getTimestamp() != null ? getTimestamp().hashCode() : 0);
        result = 31 * result + (getBlock() != null ? getBlock().hashCode() : 0);
        result = 31 * result + (isConfirmed() ? 1 : 0);
        return result;
    }
}
