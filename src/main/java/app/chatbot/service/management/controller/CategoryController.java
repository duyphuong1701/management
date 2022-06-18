package app.chatbot.service.management.controller;

import app.chatbot.service.management.entity.CategoryEntity;
import app.chatbot.service.management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/get-all")
    public ResponseEntity<List<CategoryEntity>> getAll(){
        return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> getById(@PathVariable String id){
        return new ResponseEntity<>(categoryService.getById(id),HttpStatus.OK);
    }

}
