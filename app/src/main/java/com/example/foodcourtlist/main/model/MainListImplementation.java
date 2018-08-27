package com.example.foodcourtlist.main.model;

import android.content.Context;

import com.example.foodcourtlist.main.interfaces.ApiManagerInterface;
import com.example.foodcourtlist.main.interfaces.MainModelInterface;
import com.example.foodcourtlist.main.interfaces.MainPresenterInterface;
import com.example.foodcourtlist.main.presenter.MainPresenterImplementation;
import com.example.foodcourtlist.pojos.Store;

import java.util.List;

/**
 * Created by Aya on 27/08/2018.
 */

public class MainListImplementation implements MainModelInterface {

    MainPresenterInterface mainPresenter;
    Context context;
    ApiManagerInterface apiManager;

    public MainListImplementation(MainPresenterImplementation mainPresenterImplementation, Context context) {
    this.mainPresenter=mainPresenterImplementation;
    this.context=context;
    apiManager=new ApiManager(this,context);

    }

    @Override
    public void getStoresListFromModel() {
        apiManager.getStoresListFromApi();
    }

    @Override
    public void returnStoresListFromApi(List<Store> storesList) {
        mainPresenter.returnStoresListFromModel(storesList);
    }
}
