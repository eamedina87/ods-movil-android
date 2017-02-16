package com.medinamobile.odsmovil.question.ui;

import com.medinamobile.odsmovil.entities.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Supertel on 30/12/16.
 */

public interface QuestionView {

    void startTimer();
    void showQuestion(int order);
    void showResume(ArrayList<Response> responses, int score, int highscore, boolean isNewHighScore);

}
