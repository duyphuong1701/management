package app.chatbot.service.management.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.UUID;

import static app.chatbot.service.management.util.DatabaseConstant.A_MODEL_ID;
import static app.chatbot.service.management.util.DatabaseConstant.T_MODEL_SELECTION;

@Entity
@Builder
@Table(name = T_MODEL_SELECTION)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ModelSelectionEntity {
    @Id
    @Column(name = A_MODEL_ID)
    @NotNull(message = "must not be null")
    private UUID modelId;
}
