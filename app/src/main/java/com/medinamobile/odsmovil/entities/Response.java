package com.medinamobile.odsmovil.entities;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Supertel on 30/12/16.
 */

public class Response implements Parcelable{

    public final static int RESPONSE_CORRECT = 1;
    public final static int RESPONSE_INCORRECT = -1;


    private String text;
    private Question question;
    private int correct;

    public Response(){}

    public Response(Parcel source) {
        setText(source.readString());
        setQuestion((Question)source.readParcelable(Question.class.getClassLoader()));
        setCorrect(source.readInt());
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isCorrect() {
        return correct==RESPONSE_CORRECT;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getCorrect() {
        return this.correct;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getText());
        dest.writeParcelable(getQuestion(), flags);
        dest.writeInt(getCorrect());
    }

    public static final Parcelable.Creator<Response> CREATOR = new Creator<Response>() {

        public Response createFromParcel(Parcel source) {

            return new Response(source);
        }

        public Response[] newArray(int size) {

            return new Response[size];
        }

    };

}
