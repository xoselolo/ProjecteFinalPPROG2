package com.example.xosel.projectefinalpprog2.model;

public class School {
    //Attributes
    private int id;
    private String name;
    private String adress;
    private String province;
    private String description;
    private SchoolType type;

    //Constructor
    public School(int id, String name, String adress, String description, SchoolType type, String province) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.description = description;
        this.type = type;
        this.province =province;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
