package com.example.tppart1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonnageActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private PersonnageService personnageService;


    private static final String BASE_URL = "https://api.disneyapi.dev/";
    private Thread thread;
    private RecyclerView recyclerViewPersonnage;
    private PersonnageAdapter personnageAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private Call<PersonnageViewModel> personnageViewModelCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnage);

        layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerViewPersonnage = findViewById(R.id.personnageRecycler);

        // Client Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        personnageService = retrofit.create(PersonnageService.class);
        personnageViewModelCall = personnageService.fetchPersonnagesList();


        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<PersonnageViewModel> response = personnageViewModelCall.execute();

                    if(response.isSuccessful()){
                        List<PersonnageModel> personnagesList = null;
                        if (response.body() != null) {
                            personnagesList = response.body().getPersonnagesList();
                        }

                        List<PersonnageModel> finalPersonnagesList = personnagesList;

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                personnageAdapter = new PersonnageAdapter(
                                    getApplicationContext(),
                                        finalPersonnagesList
                                );

                                recyclerViewPersonnage.setAdapter(personnageAdapter);
                                recyclerViewPersonnage.setLayoutManager(layoutManager);
                                recyclerViewPersonnage.setHasFixedSize(true);
                            }
                        });
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();
    }
}