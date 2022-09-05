package com.example.springrecap.controllers;

import com.example.springrecap.dtos.StagiaireDto;
import com.example.springrecap.models.Stagiaire;
import com.example.springrecap.requests.StagiaireRequest;
import com.example.springrecap.responses.StagiaireResponse;
import com.example.springrecap.services.StagiaireService;
import com.example.springrecap.shared.MyModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping("/stagiaires")
public class StagiaireController {


    @Autowired
    StagiaireService stagiaireService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<StagiaireResponse>> getAllStagiaires(){

        List<StagiaireDto> dtos = stagiaireService.getStagiaires();
        List<StagiaireResponse> stagiaireResponses = MyModelMapper.myMapAll(dtos, StagiaireResponse.class);

        return new ResponseEntity<List<StagiaireResponse>>(stagiaireResponses, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<StagiaireResponse> getStagiaire(@PathVariable String id){

        StagiaireDto stagiaireDto = stagiaireService.getStagiaireByStagiaireId(id);
        StagiaireResponse stagiaireResponse = MyModelMapper.myMap(stagiaireDto, StagiaireResponse.class);

        return new ResponseEntity<StagiaireResponse>(stagiaireResponse, HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<StagiaireResponse> createStagiaire(@RequestBody StagiaireRequest stagiaireRequest){

        checkStagiaireRequest(stagiaireRequest);

        StagiaireDto stagiaireDto = MyModelMapper.myMap(stagiaireRequest, StagiaireDto.class);
        StagiaireDto created  = stagiaireService.createStagiaire(stagiaireDto);
        StagiaireResponse stagiaireResponse = MyModelMapper.myMap(created, StagiaireResponse.class);

        return new ResponseEntity<StagiaireResponse>(stagiaireResponse, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}",
                consumes = {MediaType.APPLICATION_JSON_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<StagiaireResponse> updateStagiaire(@PathVariable String id,
                                                            @RequestBody StagiaireRequest stagiaireRequest)

    {
        checkStagiaireRequest(stagiaireRequest);
        StagiaireDto stagiaireDtoRequest = MyModelMapper.myMap(stagiaireRequest, StagiaireDto.class);
        StagiaireDto stagiaireDtoUpdated = stagiaireService.updateStagiaire(id, stagiaireDtoRequest);
        StagiaireResponse stagiaireResponseUpdated = MyModelMapper.myMap(stagiaireDtoUpdated, StagiaireResponse.class);

        return new ResponseEntity<StagiaireResponse>(stagiaireResponseUpdated, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<StagiaireResponse> deleteStagiaire(@PathVariable String id){

        stagiaireService.deleteStagiaire(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    public void checkStagiaireRequest(StagiaireRequest stagiaireRequest){

        if(stagiaireRequest.getNom() == null || stagiaireRequest.getNom().isEmpty())
            throw new RuntimeException("name not provided");

        if(stagiaireRequest.getPrenom() == null || stagiaireRequest.getPrenom().isEmpty())
            throw new RuntimeException("prenom not provided");

        if(stagiaireRequest.getGroupe().getGroupeId() == null)
            throw new RuntimeException("groupe provided si not valid");

    }

}
