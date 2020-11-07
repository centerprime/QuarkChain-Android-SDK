package com.centerprime.quarkchainsdk.quarck.response;


import com.centerprime.quarkchainsdk.quarck.Response;

/**
 * qkc_getBalance.
 */
public class QKCGetBalance extends Response<QKCGetBalance.Balance> {

    public static class Balance {
        private String branch;
        private String shard;
        private String balance;

        public Balance() {
        }

        public Balance(String branch, String shard, String balance) {
            this.branch = branch;
            this.shard = shard;
            this.balance = balance;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getShard() {
            return shard;
        }

        public void setShard(String shard) {
            this.shard = shard;
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
            if (o == null || getClass() != o.getClass()) return false;

            Balance balance1 = (Balance) o;

            if (branch != null ? !branch.equals(balance1.branch) : balance1.branch != null)
                return false;
            if (shard != null ? !shard.equals(balance1.shard) : balance1.shard != null)
                return false;
            return balance != null ? balance.equals(balance1.balance) : balance1.balance == null;
        }

        @Override
        public int hashCode() {
            int result = branch != null ? branch.hashCode() : 0;
            result = 31 * result + (shard != null ? shard.hashCode() : 0);
            result = 31 * result + (balance != null ? balance.hashCode() : 0);
            return result;
        }
    }

    public Balance getBalance() {
        return getResult();
    }
}
