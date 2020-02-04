package com.example.telemediktest.ui.main;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.telemediktest.model.Data;
import com.example.telemediktest.model.User;
import com.networking.RetrofitInstance;
import com.networking.UsersApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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
    public void refreshButtonClicked() {

        Call<Data> call = serviceAoiUser.getUsers();

        //Log the URL called
        Log.e("URL Called", call.request().url() + "");

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                mView.showData(response.body().getUsers());
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(mContext,"Something went wrong : " + t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onGnomeCellClicked(User user) {

    }
}
