package com.example.telemediktest.ui.screens.main;

import com.example.telemediktest.model.User;

import java.util.List;

public interface MainActivityMVP {

    interface View {

        void showData(List<User> users);

        void showProgressbar();

        void hideProgressbar();
    }

    interface Presenter {

        void setView(MainActivityMVP.View view);

        void getDataFromServer();


    }


}
