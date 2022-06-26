package app.chatbot.service.management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static app.chatbot.service.management.util.DatabaseConstant.*;

@Entity
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

    @Column(name = A_CATEGORY_NAME)
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<AnswerEntity> answers;

    @Override
    public String toString() {
        return "(" + this.categoryId + "," + this.categoryName + ")";
    }

}