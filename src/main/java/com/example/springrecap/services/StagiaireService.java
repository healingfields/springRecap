package com.example.springrecap.services;

import com.example.springrecap.dtos.StagiaireDto;
import com.example.springrecap.models.Stagiaire;
import com.example.springrecap.requests.StagiaireRequest;

import java.util.List;

public interface StagiaireService {

    List<StagiaireDto> getStagiaires();

    StagiaireDto getStagiaireByStagiaireId(String id);

    StagiaireDto createStagiaire(StagiaireDto stagiaireDto);

    StagiaireDto updateStagiaire(String id, StagiaireDto stagiaireDto);

    void deleteStagiaire(String id);
}
