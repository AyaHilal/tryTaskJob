package com.example.foodcourtlist.main.interfaces;

import com.example.foodcourtlist.pojos.Store;

import java.util.List;

/**
 * Created by Aya on 27/08/2018.
 */

public interface MainPresenterInterface {
    void getStoresListFromPresenter();
    void returnStoresListFromModel(List<Store> storesList);
}
