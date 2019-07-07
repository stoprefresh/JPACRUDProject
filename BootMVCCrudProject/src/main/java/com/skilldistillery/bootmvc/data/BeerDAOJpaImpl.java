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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Beer findByName() {
		// TODO Auto-generated method stub
		return null;
	}

}
