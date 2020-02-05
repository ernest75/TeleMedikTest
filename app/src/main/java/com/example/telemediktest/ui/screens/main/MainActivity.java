package com.example.telemediktest.ui.screens.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.telemediktest.R;
import com.example.telemediktest.model.User;
import com.example.telemediktest.ui.screens.map.MapsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityMVP.View {


    private static final String TAG = MainActivity.class.getSimpleName();
    MainActivityMVP.Presenter mPresenter;
    MainAdapter mainAdapter;
    Context mContext;

    @BindView(R.id.rvUsers)
    RecyclerView rvUsers;
    @BindView(R.id.btnRefreshData)
    Button btnRefreshData;
    @BindView(R.id.btnShowMap)
    Button btnShowMap;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mContext = this;
        mPresenter = new MainPresenter(this);
        mPresenter.setView(this);
        mPresenter.getDataFromServer();
    }


    @Override
    public void showData(List<User> users) {

        mainAdapter = new MainAdapter(users, mContext);
        rvUsers.setLayoutManager(new LinearLayoutManager(mContext));
        rvUsers.setAdapter(mainAdapter);

    }

    @Override
    public void showProgressbar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        progressBar.setVisibility(View.GONE);
    }

    @OnClick({R.id.btnRefreshData, R.id.btnShowMap})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRefreshData:
                rvUsers.setAdapter(null);
                mPresenter.getDataFromServer();
                break;
            case R.id.btnShowMap:
                Intent intent = new Intent(mContext, MapsActivity.class);
                mContext.startActivity(intent);
                break;
        }
    }
}
