package com.centerprime.quarkchainsdk.quarck.response;


import com.centerprime.quarkchainsdk.quarck.Response;

import java.util.ArrayList;

/**
 * transaction
 */
public class QKCGetTransactions extends Response<QKCGetTransactions.TransactionData> {

    public static class TransactionData {

        private String next;
        private ArrayList<Transaction> txList;

        public TransactionData() {

        }

        public TransactionData(String next, ArrayList<Transaction> txList) {
            this.next = next;
            this.txList = txList;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public ArrayList<Transaction> getTxList() {
            return txList;
        }

        public void setTxList(ArrayList<Transaction> txList) {
            this.txList = txList;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TransactionData)) return false;

            TransactionData that = (TransactionData) o;

            if (getNext() != null ? !getNext().equals(that.getNext()) : that.getNext() != null)
                return false;
            return getTxList() != null ? getTxList().equals(that.getTxList()) : that.getTxList() == null;
        }

        @Override
        public int hashCode() {
            int result = getNext() != null ? getNext().hashCode() : 0;
            result = 31 * result + (getTxList() != null ? getTxList().hashCode() : 0);
            return result;
        }
    }

    public TransactionData getTransactionData() {
        return getResult();
    }
}
