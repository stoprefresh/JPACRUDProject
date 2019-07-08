package com.skilldistillery.bootmvccrud.data;

import java.util.List;

import com.skilldistillery.jpacrudproject.entities.Beer;

public interface BeerDAO {
	
	List<Beer> findAll();
	
	Beer findById(int id);

	void deleteAddress(int id);

	Beer addNewBeer(Beer adds);

	void update();

	void update(int id);
	
}
