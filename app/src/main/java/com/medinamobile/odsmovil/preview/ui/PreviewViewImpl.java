package com.medinamobile.odsmovil.preview.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.medinamobile.odsmovil.R;
import com.medinamobile.odsmovil.entities.ODS;
import com.medinamobile.odsmovil.entities.Question;
import com.medinamobile.odsmovil.libs.ODSHelper;
import com.medinamobile.odsmovil.preview.PreviewPresenter;
import com.medinamobile.odsmovil.preview.PreviewPresenterImpl;
import com.medinamobile.odsmovil.question.ui.QuestionViewImpl;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Supertel on 29/12/16.
 */

public class PreviewViewImpl extends AppCompatActivity implements PreviewView{

    @BindView(R.id.preview_btn_begin)
    Button btnBegin;
    @BindView(R.id.preview_level)
    TextView level;
    @BindView(R.id.preview_name)
    TextView name;
    @BindView(R.id.preview_shortname)
    TextView shortname;
    @BindView(R.id.preview_image)
    ImageView image;
    @BindView(R.id.preview_layout)
    RelativeLayout layout;

    private ODS mOds;
    private PreviewPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview_layout);
        ButterKnife.bind(this);

        if (getIntent()!=null && getIntent().hasExtra(ODS.INTENT_NAME)){
            mOds = getIntent().getParcelableExtra(ODS.INTENT_NAME);
            setViews();
        }

        presenter = new PreviewPresenterImpl(this);
        presenter.onCreate();

        getSupportActionBar().setCustomView(R.layout.odsbanner);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    private void setViews() {
        layout.setBackgroundColor(getResources().getColor(ODSHelper.getColor(mOds.getNumber())));
        image.setImageResource(ODSHelper.getODSImageLogo(mOds.getNumber()));
        String nameString = String.format(getResources().getString(R.string.preview_name), mOds.getNumber(), mOds.getName());
        name.setText(nameString);
        shortname.setText(mOds.getShortname());
        String levelString = String.format(getString(R.string.preview_level), mOds.getQuestionsAnswered());
        level.setText(levelString);
        btnBegin.setTextColor(getResources().getColor(ODSHelper.getColor(mOds.getNumber())));
    }

    @Override
    public void enableViews() {
        btnBegin.setEnabled(true);
    }

    @Override
    public void disableViews() {
        btnBegin.setEnabled(false);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @OnClick(R.id.preview_btn_begin)
    @Override
    public void onBeginTestClicked() {
        presenter.onBeginTestClicked(getApplicationContext(), this.mOds);
    }

    @Override
    public void beginTest(ArrayList<Question> questions) {
        //start Test Activity
        Intent intent = new Intent(PreviewViewImpl.this, QuestionViewImpl.class);
        intent.putParcelableArrayListExtra(Question.INTENT_NAME, questions);
        startActivity(intent);
    }


    @Override
    public void onProgressAndLevelUpdated() {

    }


}
