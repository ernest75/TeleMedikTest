package com.example.telemediktest.networking;

import com.example.telemediktest.model.Results;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersApi {

    @GET("users")
    Call<Results> getUsers();
}
