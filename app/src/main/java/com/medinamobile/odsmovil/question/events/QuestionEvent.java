package com.medinamobile.odsmovil.question.events;

/**
 * Created by Supertel on 3/1/17.
 */
public class QuestionEvent {

    public final static int onNewHighScoreSuccess = 1;
    public final static int onNewHighScoreError = -1;

    private int eventType;
    private int highscore;
    private boolean isNewHighScore;


    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public boolean isNewHighScore() {
        return isNewHighScore;
    }

    public void setNewHighScore(boolean newHighScore) {
        isNewHighScore = newHighScore;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }
}
