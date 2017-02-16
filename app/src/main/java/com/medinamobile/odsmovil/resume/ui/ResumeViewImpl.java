package com.medinamobile.odsmovil.resume.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.medinamobile.odsmovil.MainActivity;
import com.medinamobile.odsmovil.R;
import com.medinamobile.odsmovil.entities.Question;
import com.medinamobile.odsmovil.entities.Response;
import com.medinamobile.odsmovil.menu.ui.adapters.MenuAdapter;
import com.medinamobile.odsmovil.resume.ui.adapters.ResumeAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Supertel on 3/1/17.
 */

public class ResumeViewImpl extends AppCompatActivity implements ResumeView {

    @BindView(R.id.resume_list)
    RecyclerView listLayout;
    @BindView(R.id.resume_highscore)
    TextView highscore_tv;
    @BindView(R.id.resume_score)
    TextView score_tv;


    private int score;
    private ArrayList<Response> responses;
    private ArrayList<Question> questions;
    private boolean isNewHighScore;
    private ResumeAdapter adapter;
    private int highscore;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resume_layout);
        ButterKnife.bind(this);
        if (getIntent()!=null && getIntent().getExtras()!=null){
            Bundle bundle = getIntent().getExtras();
            score = bundle.getInt("score");
            highscore = bundle.getInt("highscore");
            responses = bundle.getParcelableArrayList("responses");
            questions = bundle.getParcelableArrayList("questions");
            isNewHighScore = bundle.getBoolean("isNewHighScore");
            setViews();
        }
    }

    private void setViews() {
        String scoreString = String.format(getResources().getString(R.string.resume_score), score);
        score_tv.setText(scoreString);
        String highscoreString = String.format(getResources().getString(R.string.resume_highscore), highscore);
        highscore_tv.setText(highscoreString);
        setupAdapter();
        setupRecyclerView();
    }

    private void setupAdapter() {
        adapter = new ResumeAdapter(questions, responses);
    }

    private void setupRecyclerView() {
        listLayout.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        listLayout.setAdapter(adapter);
    }

    @Nullable
    @OnClick({R.id.resume_btn_layout, R.id.resume_btn_mainmenu})
    public void returnToMainMenu(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


}
