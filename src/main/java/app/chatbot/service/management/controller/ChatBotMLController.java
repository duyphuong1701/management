package app.chatbot.service.management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatbot")
public class ChatBotMLController {
    @GetMapping("/reply/v1")
    public ResponseEntity<String> ping1() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
    @GetMapping("/reply/v2")
    public ResponseEntity<String> ping2() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
}
