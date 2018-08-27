package com.example.foodcourtlist.main.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.foodcourtlist.R;
import com.example.foodcourtlist.main.interfaces.MainPresenterInterface;
import com.example.foodcourtlist.main.interfaces.MainViewInterface;
import com.example.foodcourtlist.main.presenter.MainPresenterImplementation;
import com.example.foodcourtlist.pojos.Store;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoresActivity extends AppCompatActivity implements MainViewInterface{

    @BindView(R.id.storesRecyclerView)  RecyclerView storesRecyclerView;
    MainPresenterInterface mainPresenter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);
        ButterKnife.bind(this);
        mainPresenter=new MainPresenterImplementation(this,StoresActivity.this);

        //set view details of recycler view
        layoutManager = new LinearLayoutManager(this);
        storesRecyclerView.setLayoutManager(layoutManager);
        storesRecyclerView.setHasFixedSize(true);
        RecyclerViewDecorator dividerItemDecoration = new RecyclerViewDecorator(StoresActivity.this);
        storesRecyclerView.addItemDecoration(dividerItemDecoration);
        //call method in presenter to request data
        mainPresenter.getStoresListFromPresenter();

    }

    @Override
    public void displayStoresList(List<Store> storesList) {
        recyclerViewAdapter=new RecyclerViewAdapter(StoresActivity.this,storesList);
        storesRecyclerView.setAdapter(recyclerViewAdapter);
    }
}
