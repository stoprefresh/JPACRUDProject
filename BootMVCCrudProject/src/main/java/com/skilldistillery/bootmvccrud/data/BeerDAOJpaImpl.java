package com.skilldistillery.bootmvccrud.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpacrudproject.entities.Beer;

@Service
@Transactional
public class BeerDAOJpaImpl implements BeerDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Beer> findAll() {
		String jpql = "SELECT b FROM Beer b";
		List<Beer> beers = em.createQuery(jpql, Beer.class).getResultList();
		for (Beer beer : beers) {
			System.out.println(beer);
		}
		return beers;
	}

	@Override
	public Beer findById(int id) {
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
	public Beer update(Integer id, Beer b) {
		Beer beer = em.find(Beer.class, id);
		
		beer.setName(b.getName());
		beer.setType(b.getName());
		beer.setAbv(b.getAbv());
		beer.setBrewery(b.getBrewery());
		beer.setDescription(b.getDescription());
		beer.setNotes(b.getNotes());
		
		return beer;
	}
}