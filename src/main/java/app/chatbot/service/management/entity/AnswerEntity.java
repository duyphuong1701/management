package app.chatbot.service.management.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.UUID;

import static app.chatbot.service.management.util.DatabaseConstant.*;

@Entity
@Table(name = T_ANSWER)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = A_ANSWER_ID)
    private UUID answerId;

    @NotNull(message = "Must not be null")
    @Column(name = A_ANSWER_CONTENT)
    private String answerContent;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

}
