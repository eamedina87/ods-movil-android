package com.medinamobile.odsmovil.resume.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.medinamobile.odsmovil.R;
import com.medinamobile.odsmovil.entities.ODS;
import com.medinamobile.odsmovil.entities.Question;
import com.medinamobile.odsmovil.entities.Response;
import com.medinamobile.odsmovil.libs.ODSHelper;
import com.medinamobile.odsmovil.menu.ui.adapters.OnODSClickListener;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ResumeAdapter extends RecyclerView.Adapter<ResumeAdapter.ViewHolder> {



    private final ArrayList<Response> responses;
    private final ArrayList<Question> questions;


    public ResumeAdapter(ArrayList<Question> questions, ArrayList<Response> responses) {
        this.questions = questions;
        this.responses = responses;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resume_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Question question = questions.get(position);
        Response response = responses.get(position);
        holder.question.setText(question.getText());
        holder.answer.setText(response.getText());
        if (response.isCorrect()){
            holder.image.setImageResource(R.mipmap.ic_correct);
        } else {
            holder.image.setImageResource(R.mipmap.ic_wrong);
        }

    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.resume_list_image)
        ImageView image;
        @BindView(R.id.resume_list_question)
        TextView question;
        @BindView(R.id.resume_list_answer)
        TextView answer;

        private final View view;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, view);
        }

    }
}
