package com.medinamobile.odsmovil.question;

import android.content.Context;

import com.medinamobile.odsmovil.libs.DatabaseHelper;
import com.medinamobile.odsmovil.libs.EventBus;
import com.medinamobile.odsmovil.libs.GreenRobotEventBus;
import com.medinamobile.odsmovil.question.events.QuestionEvent;

/**
 * Created by Supertel on 3/1/17.
 */
public class QuestionRepositoryImpl implements QuestionRepository {


    private final DatabaseHelper dbhelper;

    public QuestionRepositoryImpl(Context context){
        dbhelper = DatabaseHelper.getInstance(context);
    }

    @Override
    public void saveScoreIfHigh(int odsNumber, int responseScore) {
        int previousScore = dbhelper.getHighScoreForOds(odsNumber);
        QuestionEvent event = new QuestionEvent();
        if (responseScore>previousScore){
            boolean success = dbhelper.setNewHighScoreForOds(odsNumber, responseScore);
            event.setHighscore(responseScore);
            event.setEventType(success?QuestionEvent.onNewHighScoreSuccess:QuestionEvent.onNewHighScoreError);
        } else {
            event.setEventType(QuestionEvent.onNewHighScoreError);
            event.setHighscore(previousScore);
        }
        dbhelper.close();
        postEvent(event);
    }

    private void postEvent(QuestionEvent event) {
        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(event);
    }
}
