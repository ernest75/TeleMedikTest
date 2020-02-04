package com.example.telemediktest.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.telemediktest.R;
import com.example.telemediktest.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityMVP.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    public void showData(List<User> users) {

    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }
}
