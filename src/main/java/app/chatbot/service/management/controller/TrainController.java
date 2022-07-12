package app.chatbot.service.management.controller;


import app.chatbot.service.management.service.rest.ChatbotMLService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/train")
@CrossOrigin(maxAge = 3600)
@Slf4j
public class TrainController {

    @Autowired
    private ChatbotMLService chatbotMLService;

    @PostMapping("/v1")
    public ResponseEntity<String> train1() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

    @PostMapping("/v2")
    public ResponseEntity<String> train2(@RequestParam(name = "c", required = false, defaultValue = "10") Float c, @RequestParam(name = "random_state", required = false, defaultValue = "1") Integer randomState, @RequestParam(name = "shuffle", required = false, defaultValue = "False") Boolean shuffle, @RequestParam(name = "test_size", required = false, defaultValue = "0.2") Float testSize) {
        chatbotMLService.trainV2(c, randomState, shuffle, testSize);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/find-parameter/v1")
    public ResponseEntity<String> find1() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

    @PostMapping("/find-parameter/v2")
    public ResponseEntity<String> find2(@RequestParam(name = "random_state", required = false, defaultValue = "1") Integer randomState) {
        chatbotMLService.findParameterV2(randomState);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PostMapping("/train-shuffle/v1")
    public ResponseEntity<String> shuffle1() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

    @PostMapping("/train-shuffle/v2")
    public ResponseEntity<String> shuffle2(@RequestParam(name = "c", required = false, defaultValue = "10") Float c, @RequestParam(name = "times", required = false, defaultValue = "10") Integer times) {
        chatbotMLService.trainMultiV2(c, times);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
