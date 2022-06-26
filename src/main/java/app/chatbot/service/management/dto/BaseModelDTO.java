package app.chatbot.service.management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseModelDTO {
    private UUID modelId;
    private String name;
    private String score;
    private String c;
}
