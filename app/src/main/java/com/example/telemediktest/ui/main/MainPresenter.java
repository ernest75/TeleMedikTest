package com.example.telemediktest.ui.main;

import android.content.Context;
import android.util.Log;

import com.example.telemediktest.model.Results;
import com.example.telemediktest.networking.RetrofitInstance;
import com.example.telemediktest.networking.UsersApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainActivityMVP.Presenter {

    UsersApi serviceAoiUser = RetrofitInstance.getRetrofitInstance().create(UsersApi.class);

    MainActivityMVP.View mView;

    Context mContext;

    public MainPresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void setView(MainActivityMVP.View view) {
         this.mView = view;
    }

    @Override
    public void getDataFromServer() {

        mView.showProgressbar();

        Call<Results> call = serviceAoiUser.getUsers();

        //Log the URL called
        Log.e("URL Called", call.request().url() + "");

        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                mView.hideProgressbar();
                mView.showData(response.body().getData());
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {

            }
        });

    }


}
