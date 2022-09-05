package com.example.springrecap.services;

import com.example.springrecap.dtos.GroupeDto;
import com.example.springrecap.models.Groupe;
import com.example.springrecap.repos.GroupeRepository;
import com.example.springrecap.shared.MyModelMapper;
import com.example.springrecap.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupeServiceImpl implements GroupeService
{

    @Autowired
    private GroupeRepository groupeRepository;

    @Autowired
    private Utils utils;


    @Override
    public List<GroupeDto> getGroupes() {
        List<Groupe> groupes = (List<Groupe>) groupeRepository.findAll();

        List<GroupeDto> groupeDtos = MyModelMapper.myMapAll(groupes, GroupeDto.class);

        return groupeDtos;

    }

    @Override
    public GroupeDto getGroupeByGroupeId(String groupeId) {
        Groupe groupe = groupeRepository.findGroupeByGroupeId(groupeId);

        if(groupe == null){
            throw new RuntimeException("Groupe not found: " + groupeId );
        }

        GroupeDto groupeDto = MyModelMapper.myMap(groupe, GroupeDto.class);

        return groupeDto;
    }

    @Override
    public GroupeDto createGroupe(GroupeDto groupeDto) {

        groupeDto.setGroupeId(utils.generateStringId(25));
        Groupe groupe = MyModelMapper.myMap(groupeDto, Groupe.class);
        Groupe created = groupeRepository.save(groupe);
        GroupeDto createdDto = MyModelMapper.myMap(created, GroupeDto.class);

        return createdDto;
    }

    @Override
    public GroupeDto updateGroupe(String groupeId, GroupeDto groupeDto) {
        Groupe groupe = groupeRepository.findGroupeByGroupeId(groupeId);

        if(groupe == null)
            throw new RuntimeException("Group not found: " + groupeId);

        groupe.setNom(groupeDto.getNom());

        Groupe updated = groupeRepository.save(groupe);

        return MyModelMapper.myMap(updated, GroupeDto.class);
    }

    @Override
    public void deleteGroupe(String groupeId) {
        Groupe groupe = groupeRepository.findGroupeByGroupeId(groupeId);

        if(groupe == null)
            throw new RuntimeException("groupe not found: "+ groupeId);

        groupeRepository.delete(groupe);
    }
}
