package com.medinamobile.odsmovil.preview;

import android.content.Context;

import com.medinamobile.odsmovil.entities.ODS;
import com.medinamobile.odsmovil.entities.Question;
import com.medinamobile.odsmovil.libs.EventBus;
import com.medinamobile.odsmovil.libs.GreenRobotEventBus;
import com.medinamobile.odsmovil.libs.ODSHelper;
import com.medinamobile.odsmovil.preview.events.PreviewEvent;

import java.util.ArrayList;

/**
 * Created by Erick on 1/1/2017.
 */
public class PreviewRepositoryImpl implements PreviewRepository {




    @Override
    public void getQuestionsForTest(Context context, ODS selectedODS) {
        ArrayList<Question> questions = ODSHelper.getAllQuestionsFor(context,selectedODS);
        PreviewEvent event = new PreviewEvent();
        if (questions==null){
            event.setEventType(PreviewEvent.onQuestionsError);
        } else {
            event.setEventType(PreviewEvent.onQuestionsSuccess);
            event.setQuestions(questions);
        }
        postEvent(event);
    }

    private void postEvent(PreviewEvent event) {
        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(event);
    }


}
