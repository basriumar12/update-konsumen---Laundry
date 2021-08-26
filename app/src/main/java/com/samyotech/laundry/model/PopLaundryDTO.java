package com.samyotech.laundry.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PopLaundryDTO implements Serializable {

    String s_no = "";
    String shop_id = "";
    String user_id = "";
    String shop_name = "";
    String country_code = "";
    String mobile = "";
    String address = "";
    String latitude = "";
    String longitude = "";
    String opening_time = "";
    String closing_time = "";
    String description = "";
    String image = "";
    String status = "";
    String type = "";

    String created_at = "";
    String updated_at = "";
    String rating = "";
    String shop_image = "";
    String mulai_hari = "";
    String sampai_hari = "";

    ArrayList<OperationalDto> jam_outlet =new ArrayList<>();

    public ArrayList<OperationalDto> getJam_outlet() {
        return jam_outlet;
    }

    public void setJam_outlet(ArrayList<OperationalDto> jam_outlet) {
        this.jam_outlet = jam_outlet;
    }

    public String getMulai_hari() {
        return mulai_hari;
    }

    public void setMulai_hari(String mulai_hari) {
        this.mulai_hari = mulai_hari;
    }

    public String getSampai_hari() {
        return sampai_hari;
    }

    public void setSampai_hari(String sampai_hari) {
        this.sampai_hari = sampai_hari;
    }

    public String getShop_image() {
        return shop_image;
    }

    public void setShop_image(String shop_image) {
        this.shop_image = shop_image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getS_no() {
        return s_no;
    }

    public void setS_no(String s_no) {
        this.s_no = s_no;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getOpening_time() {
        return opening_time;
    }

    public void setOpening_time(String opening_time) {
        this.opening_time = opening_time;
    }

    public String getClosing_time() {
        return closing_time;
    }

    public void setClosing_time(String closing_time) {
        this.closing_time = closing_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PopLaundryDTO{" +
                "s_no='" + s_no + '\'' +
                ", shop_id='" + shop_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", shop_name='" + shop_name + '\'' +
                ", country_code='" + country_code + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", opening_time='" + opening_time + '\'' +
                ", closing_time='" + closing_time + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", rating='" + rating + '\'' +
                ", shop_image='" + shop_image + '\'' +
                ", mulai_hari='" + mulai_hari + '\'' +
                ", sampai_hari='" + sampai_hari + '\'' +
                '}';
    }
}
