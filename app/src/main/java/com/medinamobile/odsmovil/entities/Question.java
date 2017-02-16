package com.medinamobile.odsmovil.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Supertel on 30/12/16.
 */

public class Question implements Parcelable{
    public static final String INTENT_NAME = "intent_question";

    private ODS ods;
    private int order;
    private String text;
    private ArrayList<Response> responses;

    public Question(){}

    public Question(Parcel source) {
        setOds((ODS)source.readParcelable(ODS.class.getClassLoader()));
        setOrder(source.readInt());
        setText(source.readString());
        setResponses(source.createTypedArrayList(Response.CREATOR));
    }

    public ArrayList<Response> getResponses() {
        return responses;
    }

    public void setResponses(ArrayList<Response> responses) {
        this.responses = responses;
    }

    public ODS getOds() {
        return ods;
    }

    public void setOds(ODS ods) {
        this.ods = ods;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(getOds(), flags);
        dest.writeInt(getOrder());
        dest.writeString(getText());
        dest.writeTypedArray(getResponses().toArray(new Response[getResponses().size()]),flags);
    }


    public static final Parcelable.Creator<Question> CREATOR = new Creator<Question>() {

        public Question createFromParcel(Parcel source) {

            return new Question(source);
        }

        public Question[] newArray(int size) {

            return new Question[size];
        }

    };
}
