package com.example.a3elaj;

public class Product {
    private String product;
    private int imgid;
    private String  amount;

    public Product(String title, int imgid, String amount) {
        this.product = title;
        this.imgid = imgid;
        this.amount = amount;
    }



    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}