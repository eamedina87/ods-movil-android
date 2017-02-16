package com.medinamobile.odsmovil.question;

import android.content.Context;

/**
 * Created by Supertel on 3/1/17.
 */

public class QuestionInteractorImpl implements QuestionInteractor {

    private QuestionRepository repository;

    public QuestionInteractorImpl(Context context){
        repository = new QuestionRepositoryImpl(context);
    }

    @Override
    public void saveScoreIfHigh(int odsNumber, int responseScore) {
        repository.saveScoreIfHigh(odsNumber, responseScore);
    }
}
