package app.chatbot.service.management.controller;

import app.chatbot.service.management.dto.GroupDTO;
import app.chatbot.service.management.entity.GroupEntity;
import app.chatbot.service.management.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    GroupService groupService;

    @Operation(summary = "Create a new group")
    @PostMapping
    public void create(@RequestBody GroupDTO dto) {
        this.groupService.save(dto);
    }

    @Operation(summary = "Update a group exist")
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") String id, @RequestBody GroupDTO dto) {
        try {
            groupService.update(id,dto);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (RuntimeException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Delete a new group")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.groupService.remove(id);
    }

    @Operation(summary = "Get all group")
    @GetMapping
    public ResponseEntity<List<GroupDTO>> findAll() {
        return new ResponseEntity<>(this.groupService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get group by ID")
    @GetMapping("/{id}")
    public ResponseEntity<GroupEntity> findByID(@PathVariable("id") String id) {
        var entity = this.groupService.findById(id);
        if (entity.isPresent()){
            return new ResponseEntity<>(entity.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }
}
