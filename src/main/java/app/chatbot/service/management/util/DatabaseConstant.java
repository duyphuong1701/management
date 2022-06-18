package app.chatbot.service.management.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DatabaseConstant {
    public static final String T_CATEGORY = "CATEGORY";
    public static final String A_CATEGORY_ID= "category_id";
    public static final String A_CATEGORY_NAME = "category_name";

    public static final String T_QUESTION_ANSWER = "QUESTION_ANSWER";
    public static final String A_QUESTION_ANSWER_ID = "question_answer_id";
    public static final String A_QUESTION_ANSWER_ASKER = "question_answer_asker";
    public static final String A_QUESTION_ANSWER_ASKER_EMAIL = "question_answer_asker_email";
    public static final String A_QUESTION = "question_content";
    public static final String A_ANSWER = "answer_content";

    public static final String T_QUESTION = "QUESTION";
    public static final String A_QUESTION_ID = "question_id";
    public static final String A_QUESTION_CONTENT = "question_content";

    public static final String T_ANSWER = "ANSWER";
    public static final String A_ANSWER_ID = "answer_id";
    public static final String A_ANSWER_CONTENT = "answer_content";
}
