package com.example.springrecap.controllers;

import com.example.springrecap.dtos.GroupeDto;
import com.example.springrecap.requests.GroupeRequest;
import com.example.springrecap.responses.GroupeResponse;
import com.example.springrecap.services.GroupeService;
import com.example.springrecap.services.GroupeServiceImpl;
import com.example.springrecap.shared.MyModelMapper;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;

@RestController
@RequestMapping("/groupes")
public class GroupeController {

    @Autowired
    GroupeService groupeService;


    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<GroupeResponse>> getAllGroupes(){

        List<GroupeDto> dtos = groupeService.getGroupes();
        List<GroupeResponse> responses = MyModelMapper.myMapAll(dtos, GroupeResponse.class);

        return new ResponseEntity<List<GroupeResponse>>(responses, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<GroupeResponse> getGroupe(@PathVariable String id){

        GroupeDto dto = groupeService.getGroupeByGroupeId(id);
        GroupeResponse response = MyModelMapper.myMap(dto, GroupeResponse.class);

        return new ResponseEntity<GroupeResponse>(response, HttpStatus.OK);
    }

    @PostMapping(consumes =  {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<GroupeResponse>  createGroupe(@RequestBody GroupeRequest groupeRequest){

        checkGroupeRequest(groupeRequest);
        GroupeDto requestDto = MyModelMapper.myMap(groupeRequest, GroupeDto.class);
        GroupeDto dto = groupeService.createGroupe(requestDto);
        GroupeResponse response = MyModelMapper.myMap(dto, GroupeResponse.class);

        return new ResponseEntity<GroupeResponse>(response, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}",
            consumes =  {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<GroupeResponse> updateGroupe(@PathVariable String id,
                                                       @RequestBody GroupeRequest groupeRequest){
        checkGroupeRequest(groupeRequest);
        GroupeDto requestDto = MyModelMapper.myMap(groupeRequest, GroupeDto.class);
        GroupeDto dtoUpdated = groupeService.updateGroupe(id, requestDto);
        GroupeResponse response = MyModelMapper.myMap(dtoUpdated, GroupeResponse.class);

        return new ResponseEntity<GroupeResponse>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<GroupeResponse> deleteGroupe(@PathVariable String id){

        groupeService.deleteGroupe(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public void checkGroupeRequest(GroupeRequest groupeRequest){
        if(groupeRequest.getNom() == null || groupeRequest.getNom().isEmpty())
            throw new RuntimeException("name missing");
    }
}
