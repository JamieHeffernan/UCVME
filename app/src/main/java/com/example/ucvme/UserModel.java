package com.example.ucvme;

public class UserModel {

    //attributes
    private String userID;
    private String name;
    private String surname;
    private String dob;
    private String bio;
    private String location;
    private String county;
    private String status;
    private String picLink;
    private String vidLink;
    private String password;

    //Constructor
    public UserModel(String userID, String name, String surname, String dob, String bio, String location, String county, String status, String picLink, String vidLink, String password) {
        this.userID = userID;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.bio = bio;
        this.location = location;
        this.county = county;
        this.status = status;
        this.picLink = picLink;
        this.vidLink = vidLink;
        this.password = password;
    }

    //empty constructor
    public UserModel(){}

    //getter and setter methods
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }

    public String getVidLink() {
        return vidLink;
    }

    public void setVidLink(String vidLink) {
        this.vidLink = vidLink;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userID='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dob='" + dob + '\'' +
                ", bio='" + bio + '\'' +
                ", location='" + location + '\'' +
                ", county='" + county + '\'' +
                ", status='" + status + '\'' +
                ", picLink='" + picLink + '\'' +
                ", vidLink='" + vidLink + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
