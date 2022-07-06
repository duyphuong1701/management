package app.chatbot.service.management.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

import static app.chatbot.service.management.util.DatabaseConstant.A_MODEL_ID;

@Getter
@Setter
public class ModelChildDTO {
    @JsonProperty(A_MODEL_ID)
    private UUID modelId;
    private List<UUID> child;
}
