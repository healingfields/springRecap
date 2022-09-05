package com.example.springrecap.repos;

import com.example.springrecap.models.Stagiaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StagiaireRepository extends CrudRepository<Stagiaire, Long> {

    Stagiaire findStagiaireById(String stagiaireId);
}
