package app.chatbot.service.management.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import static app.chatbot.service.management.util.DatabaseConstant.*;

@Entity
@Table(name = T_QUESTION_ANSWER)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = A_QUESTION_ANSWER_ID, columnDefinition = "serial")
    private Integer questionAnswerId;

    @Column(name = A_QUESTION)
    @NotNull(message = "Must not be null")
    private String question;

    @Column(name = A_QUESTION_ANSWER_ASKER)
    @NotNull(message = "Must not be null")
    private String asker;

    @Column(name = A_QUESTION_ANSWER_ASKER_EMAIL)
    @Email(message = "Email should be valid")
    private String asker_email;

    @Column(name = A_ANSWER)
    private String answer;

    @ManyToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_product"))
    private CategoryEntity category;

}
