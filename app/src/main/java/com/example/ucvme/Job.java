package com.example.ucvme;

public class Job {

    private String title, wage, county, location, jobType, description, jobID;

    public Job(String title, String wage, String county, String location, String jobType, String description, String jobID) {
        this.title = title;
        this.wage = wage;
        this.county = county;
        this.location = location;
        this.jobType = jobType;
        this.description = description;
        this.jobID = jobID;
    }

    public Job(String title, String wage, String county, String location, String jobType, String timestamp) {
    }


    public String getCounty() {
        return county;
    }

    public String getLocation() {
        return location;
    }

    public String getJobType() {
        return jobType;
    }

    public String getDescription() {
        return description;
    }

    public String getJobID() {
        return jobID;
    }

    public String getTitle() {
        return title;
    }

    public String getWage() {
        return wage;
    }

}
