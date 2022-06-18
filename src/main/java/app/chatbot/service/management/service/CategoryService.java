package app.chatbot.service.management.service;

import app.chatbot.service.management.entity.CategoryEntity;
import app.chatbot.service.management.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    final private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<CategoryEntity> getAllCategory(){
        return categoryRepository.findAll();
    }

    public CategoryEntity getById(String id){
        var entity = categoryRepository.findById(id);
        if (entity.isPresent()){
            return entity.get();
        }
        return null;
    }
}
