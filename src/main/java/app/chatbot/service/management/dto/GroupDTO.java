package app.chatbot.service.management.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import static app.chatbot.service.management.util.DatabaseConstant.*;

@Getter
@Setter
public class GroupDTO {
    @JsonProperty(A_GROUP_ID)
    private String groupId;
    @JsonProperty(A_GROUP_NAME)
    private String groupName;
}

