package app.chatbot.service.management.service;

import app.chatbot.service.management.dto.GroupDTO;
import app.chatbot.service.management.entity.GroupEntity;
import app.chatbot.service.management.exception.ApiException;
import app.chatbot.service.management.repository.GroupRepository;
import app.chatbot.service.management.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupService {

    final private GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    public List<GroupDTO> findAll() {
        return this.groupRepository.findAll().stream().map(e -> ObjectMapper.MAP.toDTO(e)).collect(Collectors.toList());
    }

    public Optional<GroupEntity> findById(String id) {
        return this.groupRepository.findById(id);
    }


    public void update(String id, GroupDTO groupDTO) {
        var entity = groupRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "category_id_not_exist", "cant find category");
        }
        groupDTO.setGroupId(id);
        this.groupRepository.save(ObjectMapper.MAP.toEntity(groupDTO));
    }

    public void save(GroupDTO t) {
        var entity = ObjectMapper.MAP.toEntity(t);
        this.groupRepository.save(entity);
    }


    public void remove(String id) {
        this.groupRepository.deleteById(id);
    }
}
