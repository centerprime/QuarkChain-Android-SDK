package com.centerprime.quarkchainsdk.quarck;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import java.math.BigDecimal;

/**
 * QWToken实体类，Token相关表
 * foreignColumnName：外键约束指向的类中的属性名
 * foreign：当前字段是否是外键
 * foreignAutoRefresh：如果这个属性设置为true，在关联查询的时候就不需要再调用refresh()方法了
 */
public class QWToken implements Parcelable {
    public static final Creator<QWToken> CREATOR = new Creator<QWToken>() {
        @Override
        public QWToken createFromParcel(Parcel in) {
            return new QWToken(in);
        }

        @Override
        public QWToken[] newArray(int size) {
            return new QWToken[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(iconPath);
        parcel.writeString(address);
        parcel.writeString(symbol);
        parcel.writeString(totalSupply);
        parcel.writeString(decimals);
        parcel.writeString(url);
        parcel.writeString(descriptionCn);
        parcel.writeString(descriptionEn);

        parcel.writeInt(isAdd);
        parcel.writeInt(type);
        parcel.writeInt(chainId);
        parcel.writeInt(isNative);
        parcel.writeInt(isShow);
        parcel.writeInt(isDelete);
    }

    // 表中各个字段的名称
    private static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_NAME = "name";
    private static final String COLUMN_NAME_ICON = "iconPath";
    public static final String COLUMN_NAME_ADDRESS = "address";
    private static final String COLUMN_NAME_SYMBOL = "symbol";//token符号
    private static final String COLUMN_NAME_TOTAL_SUPPLY = "totalSupply";//总数量
    private static final String COLUMN_NAME_DECIMALS = "decimals";//有效小数
    private static final String COLUMN_NAME_URL = "url";//网页详情
    private static final String COLUMN_NAME_DESC_CN = "descriptionCn";//中文描述
    private static final String COLUMN_NAME_DESC_EN = "descriptionEn";//英文描述
    public static final String COLUMN_NAME_TYPE = "type";//属于什么币种的token
    public static final String COLUMN_NAME_CHAIN_ID = "chainId";//属于币种的那个网络节点
    public static final String COLUMN_NAME_NATIVE = "native";
    public static final String COLUMN_NAME_IS_ADD = "isAdd";//是否为手动添加
    public static final String COLUMN_NAME_IS_DELETE = "isDelete";//是否假删除

    private int id;

    private String name;

    private String iconPath;

    private String address;

    private String symbol;

    private String totalSupply;

    private String decimals;

    private String url;

    private String descriptionCn;

    private String descriptionEn;

    private int isAdd;

    private int type;

    private int chainId;

    private int isNative;

    private int isDelete;//做数据假删除

    private int isShow;
    private BigDecimal mRefundPercentage;
    private BigDecimal mReserveTokenBalance;

    public QWToken() {
    }

    private QWToken(Parcel in) {
        id = in.readInt();
        name = in.readString();
        iconPath = in.readString();
        address = in.readString();
        symbol = in.readString();
        totalSupply = in.readString();
        decimals = in.readString();

        url = in.readString();
        descriptionCn = in.readString();
        descriptionEn = in.readString();

        isAdd = in.readInt();
        type = in.readInt();
        chainId = in.readInt();
        isNative = in.readInt();

        isShow = in.readInt();

        isDelete = in.readInt();
    }

    public QWToken(String name, String iconPath, String address, String symbol, String totalSupply,
                   String decimals, String url, String descriptionCn, String descriptionEn, int add,
                   int type, int chainId, int isDelete) {
        this.name = name;
        this.iconPath = iconPath;
        this.address = address;
        this.symbol = symbol;
        this.totalSupply = totalSupply;
        this.decimals = decimals;
        this.url = url;
        this.descriptionCn = descriptionCn;
        this.descriptionEn = descriptionEn;
        this.isAdd = add;
        this.type = type;
        this.chainId = chainId;
        this.isDelete = isDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getDecimals() {
        return decimals;
    }

    public void setDecimals(String decimals) {
        this.decimals = decimals;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescriptionCn() {
        return descriptionCn;
    }

    public void setDescriptionCn(String descriptionCn) {
        this.descriptionCn = descriptionCn;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public int getIsAdd() {
        return isAdd;
    }

    public void setIsAdd(int isAdd) {
        this.isAdd = isAdd;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setChainId(int chainId) {
        this.chainId = chainId;
    }

    public int getChainId() {
        return chainId;
    }

    public void setIsNative(int isNative) {
        this.isNative = isNative;
    }

    public int getIsNative() {
        return isNative;
    }

    public boolean isNative() {
        return 1 == isNative;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }

    public boolean isShow() {
        return 1 == isShow;
    }

    public boolean isDelete() {
        return isDelete == 1;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public void setRefundPercentage(BigDecimal mRefundPercentage) {
        this.mRefundPercentage = mRefundPercentage;
    }

    public BigDecimal getRefundPercentage() {
        return mRefundPercentage;
    }

    public BigDecimal getReserveTokenBalance() {
        return mReserveTokenBalance;
    }

    public void setReserveTokenBalance(BigDecimal reserveTokenBalance) {
        this.mReserveTokenBalance = reserveTokenBalance;
    }

    @Override
    public String toString() {
        return "QWToken{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", iconPath='" + iconPath + '\'' +
                ", address='" + address + '\'' +
                ", symbol='" + symbol + '\'' +
                ", totalSupply='" + totalSupply + '\'' +
                ", decimals='" + decimals + '\'' +
                ", url='" + url + '\'' +
                ", descriptionCn='" + descriptionCn + '\'' +
                ", descriptionEn='" + descriptionEn + '\'' +
                ", isAdd='" + isAdd + '\'' +
                ", type='" + type + '\'' +
                ", chainId='" + chainId + '\'' +
                ", isShow='" + isShow + '\'' +
                ", isDelete='" + isDelete + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QWToken)) return false;

        QWToken token = (QWToken) o;

        if (getAddress() == null && token.getAddress() == null) {
            return true;
        }
        return getAddress() != null && getAddress().toLowerCase().equals(token.getAddress().toLowerCase());
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getSymbol() != null ? getSymbol().hashCode() : 0);
        return result;
    }

    public Convert.Unit getTokenUnit() {
        if (TextUtils.isEmpty(decimals)) {
            return Convert.Unit.ETHER;
        }
        return Convert.Unit.ADJUST.setWeiFactor(Integer.parseInt(decimals));
    }
}
