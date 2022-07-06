package app.chatbot.service.management.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static app.chatbot.service.management.util.DatabaseConstant.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModelDTO extends BaseModelDTO {
    @JsonProperty(A_MODEL_DATA)
    private String data;
    @JsonProperty(A_MODEL_FEATURE)
    private String feature;
    @JsonProperty(A_MODEL_WB)
    private String wb;
}
