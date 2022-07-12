package app.chatbot.service.management.repository;

import app.chatbot.service.management.entity.ModelEntity;
import app.chatbot.service.management.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ModelRepository extends JpaRepository<ModelEntity, UUID> {
    @Query("select new ModelEntity (e.modelId,e.name,e.score,e.c,'') from ModelEntity e")
    List<ModelEntity> findAllBase();
}
