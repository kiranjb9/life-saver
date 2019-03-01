package com.example.kiran.carpool.Util.Models;

public class posts {
    private String _id;
    private String Req_bloodG;
    private String place;
    private String LatLong;
    public String postedBy;

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

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }
}
