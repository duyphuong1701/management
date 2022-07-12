package app.chatbot.service.management.service;

import app.chatbot.service.management.dto.ModelDTO;
import app.chatbot.service.management.entity.ModelEntity;
import app.chatbot.service.management.repository.ModelRepository;
import app.chatbot.service.management.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelService {

    @Autowired
    private ModelRepository repository;

    public List<ModelEntity> findAll() {
        return repository.findAll();
    }
    public Optional<ModelEntity> findById(UUID id) {
        return repository.findById(id);
    }


    public void update(UUID id, ModelDTO modelDTO) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            var new_entity = ObjectMapper.MAP.toEntity(modelDTO);
            new_entity.setModelId(id);
            repository.save(new_entity);
        }
        throw new RuntimeException("not found ModelEntity to update");
    }

    public void save(ModelDTO t) {
        var entity = ObjectMapper.MAP.toEntity(t);
        this.repository.save(entity);
    }

    public void remove(UUID id) {
        repository.deleteById(id);
    }
    public List<ModelEntity> findAllBase(){
        return this.repository.findAllBase();
    }
}
