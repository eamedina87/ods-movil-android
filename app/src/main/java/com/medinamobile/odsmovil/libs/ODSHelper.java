package com.medinamobile.odsmovil.libs;

import android.content.Context;

import com.medinamobile.odsmovil.R;
import com.medinamobile.odsmovil.entities.ODS;
import com.medinamobile.odsmovil.entities.Question;
import com.medinamobile.odsmovil.entities.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Supertel on 27/12/16.
 */

public class ODSHelper {


    public static int getODSImageUnlocked(int position) {
        switch (position){
            case 1:
                return R.mipmap.ic_ods_01;
            case 2:
                return R.mipmap.ic_ods_02;
            case 3:
                return R.mipmap.ic_ods_03;
            case 4:
                return R.mipmap.ic_ods_04;
            case 5:
                return R.mipmap.ic_ods_05;
            case 6:
                return R.mipmap.ic_ods_06;
            case 7:
                return R.mipmap.ic_ods_07;
            case 8:
                return R.mipmap.ic_ods_08;
            case 9:
                return R.mipmap.ic_ods_09;
            case 10:
                return R.mipmap.ic_ods_10;
            case 11:
                return R.mipmap.ic_ods_11;
            case 12:
                return R.mipmap.ic_ods_12;
            case 13:
                return R.mipmap.ic_ods_13;
            case 14:
                return R.mipmap.ic_ods_14;
            case 15:
                return R.mipmap.ic_ods_15;
            case 16:
                return R.mipmap.ic_ods_16;
            case 17:
                return R.mipmap.ic_ods_17;
        }

        return 0;
    }

    public static int getODSImageLogo(int position) {
        switch (position){
            case 1:
                return R.mipmap.ic_ods_01_logo;
            case 2:
                return R.mipmap.ic_ods_02_logo;
            case 3:
                return R.mipmap.ic_ods_03_logo;
            case 4:
                return R.mipmap.ic_ods_04_logo;
            case 5:
                return R.mipmap.ic_ods_05_logo;
            case 6:
                return R.mipmap.ic_ods_06_logo;
            case 7:
                return R.mipmap.ic_ods_07_logo;
            case 8:
                return R.mipmap.ic_ods_08_logo;
            case 9:
                return R.mipmap.ic_ods_09_logo;
            case 10:
                return R.mipmap.ic_ods_10_logo;
            case 11:
                return R.mipmap.ic_ods_11_logo;
            case 12:
                return R.mipmap.ic_ods_12_logo;
            case 13:
                return R.mipmap.ic_ods_13_logo;
            case 14:
                return R.mipmap.ic_ods_14_logo;
            case 15:
                return R.mipmap.ic_ods_15_logo;
            case 16:
                return R.mipmap.ic_ods_16_logo;
            case 17:
                return R.mipmap.ic_ods_17_logo;
        }

        return 0;
    }

    /*public static int getODSImageLocked(int position) {
        switch (position){

            case 1:
                return R.mipmap.ic_ods_01_locked;
            case 2:
                return R.mipmap.ic_ods_02_locked;
            case 3:
                return R.mipmap.ic_ods_03_locked;
            case 4:
                return R.mipmap.ic_ods_04_locked;
            case 5:
                return R.mipmap.ic_ods_05_locked;
            case 6:
                return R.mipmap.ic_ods_06_locked;
            case 7:
                return R.mipmap.ic_ods_07_locked;
            case 8:
                return R.mipmap.ic_ods_08_locked;
            case 9:
                return R.mipmap.ic_ods_09_locked;
            case 10:
                return R.mipmap.ic_ods_10_locked;
            case 11:
                return R.mipmap.ic_ods_11_locked;
            case 12:
                return R.mipmap.ic_ods_12_locked;
            case 13:
                return R.mipmap.ic_ods_13_locked;
            case 14:
                return R.mipmap.ic_ods_14_locked;
            case 15:
                return R.mipmap.ic_ods_15_locked;
            case 16:
                return R.mipmap.ic_ods_16_locked;
            case 17:
                return R.mipmap.ic_ods_17_locked;
        }

        return 0;
    }*/

    public static int getColor(int number) {
        switch (number){
            case 1:
                return R.color.ods1;
            case 2:
                return R.color.ods2;
            case 3:
                return R.color.ods3;
            case 4:
                return R.color.ods4;
            case 5:
                return R.color.ods5;
            case 6:
                return R.color.ods6;
            case 7:
                return R.color.ods7;
            case 8:
                return R.color.ods8;
            case 9:
                return R.color.ods9;
            case 10:
                return R.color.ods10;
            case 11:
                return R.color.ods11;
            case 12:
                return R.color.ods12;
            case 13:
                return R.color.ods13;
            case 14:
                return R.color.ods14;
            case 15:
                return R.color.ods15;
            case 16:
                return R.color.ods16;
            case 17:
                return R.color.ods17;
        }
        return 0;
    }

    public static int getContrasteColor(int number) {
        switch (number){
            case 1:
                return R.color.ods1_contrast;
            case 2:
                return R.color.ods2_contrast;
            case 3:
                return R.color.ods3_contrast;
            case 4:
                return R.color.ods4_contrast;
            case 5:
                return R.color.ods5_contrast;
            case 6:
                return R.color.ods6_contrast;
            case 7:
                return R.color.ods7_contrast;
            case 8:
                return R.color.ods8_contrast;
            case 9:
                return R.color.ods9_contrast;
            case 10:
                return R.color.ods10_contrast;
            case 11:
                return R.color.ods11_contrast;
            case 12:
                return R.color.ods12_contrast;
            case 13:
                return R.color.ods13_contrast;
            case 14:
                return R.color.ods14_contrast;
            case 15:
                return R.color.ods15_contrast;
            case 16:
                return R.color.ods16_contrast;
            case 17:
                return R.color.ods17_contrast;
        }
        return 0;
    }


    public static ArrayList<Question> getAllQuestionsFor(Context context, ODS selectedODS){
        try {
            int number = selectedODS.getNumber();
            switch (number){
                case 1:
                    return XMLHelper.parseQuestions(context.getResources().openRawResource(R.raw.questions_01), selectedODS);
                case 2:
                    return XMLHelper.parseQuestions(context.getResources().openRawResource(R.raw.questions_02), selectedODS);
                case 3:
                    return XMLHelper.parseQuestions(context.getResources().openRawResource(R.raw.questions_03), selectedODS);
                case 4:
                    return XMLHelper.parseQuestions(context.getResources().openRawResource(R.raw.questions_04), selectedODS);
                case 5:
                    return XMLHelper.parseQuestions(context.getResources().openRawResource(R.raw.questions_05), selectedODS);
                case 6:
                    return XMLHelper.parseQuestions(context.getResources().openRawResource(R.raw.questions_06), selectedODS);
                case 7:
                    return XMLHelper.parseQuestions(context.getResources().openRawResource(R.raw.questions_07), selectedODS);
                case 8:
                    return XMLHelper.parseQuestions(context.getResources().openRawResource(R.raw.questions_08), selectedODS);
                case 9:
                    return XMLHelper.parseQuestions(context.getResources().openRawResource(R.raw.questions_09), selectedODS);
                case 10:
                    return XMLHelper.parseQuestions(context.getResources().openRawResource(R.raw.questions_10), selectedODS);
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:

                    return XMLHelper.parseQuestions(context.getResources().openRawResource(R.raw.questions_01), selectedODS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ArrayList<Response> shuffleArray(ArrayList<Response> responses) {
        Collections.shuffle(responses);
        return responses;
    }
}
