package com.example.foodcourtlist.main.presenter;

import android.content.Context;

import com.example.foodcourtlist.main.interfaces.MainModelInterface;
import com.example.foodcourtlist.main.interfaces.MainPresenterInterface;
import com.example.foodcourtlist.main.interfaces.MainViewInterface;
import com.example.foodcourtlist.main.model.MainListImplementation;
import com.example.foodcourtlist.pojos.Store;

import java.util.List;

/**
 * Created by Aya on 27/08/2018.
 */

public class MainPresenterImplementation implements MainPresenterInterface {
    MainViewInterface mainView;
    MainModelInterface mainModel;
    Context context;

   public MainPresenterImplementation(MainViewInterface mainViewInterface,Context context){
    this.mainView=mainViewInterface;
    this.context=context;
    mainModel=new MainListImplementation(this,context);

    }

    @Override
    public void getStoresListFromPresenter() {
        mainModel.getStoresListFromModel();
    }

    @Override
    public void returnStoresListFromModel(List<Store> storesList) {
        mainView.displayStoresList(storesList);
    }
}
