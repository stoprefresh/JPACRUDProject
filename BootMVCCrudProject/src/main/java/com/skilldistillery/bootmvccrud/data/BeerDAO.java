package com.skilldistillery.bootmvccrud.data;

import java.util.List;

import com.skilldistillery.jpacrudproject.entities.Beer;

public interface BeerDAO {
	
	List<Beer> findAll();
	
	Beer findById(int id);
}
