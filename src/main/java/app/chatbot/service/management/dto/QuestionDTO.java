package app.chatbot.service.management.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import static app.chatbot.service.management.util.DatabaseConstant.*;

@Getter
@Setter
public class QuestionDTO {
    @JsonProperty(A_QUESTION_ID)
    private String questionId;
    @JsonProperty(A_CATEGORY_ID)
    private String categoryId;
    @JsonProperty(A_GROUP_ID)
    private String groupId;
    @JsonProperty(A_QUESTION_CONTENT)
    private String questionContent;
}
