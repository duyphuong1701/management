package app.chatbot.service.management.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DatabaseConstant {
    public static final String T_CATEGORY = "tb_CATEGORY";
    public static final String A_CATEGORY_ID = "category_id";
    public static final String A_CATEGORY_NAME = "category_name";

    public static final String T_QUESTION = "tb_QUESTION";
    public static final String A_QUESTION_ID = "question_id";
    public static final String A_QUESTION_CONTENT = "question_content";

    public static final String T_ANSWER = "tb_ANSWER";
    public static final String A_ANSWER_ID = "answer_id";
    public static final String A_ANSWER_CONTENT = "answer_content";

    public static final String T_MODEL_SELECTION = "tb_model_selection";
    public static final String A_MODEL_ID = "model_id";

    public static final String T_MODEL = "tb_model";
    public static final String A_MODEL_NAME = "name";
    public static final String A_MODEL_DATA = "data";
    public static final String A_MODEL_SCORE = "score";
    public static final String A_MODEL_C = "c_parameter";
    public static final String A_MODEL_FEATURE = "feature";
    public static final String A_MODEL_WB = "wb";

    public static final String T_MODEL_CHILD = "tb_model_child";
    public static final String A_MODEL_CHILD_ID = "model_child_id";

    public static final String T_GROUP = "tb_group";
    public static final String A_GROUP_ID = "group_id";
    public static final String A_GROUP_NAME = "group_name";
}
