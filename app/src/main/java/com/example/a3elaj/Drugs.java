package com.example.a3elaj;

import android.content.Context;

public class Drugs {
    private int id;
    private String name;
    private String details;
    private int img;
    private String price;
    private int quantity;
    Context contextss;

    public static final Drugs[] drugs = {
            new Drugs(0,"Trofeen","For head pain after food",
                    R.drawable.truffen,"19",5) ,
            new Drugs(1,"Banadol","For head pain after food",
                    R.drawable.truffen,"15",5),
            new Drugs(1,"Trofeen","For head pain after food",
                    R.drawable.truffen,"15",5),
            new Drugs(1,"Trofeen","For head pain after food",
                    R.drawable.truffen,"15",5),
            new Drugs(1,"Trofeen","For head pain after food",
                    R.drawable.truffen,"15",5),
            new Drugs(1,"Trofeen","For head pain after food",
                    R.drawable.truffen,"15",5)
    };

    public Drugs(int id, String name, String details, int img, String price, int quantity) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.img = img;
        this.price = price;
        this.quantity = quantity;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
