package app.chatbot.service.management.service;

import app.chatbot.service.management.dto.CategoryDTO;
import app.chatbot.service.management.entity.CategoryEntity;
import app.chatbot.service.management.exception.ApiException;
import app.chatbot.service.management.repository.CategoryRepository;
import app.chatbot.service.management.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService{

    final private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<CategoryDTO> findAll() {
        return this.categoryRepository.findAll().stream().map(e->ObjectMapper.MAP.toDTO(e)).collect(Collectors.toList());
    }

    public Optional<CategoryEntity> findById(String id) {
        return this.categoryRepository.findById(id);
    }


    public void update(String id, CategoryDTO categoryDTO) {
        var entity = categoryRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ApiException(HttpStatus.BAD_REQUEST,"category_id_not_exist","cant find category");
        }
        categoryDTO.setCategoryId(id);
        this.categoryRepository.save(ObjectMapper.MAP.toEntity(categoryDTO));
    }

    public void save(CategoryDTO t) {
        var entity = ObjectMapper.MAP.toEntity(t);
        this.categoryRepository.save(entity);
    }


    public void remove(String id) {
        this.categoryRepository.deleteById(id);
    }
}
