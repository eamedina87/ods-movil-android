package com.medinamobile.odsmovil.menu.events;

import com.medinamobile.odsmovil.entities.ODS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Supertel on 27/12/16.
 */
public class MenuEvent {

    public static final int onODSListSuccess = 1;

    private int eventType;
    private ArrayList<ODS> odsList;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public ArrayList<ODS> getOdsList() {
        return odsList;
    }

    public void setOdsList(ArrayList<ODS> odsList) {
        this.odsList = odsList;
    }
}
