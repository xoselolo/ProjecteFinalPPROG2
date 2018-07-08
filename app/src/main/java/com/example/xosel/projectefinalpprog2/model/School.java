package com.example.xosel.projectefinalpprog2.model;

public class School {
    //Attributes
    private int id;
    private String name;
    private String adress;
    private double latitude;
    private double longitude;
    private String description;
    private SchoolType type;

    //Constructor
    public School(int id, String name, String adress, double latitude, double longitude, String description, SchoolType type) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.type = type;
    }

    //Getters & Setters
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SchoolType getType() {
        return type;
    }

    public void setType(SchoolType type) {
        this.type = type;
    }
}
