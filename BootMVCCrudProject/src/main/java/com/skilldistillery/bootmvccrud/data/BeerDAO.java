package com.skilldistillery.bootmvccrud.data;

import java.util.List;

import com.skilldistillery.jpacrudproject.entities.Beer;
import com.skilldistillery.jpacrudproject.entities.Brewery;

public interface BeerDAO {
	
	List<Beer> findAllBeer();
	
	Beer findBeerById(int id);

	void deleteBeer(int id);

	Beer addNewBeer(Beer adds);

	Beer updateBeer(Integer id, Beer beer);
	
	void deleteBrewery(int id);

	Brewery addNewBrewery(Brewery adds);

	Brewery updateBrewery(Integer id, Brewery beer);

	List<Brewery> findAllBrewery();

	Brewery findBreweryById(int id);
	
	
}

