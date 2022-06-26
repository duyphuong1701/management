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
@Table(name = T_QUESTION)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = A_QUESTION_ID, nullable = false, updatable = false)
    private UUID questionId;


    @NotNull(message = "Must not be null")
    @Column(name = A_QUESTION_CONTENT)
    private String questionContent;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;

}
