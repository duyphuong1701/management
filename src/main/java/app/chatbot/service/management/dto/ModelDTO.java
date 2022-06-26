package app.chatbot.service.management.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModelDTO extends BaseModelDTO {
    private String data;
    private String feature;
    private String wb;
}
