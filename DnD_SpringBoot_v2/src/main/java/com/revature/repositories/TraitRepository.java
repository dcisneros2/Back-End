package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.charactersheet.Trait;

@Repository("traitRepository")
public interface TraitRepository extends JpaRepository<Trait, Integer>{

	
}