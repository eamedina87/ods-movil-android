package com.medinamobile.odsmovil.preview.events;

import com.medinamobile.odsmovil.entities.Question;

import java.util.ArrayList;

/**
 * Created by Supertel on 29/12/16.
 */
public class PreviewEvent {

    public final static int onQuestionsSuccess = 1;
    public final static int onQuestionsError = 2;

    private int eventType;
    private ArrayList<Question> questions;



    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }




}
