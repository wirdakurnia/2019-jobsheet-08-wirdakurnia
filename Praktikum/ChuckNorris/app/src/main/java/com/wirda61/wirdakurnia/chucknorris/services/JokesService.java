package com.wirda61.wirdakurnia.chucknorris.services;

import com.wirda61.wirdakurnia.chucknorris.model.Joke;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokesService {
    @GET("/jokes/random")
    Call<Joke> getRandomJoke();
}
