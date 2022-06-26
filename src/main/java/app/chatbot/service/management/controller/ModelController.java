package app.chatbot.service.management.controller;


import app.chatbot.service.management.dto.BaseModelDTO;
import app.chatbot.service.management.dto.ModelDTO;
import app.chatbot.service.management.entity.ModelEntity;
import app.chatbot.service.management.service.ModelService;
import app.chatbot.service.management.util.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/model")
public class ModelController {

    @Autowired
    ModelService service;

    @Operation(summary = "Create a new model")
    @PostMapping
    public void create(@RequestBody ModelDTO dto) {
        service.save(dto);
    }

    @Operation(summary = "Update a model exist")
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") UUID id, @RequestBody ModelDTO dto) {
        try {
            service.update(id,dto);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (RuntimeException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Delete a model")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        service.remove(id);
    }

    @Operation(summary = "Get all model")
    @GetMapping
    public ResponseEntity<List<ModelEntity>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get model by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ModelEntity> findByID(@PathVariable("id") UUID id) {
        var entity = service.findById(id);
        if (entity.isPresent()){
            return new ResponseEntity<>(entity.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Get all base Model")
    @GetMapping("/base")
    public ResponseEntity<List<BaseModelDTO>> findAllBase() {
        return new ResponseEntity<>(service.findAllBase(), HttpStatus.OK);
    }

    @Operation(summary = "Get base Model by ID")
    @GetMapping("/base/{id}")
    public ResponseEntity<BaseModelDTO> findBaseByID(@PathVariable("id") UUID id) {
        var entity = service.findById(id);
        if (entity.isPresent()){
            return new ResponseEntity<>(ObjectMapper.MAP.converterBase(entity.get()),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }
}
