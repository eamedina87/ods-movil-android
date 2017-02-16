package com.medinamobile.odsmovil.menu;

import android.content.Context;

import com.medinamobile.odsmovil.entities.ODS;
import com.medinamobile.odsmovil.libs.DatabaseHelper;
import com.medinamobile.odsmovil.libs.EventBus;
import com.medinamobile.odsmovil.libs.GreenRobotEventBus;
import com.medinamobile.odsmovil.menu.events.MenuEvent;

import java.util.ArrayList;

/**
 * Created by Supertel on 27/12/16.
 */
public class MenuRepositoryImpl implements MenuRepository {


    private final DatabaseHelper dbHelper;
    private ArrayList<ODS> odsList;

    public MenuRepositoryImpl(Context context){
        dbHelper = DatabaseHelper.getInstance(context);
    }

    @Override
    public void getODSList() {
        odsList = dbHelper.getAllOds();
        MenuEvent event = new MenuEvent();
        event.setEventType(MenuEvent.onODSListSuccess);
        event.setOdsList(odsList);
        postEvent(event);
        dbHelper.close();
    }


    private void postEvent(MenuEvent event){
        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(event);
    }

}
