package com.example.kiran.carpool.Util.Models;

public class Posts {
    private String _id;
    private String Req_bloodG;
    private String LatLong;
    private String place;
    private User postedBy;
    private  String Date;
    private  String Time;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getReq_bloodG() {
        return Req_bloodG;
    }

    public void setReq_bloodG(String req_bloodG) {
        Req_bloodG = req_bloodG;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getLatLong() {
        return LatLong;
    }

    public void setLatLong(String latLong) {
        LatLong = latLong;
    }


}
