package com.skilldistillery.bootmvccrud.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpacrudproject.entities.Beer;
import com.skilldistillery.jpacrudproject.entities.Brewery;

@Service
@Transactional
public class BeerDAOJpaImpl implements BeerDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Beer> findAllBeer() {
		String jpql = "SELECT b FROM Beer b";
		List<Beer> beers = em.createQuery(jpql, Beer.class).getResultList();
		return beers;
	}

	@Override
	public Beer findBeerById(int id) {
		return em.find(Beer.class, id);
	}

	@Override
	public void deleteBeer(int id) {
		em.remove(em.find(Beer.class, id));
	}
	
	@Override
	public Beer addNewBeer(Beer adds) {

		em.persist(adds);
		
		return adds;
	}
	
	@Override
	public Beer updateBeer(Integer id, Beer b) {
		Beer beer = em.find(Beer.class, id);
		
		beer.setName(b.getName());
		beer.setType(b.getName());
		beer.setAbv(b.getAbv());
		beer.setBrewery(b.getBrewery());
		beer.setDescription(b.getDescription());
		beer.setNotes(b.getNotes());
		
		return beer;
	}
	
	@Override
	public List<Brewery> findAllBrewery() {
		String jpql = "SELECT br FROM Brewery br";
		List<Brewery> breweries = em.createQuery(jpql, Brewery.class).getResultList();
		for (Brewery brewery : breweries) {
			System.out.println(brewery);
		}
		return breweries;
	}

	@Override
	public Brewery findBreweryById(int id) {
		return em.find(Brewery.class, id);
	}
	
	@Override
	public void deleteBrewery(int id) {
		em.remove(em.find(Brewery.class, id));
	}
	
	@Override
	public Brewery addNewBrewery(Brewery newBrewery) {

		em.persist(newBrewery);
		
		return newBrewery;
	}
	
	@Override
	public Brewery updateBrewery(Integer id, Brewery brewery) {
		Brewery uBrewery = em.find(Brewery.class, id);
		
		uBrewery.setName(brewery.getName());
		
		
		return uBrewery;
	}
}