package app.chatbot.service.management.service;

import app.chatbot.service.management.dto.ModelChildDTO;
import app.chatbot.service.management.entity.ModelSelectionEntity;
import app.chatbot.service.management.repository.ModelChildRepository;
import app.chatbot.service.management.repository.ModelRepository;
import app.chatbot.service.management.repository.ModelSelectionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ModelSelectionService {

    @Autowired
    private ModelSelectionRepository repository;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private ModelChildRepository modelChildRepository;

    public ModelChildDTO getSelection() {
        var models =  repository.findAll();
        var modelChild =  new ModelChildDTO();
        modelChild.setModelId(models.get(0).getModelId());
        models.remove(0);
        modelChild.setChild(models.stream().map(e -> e.getModelId()).collect(Collectors.toList()));
        return modelChild;
    }

    public void setSelection(UUID id) {
        repository.deleteAll();
        var model = modelRepository.findById(id);
        if (!model.isPresent()) {
            return;
        }
        repository.save(new ModelSelectionEntity(id));
        if (model.get().getName().equals("parent")) {
            var models = modelChildRepository.findAllByModelId(id);
            log.info(models.toString());
            var modelChilds = models.stream().map(e -> new ModelSelectionEntity(e.getModelChildId())).collect(Collectors.toList());
            repository.saveAll(modelChilds);
        }
    }
}
