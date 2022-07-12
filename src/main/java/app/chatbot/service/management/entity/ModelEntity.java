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
@Table(name = T_MODEL)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ModelEntity {

    @Id
    @Column(name = A_MODEL_ID)
    private UUID modelId;

    @Column(name = A_MODEL_NAME)
    private String name;

    @Column(name = A_MODEL_SCORE)
    private String score;

    @Column(name = A_MODEL_C)
    private String c;

    @Column(name = A_MODEL_DATA)
    private String data;

}
