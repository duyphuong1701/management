package app.chatbot.service.management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feature")
public class FeatureController {
    @GetMapping("/v1")
    public ResponseEntity<String> feature1() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
    @GetMapping("/v2")
    public ResponseEntity<String> feature2() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
}
