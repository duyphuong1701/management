package app.chatbot.service.management.repository;

import app.chatbot.service.management.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AnswerRepository extends JpaRepository<AnswerEntity, UUID> {

    @Query("select e from AnswerEntity e where e.category.categoryId = ?1")
    AnswerEntity findByCategoryId(String id);
}
