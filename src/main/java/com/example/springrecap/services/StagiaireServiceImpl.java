package com.example.springrecap.services;

import com.example.springrecap.dtos.GroupeDto;
import com.example.springrecap.dtos.StagiaireDto;
import com.example.springrecap.models.Groupe;
import com.example.springrecap.models.Stagiaire;
import com.example.springrecap.repos.GroupeRepository;
import com.example.springrecap.repos.StagiaireRepository;
import com.example.springrecap.shared.MyModelMapper;
import com.example.springrecap.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StagiaireServiceImpl implements StagiaireService{

    @Autowired
    StagiaireRepository stagiaireRepository;

    @Autowired
    GroupeRepository groupeRepository;

    @Autowired
    Utils utils;


    @Override
    public List<StagiaireDto> getStagiaires() {

        List<Stagiaire> stagiaires = (List<Stagiaire>) stagiaireRepository.findAll();
        List<StagiaireDto> stagiaireDtos = MyModelMapper.myMapAll(stagiaires, StagiaireDto.class);

        return stagiaireDtos;


    }

    @Override
    public StagiaireDto getStagiaireByStagiaireId(String id) {

        Stagiaire stagiaire = stagiaireRepository.findStagiaireById(id);

        if(stagiaire==null)
            throw new RuntimeException("stagiaire not found :" + id);
        StagiaireDto stagiaireDto = MyModelMapper.myMap(stagiaire, StagiaireDto.class);

        return stagiaireDto;


    }

    @Override
    public StagiaireDto createStagiaire(StagiaireDto stagiaireDto) {

        Groupe groupe = groupeRepository.findGroupeByGroupeId(stagiaireDto.getGroupe().getGroupeId());
        if(groupe == null)
            throw new RuntimeException("groupe provided not found : " + stagiaireDto.getGroupe().getGroupeId());

        GroupeDto groupeDto = MyModelMapper.myMap(groupe, GroupeDto.class);
        stagiaireDto.setId(utils.generateStringId(25));
        stagiaireDto.setGroupe(groupeDto);
        Stagiaire stagiaire = MyModelMapper.myMap(stagiaireDto, Stagiaire.class);
        Stagiaire created = stagiaireRepository.save(stagiaire);
        StagiaireDto createdDto = MyModelMapper.myMap(created, StagiaireDto.class);

        return createdDto;
    }

    @Override
    public StagiaireDto updateStagiaire(String id, StagiaireDto stagiaireDto) {

        Groupe groupe = groupeRepository.findGroupeByGroupeId(stagiaireDto.getGroupe().getGroupeId());
        if(groupe == null)
            throw new RuntimeException("groupe not found: " + stagiaireDto.getGroupe().getGroupeId());

        Stagiaire stagiaire = stagiaireRepository.findStagiaireById(id);
        if(stagiaire == null)
            throw new RuntimeException("stagiaire not found: " + id);

        stagiaire.setGroupe(groupe);
        stagiaire.setNom(stagiaireDto.getNom());
        stagiaire.setPrenom(stagiaireDto.getPrenom());

        Stagiaire updated = stagiaireRepository.save(stagiaire);
        StagiaireDto dtoUpdated = MyModelMapper.myMap(updated, StagiaireDto.class);

        return dtoUpdated;
    }


    @Override
    public void deleteStagiaire(String id) {
        Stagiaire stagiaire = stagiaireRepository.findStagiaireById(id);
        if(stagiaire == null)
            throw new RuntimeException("stagiaire provided not found: " + id);
       stagiaireRepository.delete(stagiaire);
    }
}
