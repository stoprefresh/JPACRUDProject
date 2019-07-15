package com.skilldistillery.jpacrudproject.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BreweryTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPACrudProject");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		
		em = emf.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		
		em.close();
	}

	@Test
	@DisplayName("DB to Entity Mapping")
	void test_for_entity() {
		Brewery br = em.find(Brewery.class, 1);
		assertEquals("Russian River Brewing Co.", br.getName());
	}
	
	@Test
	@DisplayName("Beer array mapping")
	void test_for_size() {
		Brewery br = em.find(Brewery.class, 1);
		assertNotNull(br.getBeers());
		assertEquals("Pliny The Elder", br.getBeers().get(1).getName());
	}
}
