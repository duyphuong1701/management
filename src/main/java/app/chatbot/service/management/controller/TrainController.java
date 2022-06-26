package app.chatbot.service.management.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/train")
public class TrainController {
    @PostMapping("/v1")
    public ResponseEntity<String> train1() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
    @PostMapping("/v2")
    public ResponseEntity<String> train2() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
    @PostMapping("/find-parameter/v1")
    public ResponseEntity<String> find1() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
    @PostMapping("/find-parameter/v2")
    public ResponseEntity<String> find2() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
    @PostMapping("/train-shuffle/v1")
    public ResponseEntity<String> shuffle1() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
    @PostMapping("/train-shuffle/v2")
    public ResponseEntity<String> shuffle2() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
}
