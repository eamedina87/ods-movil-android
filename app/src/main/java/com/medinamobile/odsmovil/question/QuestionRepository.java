package com.medinamobile.odsmovil.question;

/**
 * Created by Supertel on 30/12/16.
 */

public interface QuestionRepository {
    void saveScoreIfHigh(int odsNumber, int responseScore);
}
