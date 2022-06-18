package app.chatbot.service.management.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static app.chatbot.service.management.util.DatabaseConstant.*;

@Entity
@Table(name = T_ANSWER)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = A_ANSWER_ID, columnDefinition = "serial")
    private Integer answerId;

    @Column(name = A_CATEGORY_ID)
    private String categoryId;

    @NotNull(message = "Must not be null")
    @Column(name = A_ANSWER_CONTENT)
    private String answerContent;

}
