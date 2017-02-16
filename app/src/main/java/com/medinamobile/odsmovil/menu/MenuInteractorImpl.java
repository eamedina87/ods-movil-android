package com.medinamobile.odsmovil.menu;

import android.content.Context;

/**
 * Created by Supertel on 27/12/16.
 */
public class MenuInteractorImpl implements MenuInteractor {

    private MenuRepository repository;

    public MenuInteractorImpl(Context context){
        repository = new MenuRepositoryImpl(context);
    }

    @Override
    public void getODSList() {
        repository.getODSList();
    }
}
