package com.example.dhruvishah.myapplication.model;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by DhruviShah on 20-12-2016.
 */

public class GOTHouses implements Serializable {
    long id;
    String image;
    String name;
    String houseName;


    public GOTHouses(long id, String name, String houseName) {
        this.id = id;
        this.name = name;
        this.houseName = houseName;
    }
    public GOTHouses(){

    }

    public GOTHouses(String name, String houseName) {
        this.name = name;
        this.houseName = houseName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public  String getImage()
    {
        return image;
    }
    public void setImage(String image){
        this.image = image;
    }


}
