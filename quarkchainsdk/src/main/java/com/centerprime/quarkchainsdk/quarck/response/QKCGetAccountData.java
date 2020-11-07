package com.centerprime.quarkchainsdk.quarck.response;

import com.centerprime.quarkchainsdk.quarck.Response;

import java.util.ArrayList;

/**
 * qkc_getBalance.
 */
public class QKCGetAccountData extends Response<QKCGetAccountData.AccountData> {

    public static class AccountData {

        private Account primary;
        private ArrayList<Account> shards;

        public Account getPrimary() {
            return primary;
        }

        public void setPrimary(Account primary) {
            this.primary = primary;
        }

        public ArrayList<Account> getShards() {
            return shards;
        }

        public void setShards(ArrayList<Account> branch) {
            this.shards = branch;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AccountData that = (AccountData) o;

            if (primary != null ? !primary.equals(that.primary) : that.primary != null)
                return false;
            return shards != null ? shards.equals(that.shards) : that.shards == null;
        }

        @Override
        public int hashCode() {
            int result = primary != null ? primary.hashCode() : 0;
            result = 31 * result + (shards != null ? shards.hashCode() : 0);
            return result;
        }
    }

    public AccountData getQKCGetAccountData() {
        return getResult();
    }
}
