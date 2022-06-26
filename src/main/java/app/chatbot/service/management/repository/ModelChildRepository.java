package app.chatbot.service.management.repository;

import app.chatbot.service.management.entity.ModelChildEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ModelChildRepository extends JpaRepository<ModelChildEntity, UUID> {
    @Query("select e from ModelChildEntity e where e.modelId in ?1")
    List<ModelChildEntity> findAllByModelId(UUID id);
}
