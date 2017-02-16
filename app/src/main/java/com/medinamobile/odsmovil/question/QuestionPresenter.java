package com.medinamobile.odsmovil.question;

import com.medinamobile.odsmovil.entities.Response;
import com.medinamobile.odsmovil.question.events.QuestionEvent;

/**
 * Created by Supertel on 30/12/16.
 */

public interface QuestionPresenter {

    void onCreate();
    void onDestroy();
    void onResponseClicked(Response response);
    void onMainEventThread(QuestionEvent event);
}
