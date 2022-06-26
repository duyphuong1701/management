package app.chatbot.service.management.repository;


import app.chatbot.service.management.entity.ModelSelectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModelSelectionRepository extends JpaRepository<ModelSelectionEntity, UUID> {

}
