package com.example.springrecap.services;

import com.example.springrecap.dtos.GroupeDto;

import java.util.List;

public interface GroupeService {

    List<GroupeDto> getGroupes();

    GroupeDto getGroupeByGroupeId(String groupeId);

    GroupeDto createGroupe(GroupeDto groupeDto);

    GroupeDto updateGroupe(String groupeId, GroupeDto groupeDto);

    void deleteGroupe(String groupeId);
}
