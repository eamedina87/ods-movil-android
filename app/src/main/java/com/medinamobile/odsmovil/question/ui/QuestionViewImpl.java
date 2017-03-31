package com.medinamobile.odsmovil.question.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.medinamobile.odsmovil.R;
import com.medinamobile.odsmovil.entities.Question;
import com.medinamobile.odsmovil.entities.Response;
import com.medinamobile.odsmovil.libs.ODSHelper;
import com.medinamobile.odsmovil.question.QuestionPresenterImpl;
import com.medinamobile.odsmovil.resume.ui.ResumeViewImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Erick on 1/2/2017.
 */

public class QuestionViewImpl extends AppCompatActivity implements QuestionView, OnResponseClick {

    private ArrayList<Question> questions;
    private QuestionPresenterImpl presenter;

    @BindView(R.id.question_container)
    FrameLayout question_container;
    @BindView(R.id.question_image)
    ImageView image;
    @BindView(R.id.question_shortname)
    TextView shortname;
    @BindView(R.id.question_ods_layout)
    LinearLayout layout;




    private Question question;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_view);
        ButterKnife.bind(this);
        if (getIntent()!=null && getIntent().hasExtra(Question.INTENT_NAME)){
            questions = getIntent().getParcelableArrayListExtra(Question.INTENT_NAME);
            showQuestion(1);
        }
        presenter = new QuestionPresenterImpl(this, getApplicationContext());
        presenter.onCreate();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void startTimer() {

    }

    @Override
    public void showQuestion(int order) {
        question = questions.get(order-1);
        if (order==1){
            showQuestionFragment(question);
        } else {
            TimeOut timeOutTask = new TimeOut();
            timeOutTask.execute(question);
        }
    }

    @Override
    public void showResume(ArrayList<Response> responses, int score, int highscore, boolean isNewHighScore) {
        //Open Resume Test
        Intent intent = new Intent(QuestionViewImpl.this, ResumeViewImpl.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("questions", questions);
        bundle.putInt("score", score);
        bundle.putInt("highscore", highscore);
        bundle.putBoolean("isNewHighScore", isNewHighScore);
        bundle.putParcelableArrayList("responses", responses);
        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();
    }

    private void showQuestionFragment(Question question){
        QuestionFragment fragment = new QuestionFragment();
        fragment.setOnResponseClickListener(this);
        fragment.setQuestion(question);

        layout.setBackgroundColor(getResources().getColor(ODSHelper.getColor(question.getOds().getNumber())));
        image.setImageResource(ODSHelper.getODSImageLogo(question.getOds().getNumber()));
        shortname.setText(question.getOds().getShortname());


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.fade_out);
        ft.replace(R.id.question_container,fragment);
        ft.commit();
    }

    public Question getQuestion(){
        return this.question;
    }

    @Override
    public void onResponseClick(Response response) {
        presenter.onResponseClicked(response);
    }

    private class TimeOut extends AsyncTask<Question, Void, Question>{
        @Override
        protected Question doInBackground(Question... params) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return params[0];
        }

        @Override
        protected void onPostExecute(Question question) {
            super.onPostExecute(question);
            showQuestionFragment(question);
        }
    }

}
