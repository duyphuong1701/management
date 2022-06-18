package app.chatbot.service.management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

import static app.chatbot.service.management.util.DatabaseConstant.*;

@Entity
@Builder
@Table(name = T_CATEGORY)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryEntity {

    @Id
    @NotNull(message = "Must not be null")
    @Column(name = A_CATEGORY_ID)
    private String categoryId;

    @NotNull(message = "Must not be null")
    @Column(name = A_CATEGORY_NAME)
    private String categoryName;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    private Set<QuestionAnswer> question_answer;

    @Override
    public String toString() {
        return "(" + this.categoryId + "," + this.categoryName + ")";
    }

}