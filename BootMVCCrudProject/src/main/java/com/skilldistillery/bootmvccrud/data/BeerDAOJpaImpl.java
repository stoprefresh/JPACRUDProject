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
		beer.setBrewery(b.getBrewery());

		return beer;
	}

	@Override
	public List<Brewery> findAllBrewery() {
		String jpql = "SELECT br FROM Brewery br";
		List<Brewery> breweries = em.createQuery(jpql, Brewery.class).getResultList();
		return breweries;
	}

	@Override
	public Brewery findBreweryById(int id) {
		return em.find(Brewery.class, id);
	}

	@Override
	public void deleteBrewery(int id) {
		if (em.find(Brewery.class, id).getBeers() != null) {
			for (Beer beer : em.find(Brewery.class, id).getBeers()) {
				beer.setBrewery(em.find(Brewery.class, 15));
			}
		}
		em.remove(em.find(Brewery.class, id));
	}

	@Override
	public Brewery addNewBrewery(Brewery newBrewery) {

		em.persist(newBrewery);

		return newBrewery;
	}

	@Override
	public Brewery updateBrewery(Integer id, Brewery brewery, Beer ...beer) {
		Brewery uBrewery = em.find(Brewery.class, id);

		uBrewery.setName(brewery.getName());
		uBrewery.setCity(brewery.getCity());
		uBrewery.setState(brewery.getState());
		uBrewery.setYearEstablished(brewery.getYearEstablished());
		uBrewery.setCountry(brewery.getCountry());
		uBrewery.setAddress(brewery.getAddress());
		uBrewery.setNotes(brewery.getNotes());
		uBrewery.setWebsite(brewery.getWebsite());
		if(beer[0] != null) {
			uBrewery.addBeer(beer[0]);
		}

		return uBrewery;
	}
}