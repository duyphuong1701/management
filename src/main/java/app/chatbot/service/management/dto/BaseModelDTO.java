package app.chatbot.service.management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

import static app.chatbot.service.management.util.DatabaseConstant.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseModelDTO {
    @JsonProperty(A_MODEL_ID)
    private UUID modelId;
    @JsonProperty(A_MODEL_NAME)
    private String name;
    @JsonProperty(A_MODEL_SCORE)
    private String score;
    @JsonProperty(A_MODEL_C)
    private String c;
}
