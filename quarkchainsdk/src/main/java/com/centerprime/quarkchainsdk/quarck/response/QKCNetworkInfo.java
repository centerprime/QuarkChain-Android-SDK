package com.centerprime.quarkchainsdk.quarck.response;

import com.centerprime.quarkchainsdk.quarck.Response;

import java.util.ArrayList;

/**
 * networkInfo.
 */
public class QKCNetworkInfo extends Response<QKCNetworkInfo.NetworkInfo> {

    public static class NetworkInfo {

        private String networkId;
        private String chainSize;
        private ArrayList<String> shardSizes;

        private boolean syncing;
        private boolean mining;
        private int shardServerCount;

        public NetworkInfo() {
        }

        public NetworkInfo(String networkId, String chainSize, ArrayList<String> shardSizes, boolean syncing, boolean mining, int shardServerCount) {
            this.networkId = networkId;
            this.chainSize = chainSize;
            this.shardSizes = shardSizes;
            this.syncing = syncing;
            this.mining = mining;
            this.shardServerCount = shardServerCount;
        }

        public String getNetworkId() {
            return networkId;
        }

        public void setNetworkId(String networkId) {
            this.networkId = networkId;
        }

        public String getChainSize() {
            return chainSize;
        }

        public void setChainSize(String chainSize) {
            this.chainSize = chainSize;
        }

        public ArrayList<String> getShardSizes() {
            return shardSizes;
        }

        public void setShardSizes(ArrayList<String> shardSizes) {
            this.shardSizes = shardSizes;
        }

        public boolean isSyncing() {
            return syncing;
        }

        public void setSyncing(boolean syncing) {
            this.syncing = syncing;
        }

        public boolean isMining() {
            return mining;
        }

        public void setMining(boolean mining) {
            this.mining = mining;
        }

        public int getShardServerCount() {
            return shardServerCount;
        }

        public void setShardServerCount(int shardServerCount) {
            this.shardServerCount = shardServerCount;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof NetworkInfo)) return false;

            NetworkInfo that = (NetworkInfo) o;

            if (isSyncing() != that.isSyncing()) return false;
            if (isMining() != that.isMining()) return false;
            if (getShardServerCount() != that.getShardServerCount()) return false;
            if (getNetworkId() != null ? !getNetworkId().equals(that.getNetworkId()) : that.getNetworkId() != null)
                return false;
            if (getChainSize() != null ? !getChainSize().equals(that.getChainSize()) : that.getChainSize() != null)
                return false;
            return getShardSizes() != null ? getShardSizes().equals(that.getShardSizes()) : that.getShardSizes() == null;
        }

        @Override
        public int hashCode() {
            int result = getNetworkId() != null ? getNetworkId().hashCode() : 0;
            result = 31 * result + (getChainSize() != null ? getChainSize().hashCode() : 0);
            result = 31 * result + (getShardSizes() != null ? getShardSizes().hashCode() : 0);
            result = 31 * result + (isSyncing() ? 1 : 0);
            result = 31 * result + (isMining() ? 1 : 0);
            result = 31 * result + getShardServerCount();
            return result;
        }
    }

    public NetworkInfo getQKCNetworkInfo() {
        return getResult();
    }
}
