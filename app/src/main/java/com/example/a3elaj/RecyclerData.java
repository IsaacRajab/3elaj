package com.example.a3elaj;

public class RecyclerData {
    private String product;
    private int imgid;
    private double  amount;

    public RecyclerData(String title, int imgid, double amount) {
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
