package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.charactersheet.AbilitySheet;
import com.revature.models.charactersheet.MoneySheet;

@Repository("moneySheetRepository")
public interface MoneySheetRepository extends JpaRepository<MoneySheet, Integer>{
	
}
