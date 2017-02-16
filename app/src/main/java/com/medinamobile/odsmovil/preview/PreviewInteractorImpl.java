package com.medinamobile.odsmovil.preview;

import android.content.Context;

import com.medinamobile.odsmovil.entities.ODS;

/**
 * Created by Erick on 1/1/2017.
 */
public class PreviewInteractorImpl implements PreviewInteractor{

    private PreviewRepository repository;

    public PreviewInteractorImpl(){
        this.repository = new PreviewRepositoryImpl();
    }

    @Override
    public void onBeginTest(Context context, ODS selectedOds) {
        repository.getQuestionsForTest(context,selectedOds);
    }
}
