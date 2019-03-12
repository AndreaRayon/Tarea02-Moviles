package com.iteso.sesion09.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemProduct implements Parcelable {
    private String name;
    private String store;
    private String phone;
    private String location;
    private int img;
    private int imgStore;
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ItemProduct(String name, String store, String phone, String location, int img, int imgStore, int code) {
        this.name = name;
        this.store = store;
        this.phone = phone;
        this.location = location;
        this.img = img;
        this.imgStore = imgStore;
        this.code = code;
    }


    public ItemProduct(){
        this.name = "";
        this.store = "";
        this.phone = "";
        this.location = "";
        this.img = 0;
    }
    protected ItemProduct(Parcel in) {
        name = in.readString();
        store = in.readString();
        phone = in.readString();
        location = in.readString();
        code = in.readInt();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(store);
        dest.writeString(phone);
        dest.writeString(location);
        dest.writeInt(code);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<ItemProduct> CREATOR = new Parcelable.Creator<ItemProduct>() {
        @Override
        public ItemProduct createFromParcel(Parcel in) {
            return new ItemProduct(in);
        }

        @Override
        public ItemProduct[] newArray(int size) {
            return new ItemProduct[size];
        }
    };

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getImgStore() {
        return imgStore;
    }

    public void setImgStore(int imgStore) {
        this.imgStore = imgStore;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "name='" + name + '\'' +
                ", store='" + store + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
