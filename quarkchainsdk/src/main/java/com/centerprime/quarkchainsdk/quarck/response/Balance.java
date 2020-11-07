package com.centerprime.quarkchainsdk.quarck.response;

public class Balance {
    private String tokenId;
    private String tokenStr;
    private String balance;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getTokenStr() {
        return tokenStr;
    }

    public void setTokenStr(String tokenStr) {
        this.tokenStr = tokenStr;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Balance)) return false;

        Balance balance1 = (Balance) o;

        if (getTokenId() != null ? !getTokenId().equals(balance1.getTokenId()) : balance1.getTokenId() != null)
            return false;
        if (getTokenStr() != null ? !getTokenStr().equals(balance1.getTokenStr()) : balance1.getTokenStr() != null)
            return false;
        return getBalance() != null ? getBalance().equals(balance1.getBalance()) : balance1.getBalance() == null;
    }

    @Override
    public int hashCode() {
        int result = getTokenId() != null ? getTokenId().hashCode() : 0;
        result = 31 * result + (getTokenStr() != null ? getTokenStr().hashCode() : 0);
        result = 31 * result + (getBalance() != null ? getBalance().hashCode() : 0);
        return result;
    }
}
