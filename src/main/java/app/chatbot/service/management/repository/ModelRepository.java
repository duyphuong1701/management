package app.chatbot.service.management.repository;

import app.chatbot.service.management.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModelRepository extends JpaRepository<ModelEntity, UUID> {
}
