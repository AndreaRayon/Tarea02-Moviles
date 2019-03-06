package com.iteso.sesion09.beans;

import android.graphics.drawable.Drawable;

public class ItemProduct {
    private String name;
    private String store;
    private String phone;
    private String location;
    private Drawable img;
    private Drawable imgStore;

    public ItemProduct(String name, String store, String phone, String location, Drawable img, Drawable imgStore) {
        this.name = name;
        this.store = store;
        this.phone = phone;
        this.location = location;
        this.img = img;
        this.imgStore = imgStore;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public Drawable getImgStore() {
        return imgStore;
    }

    public void setImgStore(Drawable imgStore) {
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
