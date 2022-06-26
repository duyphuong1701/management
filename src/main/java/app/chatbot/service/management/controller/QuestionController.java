package app.chatbot.service.management.controller;

import app.chatbot.service.management.dto.QuestionDTO;
import app.chatbot.service.management.entity.QuestionEntity;
import app.chatbot.service.management.service.QuestionService;
import app.chatbot.service.management.util.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService service;

    @Operation(summary = "Create a new question")
    @PostMapping
    public void create(@RequestBody QuestionDTO entity) {
        service.save(entity);
    }

    @Operation(summary = "Update a question exist")
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") UUID id, @RequestBody QuestionDTO dto) {
        try {
            service.update(id,dto);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (RuntimeException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Delete a new question")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        service.remove(id);
    }

    @Operation(summary = "Get all question")
    @GetMapping
    public ResponseEntity<List<QuestionDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get question by ID")
    @GetMapping("/{id}")
    public ResponseEntity<QuestionDTO> findByID(@PathVariable("id") UUID id) {
        var entity = service.findById(id);
        if (entity.isPresent()){
            return new ResponseEntity<>(ObjectMapper.MAP.toDTO(entity.get()),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Get question by category id")
    @RequestMapping(value="/{id}/category", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<QuestionDTO>> getByCategory(@PathVariable("id") String id) {
       return new ResponseEntity<>(service.getByCategory(id),HttpStatus.OK);
    }

    @Operation(summary = "Get question by group id")
    @RequestMapping(value="/{id}/group", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<QuestionDTO>> getByGroup(@PathVariable("id") String id) {
        return new ResponseEntity<>(service.getByGroup(id),HttpStatus.OK);
    }
}
