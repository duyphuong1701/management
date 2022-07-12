package app.chatbot.service.management.controller;


import app.chatbot.service.management.dto.ModelBaseDTO;
import app.chatbot.service.management.dto.ModelDTO;
import app.chatbot.service.management.dto.QuestionDTO;
import app.chatbot.service.management.entity.ModelEntity;
import app.chatbot.service.management.service.ModelService;
import app.chatbot.service.management.util.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(maxAge = 3600)
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

    @Operation(summary = "Get all model base")
    @GetMapping("/base")
    public ResponseEntity<List<ModelBaseDTO>> findAllBase() {
        return new ResponseEntity<>(service.findAllBase().stream().map(e->ObjectMapper.MAP.toBaseDTO(e)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @Operation(summary = "Predict score json income")
    @ApiResponse(responseCode = "201", description = "Return question info", content = @Content( schema = @Schema(implementation = QuestionDTO.class)))
    @ApiResponse(responseCode = "400", description = "Missing request parameter", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @PostMapping("/predict")
    public ResponseEntity<QuestionDTO> predictNew(@RequestBody QuestionDTO questions){
        return ResponseEntity.status(HttpStatus.CREATED).body(questions);
    }
}
