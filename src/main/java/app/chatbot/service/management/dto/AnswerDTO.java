package app.chatbot.service.management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static app.chatbot.service.management.util.DatabaseConstant.*;

@Getter
@Setter
public class AnswerDTO {
    @JsonProperty(A_ANSWER_ID)
    private UUID answerId;
    @JsonProperty(A_CATEGORY_ID)
    private String categoryId;
    @JsonProperty(A_ANSWER_CONTENT)
    private String answerContent;
}
