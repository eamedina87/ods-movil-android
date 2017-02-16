package com.medinamobile.odsmovil.preview;

import android.content.Context;

import com.medinamobile.odsmovil.entities.ODS;
import com.medinamobile.odsmovil.entities.Question;
import com.medinamobile.odsmovil.libs.GreenRobotEventBus;
import com.medinamobile.odsmovil.preview.events.PreviewEvent;
import com.medinamobile.odsmovil.preview.ui.PreviewView;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

/**
 * Created by Erick on 1/1/2017.
 */

public class PreviewPresenterImpl implements PreviewPresenter {

    private final PreviewView view;
    private final PreviewInteractorImpl interactor;
    private final GreenRobotEventBus eventBus;


    public PreviewPresenterImpl(PreviewView view){
        this.view = view;
        this.interactor = new PreviewInteractorImpl();
        this.eventBus = GreenRobotEventBus.getInstance();

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
    public void onResume() {
        view.enableViews();
    }


    @Override
    public void onBeginTestClicked(Context context, ODS selectedODS) {
        view.disableViews();
        interactor.onBeginTest(context, selectedODS);
    }

    @Subscribe
    @Override
    public void onMainEventThread(PreviewEvent event) {
        switch (event.getEventType()){
            case PreviewEvent.onQuestionsSuccess:{
                onQuestionsSuccess(event.getQuestions());
                break;
            }
            case PreviewEvent.onQuestionsError:{

                break;
            }


        }
    }

    private void onQuestionsSuccess(ArrayList<Question> questions) {
        view.beginTest(questions);
    }
}
