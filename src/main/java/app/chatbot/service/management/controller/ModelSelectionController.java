package app.chatbot.service.management.controller;


import app.chatbot.service.management.dto.ModelChildDTO;
import app.chatbot.service.management.entity.ModelSelectionEntity;
import app.chatbot.service.management.service.ModelSelectionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/selection")
public class ModelSelectionController {

    @Autowired
    private ModelSelectionService service;

    @GetMapping
    @Operation(summary = "get current model predict")
    public ResponseEntity<ModelChildDTO> getSelection(){
       return new ResponseEntity<>(service.getSelection(), HttpStatus.OK);
    }
    @PostMapping("/{id}")
    @Operation(summary = "set model for predict")
    public ResponseEntity<String> setSelection(@PathVariable("id") UUID id){
        service.setSelection(id);
        return new ResponseEntity<>("new model has been set",HttpStatus.OK);
    }
}
