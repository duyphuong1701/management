package app.chatbot.service.management.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.UUID;

import static app.chatbot.service.management.util.DatabaseConstant.*;

@Entity
@Builder
@Table(name = T_MODEL_CHILD)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ModelChildEntity {

    @Id
    @Column(name = A_MODEL_CHILD_ID)
    private UUID modelChildId;

    @Column(name = A_MODLE_ID)
    private UUID modelId;
}
