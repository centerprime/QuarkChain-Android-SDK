package com.centerprime.quarkchainsdk.quarck.request;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class GasLimitRequest implements Parcelable, Serializable {

    public static final Creator<GasLimitRequest> CREATOR = new Creator<GasLimitRequest>() {
        @Override
        public GasLimitRequest createFromParcel(Parcel in) {
            return new GasLimitRequest(in);
        }

        @Override
        public GasLimitRequest[] newArray(int size) {
            return new GasLimitRequest[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(from);
        parcel.writeString(to);
        parcel.writeString(data);
        parcel.writeString(transferTokenId);
        parcel.writeString(gasTokenId);
    }


    private String from;
    private String to;
    private String data;
    private String transferTokenId;
    private String gasTokenId;

    public GasLimitRequest() {

    }

    public GasLimitRequest(String from, String to, String data, String transferTokenId, String tokenId) {
        this.from = from;
        this.to = to;
        this.data = data;
        this.transferTokenId = transferTokenId;
        this.gasTokenId = tokenId;
    }

    public GasLimitRequest(Parcel in) {
        this.from = in.readString();
        this.to = in.readString();
        this.data = in.readString();
        this.transferTokenId = in.readString();
        this.gasTokenId = in.readString();
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getGasTokenId() {
        return gasTokenId;
    }

    public void setGasTokenId(String gasTokenId) {
        this.gasTokenId = gasTokenId;
    }

    public void setTransferTokenId(String transferTokenId) {
        this.transferTokenId = transferTokenId;
    }

    public String getTransferTokenId() {
        return transferTokenId;
    }
}
