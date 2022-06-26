package app.chatbot.service.management.service;

import app.chatbot.service.management.dto.QuestionDTO;
import app.chatbot.service.management.entity.QuestionEntity;
import app.chatbot.service.management.exception.ApiException;
import app.chatbot.service.management.repository.CategoryRepository;
import app.chatbot.service.management.repository.GroupRepository;
import app.chatbot.service.management.repository.QuestionRepository;
import app.chatbot.service.management.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    final private QuestionRepository repository;

    final private CategoryRepository categoryRepository;

    final private GroupRepository groupRepository;
    @Autowired
    public QuestionService(QuestionRepository repository, CategoryService categoryService, CategoryRepository categoryRepository, GroupRepository groupRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.groupRepository = groupRepository;
    }

    public List<QuestionDTO> findAll() {
        return repository.findAll().stream().map(e-> ObjectMapper.MAP.toDTO(e)).collect(Collectors.toList());
    }

    public Optional<QuestionEntity> findById(UUID id) {
        return repository.findById(id);
    }

    public void update(UUID id, QuestionDTO dto) {
        var entity = repository.findById(id);
        if (!entity.isPresent()) {
            throw new ApiException(HttpStatus.BAD_REQUEST,"answer_id_not_exist","cant find answer");
        }
        var temp =convertQuestion(dto);
        temp.setQuestionId(id);
        this.repository.save(temp);
    }

    public void save(QuestionDTO dto) {
        this.repository.save(convertQuestion(dto));
    }

    public void remove(UUID id) {
        repository.deleteById(id);
    }

    public List<QuestionDTO> getByCategory(String id){
        return this.repository.findAllByCategoryId(id).stream().map(e-> ObjectMapper.MAP.toDTO(e)).collect(Collectors.toList());
    }

    public List<QuestionDTO> getByGroup(String id){
        return this.repository.findAllByGroupId(id).stream().map(e-> ObjectMapper.MAP.toDTO(e)).collect(Collectors.toList());
    }

    private QuestionEntity convertQuestion(QuestionDTO dto){
        var entity = ObjectMapper.MAP.toEntity(dto);
        var category = categoryRepository.findById(dto.getCategoryId());
        if (!category.isPresent()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "category_id_not_exist", "value not present");
        }
        var group = groupRepository.findById(dto.getGroupId());
        if (!group.isPresent()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "group_id_not_exist", "value not present");
        }
        entity.setCategory(category.get());
        entity.setGroup(group.get());
        return entity;
    }
}
