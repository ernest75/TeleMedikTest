package com.networking;

import com.example.telemediktest.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersApi {

    @GET("users")
    Call<Data> getUsers();
}
