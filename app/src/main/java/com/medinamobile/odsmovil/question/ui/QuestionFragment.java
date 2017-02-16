package com.medinamobile.odsmovil.question.ui;

import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.medinamobile.odsmovil.R;
import com.medinamobile.odsmovil.entities.Question;
import com.medinamobile.odsmovil.entities.Response;
import com.medinamobile.odsmovil.libs.ODSHelper;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Erick on 1/2/2017.
 */

public class QuestionFragment extends Fragment {

    @BindView(R.id.question_text)
    TextView text;
    @BindView(R.id.question_response_1)
    Button response1;
    @BindView(R.id.question_response_2)
    Button response2;
    @BindView(R.id.question_response_3)
    Button response3;
    @BindView(R.id.question_response_4)
    Button response4;

    private Question question;
    private OnResponseClick onResponseClick;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.question_layout, container, false);
        ButterKnife.bind(this, view);
        setViews();
        return view;
    }

    private void setViews() {
        text.setText(question.getText());
        ArrayList<Response> responses = question.getResponses();
        ODSHelper.shuffleArray(responses);
        Response tmp = responses.get(0);
        response1.setText(tmp.getText());
        response1.setTag(tmp);
        tmp = responses.get(1);
        response2.setText(tmp.getText());
        response2.setTag(tmp);
        tmp = responses.get(2);
        response3.setText(tmp.getText());
        response3.setTag(tmp);
        tmp = responses.get(3);
        response4.setText(tmp.getText());
        response4.setTag(tmp);
    }


    @Nullable
    @OnClick({R.id.question_response_1, R.id.question_response_2, R.id.question_response_3, R.id.question_response_4})
    public void onResponseClick(Button button){
        Response response = (Response)button.getTag();
        if (response.isCorrect()){
            setCorrect(button);
        } else {
            setIncorrect(button);
        }

        onResponseClick.onResponseClick(response);
    }

    private void setIncorrect(Button button) {
        disableButtons();
        setDefaultButtonsColor();
        (button.getBackground()).setColorFilter(getResources().getColor(R.color.response_incorrect), PorterDuff.Mode.MULTIPLY);
    }

    private void setCorrect(Button button) {
        disableButtons();
        setDefaultButtonsColor();
        (button.getBackground()).setColorFilter(getResources().getColor(R.color.response_correct), PorterDuff.Mode.MULTIPLY);
    }

    private void setDefaultButtonsColor() {
        (response1.getBackground()).setColorFilter(getResources().getColor(R.color.response_default), PorterDuff.Mode.MULTIPLY);
        (response2.getBackground()).setColorFilter(getResources().getColor(R.color.response_default), PorterDuff.Mode.MULTIPLY);
        (response3.getBackground()).setColorFilter(getResources().getColor(R.color.response_default), PorterDuff.Mode.MULTIPLY);
        (response4.getBackground()).setColorFilter(getResources().getColor(R.color.response_default), PorterDuff.Mode.MULTIPLY);
    }

    private void disableButtons() {
        response1.setEnabled(false);
        response2.setEnabled(false);
        response3.setEnabled(false);
        response4.setEnabled(false);
    }

    public void setQuestion(Question question){
        this.question = question;
    }

    public void setOnResponseClickListener(OnResponseClick listener){
        this.onResponseClick = listener;
    }


}
