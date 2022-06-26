package app.chatbot.service.management.repository;

import app.chatbot.service.management.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, UUID> {

   @Query("select e from QuestionEntity e where e.category.categoryId in ?1")
   List<QuestionEntity> findAllByCategoryId(String id);

   @Query("select e from QuestionEntity e where e.group.groupId in ?1")
   List<QuestionEntity> findAllByGroupId(String id);
}
