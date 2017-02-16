package com.medinamobile.odsmovil.preview.ui;

import com.medinamobile.odsmovil.entities.Question;

import java.util.ArrayList;

/**
 * Created by Supertel on 29/12/16.
 */

public interface PreviewView {
    void enableViews();
    void disableViews();

    void showProgress();
    void hideProgress();

    void onBeginTestClicked();
    void beginTest(ArrayList<Question> questions);
    void onProgressAndLevelUpdated();


}
