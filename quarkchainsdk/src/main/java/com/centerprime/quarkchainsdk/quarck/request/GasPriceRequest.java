package com.centerprime.quarkchainsdk.quarck.request;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class GasPriceRequest implements Parcelable, Serializable {

    public static final Creator<GasPriceRequest> CREATOR = new Creator<GasPriceRequest>() {
        @Override
        public GasPriceRequest createFromParcel(Parcel in) {
            return new GasPriceRequest(in);
        }

        @Override
        public GasPriceRequest[] newArray(int size) {
            return new GasPriceRequest[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(chain);
        parcel.writeString(shard);
        parcel.writeString(transferTokenId);
        parcel.writeString(gasTokenId);
    }


    private String chain;
    private String shard;
    private String transferTokenId;
    private String gasTokenId;

    public GasPriceRequest() {

    }

    public GasPriceRequest(String chain, String shard, String transferTokenId, String tokenId) {
        this.chain = chain;
        this.shard = shard;
        this.transferTokenId = transferTokenId;
        this.gasTokenId = tokenId;
    }

    public GasPriceRequest(Parcel in) {
        this.chain = in.readString();
        this.shard = in.readString();
        this.transferTokenId = in.readString();
        this.gasTokenId = in.readString();
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public String getShard() {
        return shard;
    }

    public void setShard(String shard) {
        this.shard = shard;
    }

    public String getTransferTokenId() {
        return transferTokenId;
    }

    public void setTransferTokenId(String transferTokenId) {
        this.transferTokenId = transferTokenId;
    }

    public String getGasTokenId() {
        return gasTokenId;
    }

    public void setGasTokenId(String gasTokenId) {
        this.gasTokenId = gasTokenId;
    }
}
