package com.medinamobile.odsmovil.preview;

import android.content.Context;

import com.medinamobile.odsmovil.entities.ODS;

/**
 * Created by Supertel on 29/12/16.
 */

public interface PreviewInteractor {
    void onBeginTest(Context context, ODS selectedODS);
}
