package com.example.ucvme;

public class MainModel {

    //jurl = image of person
    String name,job,email,jurl;


    //initialise getters, setters and constructors for name, job, email and jurl
    MainModel() {

    }
    public MainModel(String name, String job, String email, String jurl) {
        this.name = name;
        this.job = job;
        this.email = email;
        this.jurl = jurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJurl() {
        return jurl;
    }

    public void setJurl(String jurl) {
        this.jurl = jurl;
    }
}
