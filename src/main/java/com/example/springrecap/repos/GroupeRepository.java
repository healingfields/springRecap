package com.example.springrecap.repos;

import com.example.springrecap.models.Groupe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeRepository extends CrudRepository<Groupe, Long>{

    Groupe findByGroupeById(String groupeId);

}
