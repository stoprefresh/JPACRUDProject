package com.skilldistillery.bootmvc.data;

import java.util.List;

import com.skilldistillery.jpacrudproject.entities.Beer;

public interface BeerDAO {
	
	List<Beer> findAll();
	
	Beer findByName();

}
