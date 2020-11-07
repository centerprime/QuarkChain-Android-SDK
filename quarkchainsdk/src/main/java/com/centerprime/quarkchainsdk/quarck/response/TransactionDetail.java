package com.centerprime.quarkchainsdk.quarck.response;

public class TransactionDetail {
//    'blockHeight': '0x23fe',
//            'blockId': '0x4d2cb8f556805a1c26b97e92bfdd7aadb746c42c9ba0891237ad40d7bb78c9a40000006c',
//            'data': '0x',
//            'from': '0x68fb978bf0e4c69ba338d4fa5a4e5eaa88438aa8',
//            'fromFullShardId': '0x19e189ec',
//            'toFullShardId': '0x19e189e6',
//            'fromShardId': '0x6c',
//            'toShardId': '0x66',
//            'gas': '0x7530',
//            'gasPrice': '0x2540be400',
//            'hash': '0x444c7a867fcf2621ab258560fa03fd9ba072fc3c5ec585049675d2dd920217f4',
//            'id': '0x444c7a867fcf2621ab258560fa03fd9ba072fc3c5ec585049675d2dd920217f419e189ec',
//            'networkId': '0x3',
//            'nonce': '0x3',
//            'timestamp': '0x5b2a7da6',
//            'to': '0x68fb978bf0e4c69ba338d4fa5a4e5eaa88438aa8',
//            'transactionIndex': '0x0',
//            'v': '0x1c',
//            'r': '0xdceb1caf9e8e01be65f3732bb7ee4ba7914d567a65e832a681e215d6f06a069a',
//            's': '0x414fc2a700954c58150fa86f5145e32c177a1aa2c8e2a0587571c5d01c7f868f',
//            'value': '0x241a9b4f617a280000'


    private String id;
    private String blockHeight;
    private String blockId;
    private String data;
    private String fromShardId;
    private String toShardId;
    private String fromFullShardId;
    private String toFullShardId;
    private String from;
    private String to;
    private String gas;
    private String gasPrice;
    private String hash;
    private String networkId;
    private String nonce;
    private String timestamp;
    private String transactionIndex;
    private String v;
    private String r;
    private String s;
    private String value;


    public TransactionDetail() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(String blockHeight) {
        this.blockHeight = blockHeight;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFromShardId() {
        return fromShardId;
    }

    public void setFromShardId(String fromShardId) {
        this.fromShardId = fromShardId;
    }

    public String getToShardId() {
        return toShardId;
    }

    public void setToShardId(String toShardId) {
        this.toShardId = toShardId;
    }

    public String getFromFullShardId() {
        return fromFullShardId;
    }

    public void setFromFullShardId(String fromFullShardId) {
        this.fromFullShardId = fromFullShardId;
    }

    public String getToFullShardId() {
        return toFullShardId;
    }

    public void setToFullShardId(String toFullShardId) {
        this.toFullShardId = toFullShardId;
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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(String transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionDetail that = (TransactionDetail) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (blockHeight != null ? !blockHeight.equals(that.blockHeight) : that.blockHeight != null)
            return false;
        if (blockId != null ? !blockId.equals(that.blockId) : that.blockId != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (fromShardId != null ? !fromShardId.equals(that.fromShardId) : that.fromShardId != null)
            return false;
        if (toShardId != null ? !toShardId.equals(that.toShardId) : that.toShardId != null)
            return false;
        if (fromFullShardId != null ? !fromFullShardId.equals(that.fromFullShardId) : that.fromFullShardId != null)
            return false;
        if (toFullShardId != null ? !toFullShardId.equals(that.toFullShardId) : that.toFullShardId != null)
            return false;
        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (to != null ? !to.equals(that.to) : that.to != null) return false;
        if (gas != null ? !gas.equals(that.gas) : that.gas != null) return false;
        if (gasPrice != null ? !gasPrice.equals(that.gasPrice) : that.gasPrice != null)
            return false;
        if (hash != null ? !hash.equals(that.hash) : that.hash != null) return false;
        if (networkId != null ? !networkId.equals(that.networkId) : that.networkId != null)
            return false;
        if (nonce != null ? !nonce.equals(that.nonce) : that.nonce != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null)
            return false;
        if (transactionIndex != null ? !transactionIndex.equals(that.transactionIndex) : that.transactionIndex != null)
            return false;
        if (v != null ? !v.equals(that.v) : that.v != null) return false;
        if (r != null ? !r.equals(that.r) : that.r != null) return false;
        if (s != null ? !s.equals(that.s) : that.s != null) return false;
        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (blockHeight != null ? blockHeight.hashCode() : 0);
        result = 31 * result + (blockId != null ? blockId.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (fromShardId != null ? fromShardId.hashCode() : 0);
        result = 31 * result + (toShardId != null ? toShardId.hashCode() : 0);
        result = 31 * result + (fromFullShardId != null ? fromFullShardId.hashCode() : 0);
        result = 31 * result + (toFullShardId != null ? toFullShardId.hashCode() : 0);
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (gas != null ? gas.hashCode() : 0);
        result = 31 * result + (gasPrice != null ? gasPrice.hashCode() : 0);
        result = 31 * result + (hash != null ? hash.hashCode() : 0);
        result = 31 * result + (networkId != null ? networkId.hashCode() : 0);
        result = 31 * result + (nonce != null ? nonce.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (transactionIndex != null ? transactionIndex.hashCode() : 0);
        result = 31 * result + (v != null ? v.hashCode() : 0);
        result = 31 * result + (r != null ? r.hashCode() : 0);
        result = 31 * result + (s != null ? s.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
