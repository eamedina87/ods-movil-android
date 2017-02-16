package com.medinamobile.odsmovil.entities;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.medinamobile.odsmovil.Helper;
import com.medinamobile.odsmovil.libs.DatabaseHelper;
import com.medinamobile.odsmovil.libs.ODSHelper;

/**
 * Created by Supertel on 27/12/16.
 */
public class ODS implements Parcelable{

    public static final String INTENT_NAME = "intent_ods";

    private int number;
    private String name;
    private String shortname;
    private String description;
    private int resourceNameLocked;
    private int resourceNameUnlocked;
    private int questionsTotal;
    private int questionsAnswered;
    private int progress;
    private int status;

    public static final int STATUS_LOCKED = -1;
    public static final int STATUS_UNLOCKED = 1;

    public ODS(int i) {
        setNumber(i);
        if (i==1){
            setStatus(STATUS_UNLOCKED);
        } else {
            setStatus(STATUS_LOCKED);
        }
    }

    public ODS(Parcel source){
        setNumber(source.readInt());
        setName(source.readString());
        setShortname(source.readString());
        setDescription(source.readString());
        setResourceNameLocked(source.readInt());
        setResourceNameUnlocked(source.readInt());
        setQuestionsTotal(source.readInt());
        setQuestionsAnswered(source.readInt());
        setProgress(source.readInt());
        setStatus(source.readInt());
    }

    public ODS(Cursor cursor) {
        //setResourceNameLocked(ODSHelper.getODSImageLocked(getNumber()));
        setResourceNameUnlocked(ODSHelper.getODSImageUnlocked(getNumber()));
        setNumber(cursor.getInt(0));
        setName(cursor.getString(1));
        setShortname(cursor.getString(2));
        setDescription(cursor.getString(3));
        setQuestionsTotal(cursor.getInt(4));
        setQuestionsAnswered(cursor.getInt(5));
        setProgress(cursor.getInt(6));
        setStatus(cursor.getInt(7));

    }

    public static final Parcelable.Creator<ODS> CREATOR = new Creator<ODS>() {

        public ODS createFromParcel(Parcel source) {

            return new ODS(source);
        }

        public ODS[] newArray(int size) {

            return new ODS[size];
        }

    };

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResourceNameLocked() {
        return resourceNameLocked;
    }

    public void setResourceNameLocked(int resourceNameLocked) {
        this.resourceNameLocked = resourceNameLocked;
    }

    public int getQuestionsTotal() {
        return questionsTotal;
    }

    public void setQuestionsTotal(int questionsTotal) {
        this.questionsTotal = questionsTotal;
    }

    public int getQuestionsAnswered() {
        return questionsAnswered;
    }

    public void setQuestionsAnswered(int questionsAnswered) {
        this.questionsAnswered = questionsAnswered;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isUnlocked(){
        return true;//getStatus()==STATUS_UNLOCKED;
    }

    public int getResourceNameUnlocked() {
        return resourceNameUnlocked;
    }

    public void setResourceNameUnlocked(int resourceNameUnlocked) {
        this.resourceNameUnlocked = resourceNameUnlocked;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getNumber());
        parcel.writeString(getName());
        parcel.writeString(getShortname());
        parcel.writeString(getDescription());
        parcel.writeInt(getResourceNameLocked());
        parcel.writeInt(getResourceNameUnlocked());
        parcel.writeInt(getQuestionsTotal());
        parcel.writeInt(getQuestionsAnswered());
        parcel.writeInt(getProgress());
        parcel.writeInt(getStatus());
    }
}
