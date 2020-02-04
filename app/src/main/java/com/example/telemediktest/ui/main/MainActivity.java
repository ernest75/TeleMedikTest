package com.example.telemediktest.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.telemediktest.R;
import com.example.telemediktest.model.User;

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
        mainAdapter = new MainAdapter(users,mContext);
        rvUsers.setLayoutManager(new LinearLayoutManager(mContext));
        rvUsers.setAdapter(mainAdapter);

    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }

    @OnClick({R.id.btnRefreshData, R.id.btnShowMap})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRefreshData:
                break;
            case R.id.btnShowMap:
                break;
        }
    }
}
