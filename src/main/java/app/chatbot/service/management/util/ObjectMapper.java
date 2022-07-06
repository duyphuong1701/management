package app.chatbot.service.management.util;

import app.chatbot.service.management.dto.*;
import app.chatbot.service.management.entity.AnswerEntity;
import app.chatbot.service.management.entity.CategoryEntity;
import app.chatbot.service.management.entity.ModelEntity;
import app.chatbot.service.management.entity.QuestionEntity;
import app.chatbot.service.management.repository.CategoryRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;

@Mapper(componentModel = "spring")
public abstract class ObjectMapper {

    @Autowired
    protected CategoryRepository categoryRepository;

    public static ObjectMapper MAP = Mappers.getMapper(ObjectMapper.class);

    public abstract ModelDTO converter(ModelEntity source);

    public abstract ModelEntity toEntity(ModelDTO source);

    public abstract BaseModelDTO converterBase(ModelEntity source);

    @Mapping(target = "answerId", ignore = true)
    @Mapping(target = "category", ignore = true)
    public abstract AnswerEntity toEntity(AnswerDTO source);

    @Mapping(target = "questionId", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "group",ignore = true)
    public abstract QuestionEntity toEntity(QuestionDTO source);

    @Mapping(target = "categoryId", source = "category.categoryId")
    public abstract AnswerDTO toDTO(AnswerEntity source);

    @Mapping(target = "categoryId", source = "category.categoryId")
    @Mapping(target = "groupId", source = "group.groupId")
    public abstract QuestionDTO toDTO(QuestionEntity source);

    public abstract CategoryEntity toEntity(CategoryDTO source);
    public abstract CategoryDTO toDTO(CategoryEntity source);


}
