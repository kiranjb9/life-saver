package com.example.kiran.carpool.Util.Models;

public class User {
    private String _id;
    private String fname;
    private String lname;
    private String email;
    private String mobilenumber;
    private String pass;
    private String Req_bloodG;
    private Allposts postedBy;
    private String age;
    private String gender;
    private  String place;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Allposts getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(Allposts postedBy) {
        this.postedBy = postedBy;
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

    public String getReq_bloodG() {
        return Req_bloodG;
    }

    public void setReq_bloodG(String req_bloodG) {
        Req_bloodG = req_bloodG;
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
}
