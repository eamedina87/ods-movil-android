package com.medinamobile.odsmovil.menu.ui;

import com.medinamobile.odsmovil.entities.ODS;

import java.util.ArrayList;

/**
 * Created by Supertel on 27/12/16.
 */

public interface MenuView {

    //Display a message when a selected ODS is locked
    void onODSLocked(int ODSnumber);

    //Opens the test for an unlocked ODS
    void onODSUnlocked(int ODSnumber);

    //Displays the ODS list with their current progress
    void onshowODSList(ArrayList<ODS> odsList);

}
