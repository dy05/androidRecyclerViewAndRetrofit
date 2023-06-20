package com.example.tppart1;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonnageViewModel {

    @SerializedName("data")
    private List<PersonnageModel> personnagesList;

    public PersonnageViewModel(List<PersonnageModel> personnageList) {
        this.personnagesList = personnageList;
    }

    public List<PersonnageModel> getPersonnagesList() {
        return personnagesList;
    }

    public void setPersonnagesList(List<PersonnageModel> personnagesList) {
        this.personnagesList = personnagesList;
    }
}
