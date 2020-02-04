package com.example.telemediktest.ui.main;

import com.example.telemediktest.model.User;
import com.networking.RetrofitInstance;

import retrofit2.Retrofit;

public class MainPresenter implements MainActivityMVP.Presenter {

    Retrofit mRetrofitInstance = RetrofitInstance.getRetrofitInstance();


    @Override
    public void setView(MainActivityMVP.View view) {

    }

    @Override
    public void refreshButtonClicked() {

    }

    @Override
    public void onGnomeCellClicked(User user) {

    }
}
