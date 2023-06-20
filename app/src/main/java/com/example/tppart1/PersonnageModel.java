package com.example.tppart1;

import com.google.gson.annotations.SerializedName;

public class PersonnageModel {

    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private String image;

    public PersonnageModel(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return image;
    }

    public void setImageUrl(String image) {
        this.image = image;
    }
}
