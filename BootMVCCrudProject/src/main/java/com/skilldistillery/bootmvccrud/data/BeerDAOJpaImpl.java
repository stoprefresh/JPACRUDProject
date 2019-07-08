package com.skilldistillery.bootmvccrud.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpacrudproject.entities.Beer;

@Service
@Transactional
public class BeerDAOJpaImpl implements BeerDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Beer> findAll() {
		String jpql ="SELECT b FROM Beer b";
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
	
	public Beer getFilmByName(String someName) {
		String query = "SELECT b from Beer b WHERE b.name LIKE :aName";
		
		return em.createQuery(query, Beer.class).setParameter("aName", "%" + someName + "%").getResultList().get(0);
	}
	
public void deleteAddress(int id) {
		
		em.getTransaction().begin();
		em.remove(em.find(Beer.class, id));
		em.getTransaction().commit();
		em.close();
	}
	
	public Beer addNewBeer(Beer adds) {
		
		em.getTransaction().begin();
		em.persist(adds);
		em.flush();
		em.getTransaction().commit();
		em.clear();
		em.close();
		return adds;
	}
	
	public void update() {
		
		String query = "SELECT e FROM Customer e WHERE e.email is null or e.email = ''";
		
		em.getTransaction().begin();
		
		for (Beer b : em.createQuery(query, Beer.class).getResultList()) {
			
			
		}
		em.getTransaction().commit();
		
		em.close();
	}
}