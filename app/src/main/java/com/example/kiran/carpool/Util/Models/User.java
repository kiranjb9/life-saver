package com.example.kiran.carpool.Util.Models;

import java.util.ArrayList;

public class User {
    private static String _id;
    private String fname;
    private String lname;
    private String email;
    private String mobilenumber;
    private String pass;
    private String bloodG;
    private String age;
    private String gender;
    private String place;
    public ArrayList<posts> posts;

    public static String get_id() {
        return _id;
    }

    public static void set_id(String _id) {
        User._id = _id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getBloodG() {
        return bloodG;
    }

    public void setBloodG(String bloodG) {
        this.bloodG = bloodG;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public ArrayList<com.example.kiran.carpool.Util.Models.posts> getPosts(User item) {
        return posts;
    }

    public void setPosts(ArrayList<com.example.kiran.carpool.Util.Models.posts> posts) {
        this.posts = posts;
    }
}
