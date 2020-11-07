package com.centerprime.quarkchainsdk.quarck.request;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class GasLimitForBuyRequest implements Parcelable, Serializable {

    public static final Creator<GasLimitForBuyRequest> CREATOR = new Creator<GasLimitForBuyRequest>() {
        @Override
        public GasLimitForBuyRequest createFromParcel(Parcel in) {
            return new GasLimitForBuyRequest(in);
        }

        @Override
        public GasLimitForBuyRequest[] newArray(int size) {
            return new GasLimitForBuyRequest[size];
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
        parcel.writeString(value);
        parcel.writeString(transferTokenId);
        parcel.writeString(gasTokenId);
    }


    private String from;
    private String to;
    private String data;
    private String value;

    private String transferTokenId;
    private String gasTokenId;

    public GasLimitForBuyRequest() {

    }

    public GasLimitForBuyRequest(String from, String to, String data, String value, String transferTokenId, String gasTokenId) {
        this.from = from;
        this.to = to;
        this.data = data;
        this.value = value;
        this.transferTokenId = transferTokenId;
        this.gasTokenId = gasTokenId;
    }

    public GasLimitForBuyRequest(Parcel in) {
        this.from = in.readString();
        this.to = in.readString();
        this.data = in.readString();
        this.value = in.readString();
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
