package com.medinamobile.odsmovil.question;

import android.content.Context;
import android.os.AsyncTask;

import com.medinamobile.odsmovil.entities.Question;
import com.medinamobile.odsmovil.entities.Response;
import com.medinamobile.odsmovil.libs.EventBus;
import com.medinamobile.odsmovil.libs.GreenRobotEventBus;
import com.medinamobile.odsmovil.question.events.QuestionEvent;
import com.medinamobile.odsmovil.question.ui.QuestionView;
import com.medinamobile.odsmovil.question.ui.QuestionViewImpl;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Erick on 1/2/2017.
 */

public class QuestionPresenterImpl implements QuestionPresenter {

    private final QuestionInteractor interactor;
    private ArrayList<Response> responses;
    int responseCont = 0;
    int responseScore = -0;
    private QuestionViewImpl view;
    private EventBus eventBus;

    public QuestionPresenterImpl(QuestionViewImpl view, Context context) {
        this.view = view;
        eventBus = GreenRobotEventBus.getInstance();
        interactor = new QuestionInteractorImpl(context);
        responses = new ArrayList<>();
    }


    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
    }

    @Override
    public void onResponseClicked(Response response) {
        responseCont++;
        responses.add(response);
        if (response.isCorrect()){
            responseScore++;
        }
        if (responseCont<17){
            view.showQuestion(responseCont+1);
        } else {
            interactor.saveScoreIfHigh(view.getQuestion().getOds().getNumber(), responseScore);
        }
    }

    @Subscribe
    @Override
    public void onMainEventThread(QuestionEvent event) {
        switch (event.getEventType()){
            case QuestionEvent.onNewHighScoreSuccess:{
                view.showResume(responses, responseScore, event.getHighscore(), true);
                break;
            }
            case QuestionEvent.onNewHighScoreError:{
                view.showResume(responses, responseScore, event.getHighscore(), false);
                break;
            }
        }
    }


}
