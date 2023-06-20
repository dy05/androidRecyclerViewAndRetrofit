package com.example.tppart1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PersonnageService {
    @GET("character")
    Call<PersonnageViewModel> fetchPersonnagesList();
}
