package com.centerprime.quarkchainsdk.quarck.response;

import java.util.ArrayList;

public class Account {
    private String fullShardId;
    private String chainId;
    private String shardId;
    private String transactionCount;
    private boolean isContract;
    private ArrayList<Balance> balances;

    public String getFullShardId() {
        return fullShardId;
    }

    public void setFullShardId(String fullShardId) {
        this.fullShardId = fullShardId;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public String getShardId() {
        return shardId;
    }

    public void setShardId(String shardId) {
        this.shardId = shardId;
    }

    public String getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(String transactionCount) {
        this.transactionCount = transactionCount;
    }

    public boolean isContract() {
        return isContract;
    }

    public void setContract(boolean contract) {
        isContract = contract;
    }

    public ArrayList<Balance> getBalances() {
        return balances;
    }

    public void setBalances(ArrayList<Balance> balances) {
        this.balances = balances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        if (isContract() != account.isContract()) return false;
        if (getFullShardId() != null ? !getFullShardId().equals(account.getFullShardId()) : account.getFullShardId() != null)
            return false;
        if (getChainId() != null ? !getChainId().equals(account.getChainId()) : account.getChainId() != null)
            return false;
        if (getShardId() != null ? !getShardId().equals(account.getShardId()) : account.getShardId() != null)
            return false;
        if (getTransactionCount() != null ? !getTransactionCount().equals(account.getTransactionCount()) : account.getTransactionCount() != null)
            return false;
        return getBalances() != null ? getBalances().equals(account.getBalances()) : account.getBalances() == null;
    }

    @Override
    public int hashCode() {
        int result = getFullShardId() != null ? getFullShardId().hashCode() : 0;
        result = 31 * result + (getChainId() != null ? getChainId().hashCode() : 0);
        result = 31 * result + (getShardId() != null ? getShardId().hashCode() : 0);
        result = 31 * result + (getTransactionCount() != null ? getTransactionCount().hashCode() : 0);
        result = 31 * result + (isContract() ? 1 : 0);
        result = 31 * result + (getBalances() != null ? getBalances().hashCode() : 0);
        return result;
    }
}
