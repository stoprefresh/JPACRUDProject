package com.skilldistillery.jpacrudproject.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BeerTest {
	
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
	@DisplayName("Mapping for the Beer Class")
	void test_mappings() {
		Beer b = em.find(Beer.class, 1);
		assertEquals("Kentucky Brunch Brand Stout", b.getName());
		assertEquals("American Imperial Stout", b.getType());
	}
	
	@Test
	@DisplayName("Checking another value in the Beer Class from DB")
	void test_from_db_to_class() {
		Beer b = em.find(Beer.class, 2);
		assertEquals(11.00, b.getAlcoholByVolume());
	}
	
	@Test
	@DisplayName("Brewery Mapping Test")
	void brewery_mapping_test() {
		Beer b = em.find(Beer.class, 1);
		assertEquals("Toppling Goliath Brewing Co.", b.getBrewery().getName());
	}
}
