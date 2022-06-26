package app.chatbot.service.management.service;


import app.chatbot.service.management.dto.AnswerDTO;
import app.chatbot.service.management.dto.QuestionDTO;
import app.chatbot.service.management.entity.AnswerEntity;
import app.chatbot.service.management.exception.ApiException;
import app.chatbot.service.management.repository.AnswerRepository;
import app.chatbot.service.management.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AnswerService{

    final private AnswerRepository repository;

    final private  CategoryService categoryService;

    @Autowired
    public AnswerService(AnswerRepository repository, CategoryService categoryService) {
        this.repository = repository;
        this.categoryService = categoryService;
    }

    public List<AnswerDTO> findAll() {
        return repository.findAll().stream().map(e->ObjectMapper.MAP.toDTO(e)).collect(Collectors.toList());
    }

    public Optional<AnswerEntity> findById(UUID id) {
        return repository.findById(id);
    }

    public void update(UUID id, AnswerDTO dto) {
        var entity = repository.findById(id);
        if (!entity.isPresent()) {
          throw new ApiException(HttpStatus.BAD_REQUEST,"answer_id_not_exist","cant find answer");
        }
        var temp =convertAnswer(dto);
        temp.setAnswerId(id);
        this.repository.save(temp);
    }

    public void save(AnswerDTO dto) {
        this.repository.save(convertAnswer(dto));
    }

    public void remove(UUID id) {
        repository.deleteById(id);
    }

    public AnswerDTO getByCategory(String id){
        return ObjectMapper.MAP.toDTO(this.repository.findByCategoryId(id));
    }

    private AnswerEntity convertAnswer(AnswerDTO dto){
        var entity = ObjectMapper.MAP.toEntity(dto);
        var category = categoryService.findById(dto.getCategoryId());
        if (!category.isPresent()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "category_id_not_exist", "value not present");
        }
        entity.setCategory(category.get());
        return entity;
    }
}
