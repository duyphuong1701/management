package app.chatbot.service.management.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

import static app.chatbot.service.management.util.DatabaseConstant.*;

@Entity
@Builder
@Table(name = T_GROUP)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GroupEntity {

    @Id
    @NotNull(message = "Must not be null")
    @Column(name = A_GROUP_ID)
    private String groupId;

    @NotNull(message = "Must not be null")
    @Column(name = A_GROUP_NAME)
    private String groupName;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private Collection<QuestionEntity> questions;

    @Override
    public String toString() {
        return "(" + this.groupId + "," + this.groupName + ")";
    }

}