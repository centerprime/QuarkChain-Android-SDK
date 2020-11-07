package com.centerprime.quarkchainsdk.quarck.request;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class TokenBalance implements Parcelable, Serializable {

    public static final Creator<TokenBalance> CREATOR = new Creator<TokenBalance>() {
        @Override
        public TokenBalance createFromParcel(Parcel in) {
            return new TokenBalance(in);
        }

        @Override
        public TokenBalance[] newArray(int size) {
            return new TokenBalance[size];
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
        parcel.writeString(gasPrice);
        parcel.writeString(gas);
        parcel.writeString(data);
    }


    private String from;
    private String to;
    private String gasPrice;
    private String gas;
    private String data;

    public TokenBalance() {

    }

    public TokenBalance(String from, String to, String gasPrice, String gas, String data) {
        this.from = from;
        this.to = to;
        this.gasPrice = gasPrice;
        this.gas = gas;
        this.data = data;
    }

    public TokenBalance(Parcel in) {
        this.from = in.readString();
        this.to = in.readString();
        this.gasPrice = in.readString();
        this.gas = in.readString();
        this.data = in.readString();
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

    public String getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }
}
