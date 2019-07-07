package com.skilldistillery.bootmvc.data;

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
		return beers;
	}

	@Override
	public Beer findById(int id) {
		return em.find(Beer.class, id);
	}

}
