package com.wirda61.wirdakurnia.tugasretrofit.services;

import com.wirda61.wirdakurnia.tugasretrofit.model.Fox;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoxsService {
    @GET("/floof/")
    Call<Fox> getRandomFox();
}
