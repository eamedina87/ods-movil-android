package com.medinamobile.odsmovil.menu;

import com.medinamobile.odsmovil.entities.ODS;
import com.medinamobile.odsmovil.menu.events.MenuEvent;

/**
 * Created by Supertel on 27/12/16.
 */

public interface MenuPresenter {

    void onCreate();
    void onResume();
    void onDestroy();
    void onODSSelected(ODS selectedODS);
    void onMainThreadEvent(MenuEvent event);

}
