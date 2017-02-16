package com.medinamobile.odsmovil.menu;

import android.content.Context;

import com.medinamobile.odsmovil.entities.ODS;
import com.medinamobile.odsmovil.libs.GreenRobotEventBus;
import com.medinamobile.odsmovil.menu.events.MenuEvent;
import com.medinamobile.odsmovil.menu.ui.MenuView;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Supertel on 27/12/16.
 */

public class MenuPresenterImpl implements MenuPresenter {


    private final MenuView view;
    private final GreenRobotEventBus eventBus;
    private MenuInteractor interactor;

    public MenuPresenterImpl(MenuView view, Context context){
        this.view = view;
        interactor = new MenuInteractorImpl(context);
        eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onResume() {
        interactor.getODSList();
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
    }

    @Override
    public void onODSSelected(ODS selectedODS) {
        if (selectedODS.isUnlocked()){
            view.onODSUnlocked(selectedODS.getNumber());
        } else {
            view.onODSLocked(selectedODS.getNumber());
        }
    }

    @Subscribe
    @Override
    public void onMainThreadEvent(MenuEvent event) {
        switch (event.getEventType()){

            case MenuEvent.onODSListSuccess:{
                view.onshowODSList(event.getOdsList());
            }

        }


    }
}
