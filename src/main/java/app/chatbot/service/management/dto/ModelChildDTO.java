package app.chatbot.service.management.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ModelChildDTO {
    private UUID modelId;
    private List<UUID> child;
}
