package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.models.charactersheet.Ability;
import com.revature.models.charactersheet.Money;

@Repository("moneyRepository")
public interface MoneyRepository extends JpaRepository<Money, Integer>{

	public Money findByName(String name);
	
}