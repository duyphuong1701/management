package app.chatbot.service.management.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import static app.chatbot.service.management.util.DatabaseConstant.A_CATEGORY_ID;
import static app.chatbot.service.management.util.DatabaseConstant.A_CATEGORY_NAME;

@Getter
@Setter
public class CategoryDTO {
    @JsonProperty(A_CATEGORY_ID)
    private String categoryId;
    @JsonProperty(A_CATEGORY_NAME)
    private String categoryName;
}

