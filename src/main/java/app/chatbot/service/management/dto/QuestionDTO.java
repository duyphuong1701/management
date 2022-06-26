package app.chatbot.service.management.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDTO {
    private String questionId;
    private String categoryId;
    private String groupId;
    private String questionContent;
}
