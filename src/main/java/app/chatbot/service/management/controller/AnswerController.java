package app.chatbot.service.management.controller;

import app.chatbot.service.management.dto.AnswerDTO;
import app.chatbot.service.management.service.AnswerService;
import app.chatbot.service.management.util.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    AnswerService service;

    @Operation(summary = "Create a new answer")
    @PostMapping
    public void create(@RequestBody AnswerDTO dto) {
        service.save(dto);
    }

    @Operation(summary = "Update a answer exist")
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") UUID id, @RequestBody AnswerDTO dto) {
        service.update(id, dto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete a new answer")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        service.remove(id);
    }

    @Operation(summary = "Get all answer")
    @GetMapping
    public ResponseEntity<List<AnswerDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get answer by ID")
    @GetMapping("/{id}")
    public ResponseEntity<AnswerDTO> findByID(@PathVariable("id") UUID id) {
        var entity = service.findById(id);
        if (entity.isPresent()) {
            return new ResponseEntity<>(ObjectMapper.MAP.toDTO(entity.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Get answer by category id")
    @RequestMapping(value="/{id}/category", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<AnswerDTO> getByCategory(@PathVariable("id") String id) {
        return new ResponseEntity<>(service.getByCategory(id),HttpStatus.OK);
    }
}
