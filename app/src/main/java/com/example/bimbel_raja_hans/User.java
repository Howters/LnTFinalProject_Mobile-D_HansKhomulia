package com.example.bimbel_raja_hans;

public class User {
    private String id, email, nama, pass;

    public User(String id, String email, String nama, String pass) {
        this.id = id;
        this.email = email;
        this.nama = nama;
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
