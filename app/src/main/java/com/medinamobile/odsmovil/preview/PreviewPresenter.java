package com.medinamobile.odsmovil.preview;

import android.content.Context;

import com.medinamobile.odsmovil.entities.ODS;
import com.medinamobile.odsmovil.preview.events.PreviewEvent;

/**
 * Created by Supertel on 29/12/16.
 */

public interface PreviewPresenter {

    void onCreate();
    void onDestroy();
    void onResume();

    void onBeginTestClicked(Context context, ODS selectedODS);
    void onMainEventThread(PreviewEvent event);

}
