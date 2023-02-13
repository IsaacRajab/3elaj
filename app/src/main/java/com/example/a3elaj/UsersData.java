package com.example.a3elaj;

public class UsersData {
    private int id;
    private String name;
    private String email;
    private String userName;
    private String password;
    private int role;
    private int cartId;

    public UsersData(int id ,String name, String email, String userName, String password,int role ,int cartId) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.role=role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}
