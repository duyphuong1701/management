package app.chatbot.service.management.controller;

import app.chatbot.service.management.dto.CategoryDTO;
import app.chatbot.service.management.entity.CategoryEntity;
import app.chatbot.service.management.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/categories")
public class CategoryController{

    @Autowired
    CategoryService categoryService;

    @Operation(summary = "Create a new category")
    @PostMapping
    public void create(@RequestBody CategoryDTO dto) {
        this.categoryService.save(dto);
    }

    @Operation(summary = "Update a category exist")
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") String id, @RequestBody CategoryDTO dto) {
        try {
            categoryService.update(id,dto);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (RuntimeException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Delete a new category")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.categoryService.remove(id);
    }

    @Operation(summary = "Get all category")
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        return new ResponseEntity<>(this.categoryService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get category by ID")
    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> findByID(@PathVariable("id") String id) {
        var entity = this.categoryService.findById(id);
        if (entity.isPresent()){
            return new ResponseEntity<>(entity.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }
}
