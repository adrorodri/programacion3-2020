package com.upb.programacion32020;

import com.google.gson.annotations.Expose;

public class Product {

    @Expose
    String name;

    @Expose
    int image;

    @Expose
    int price;

    public Product(String name, int image, int price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
