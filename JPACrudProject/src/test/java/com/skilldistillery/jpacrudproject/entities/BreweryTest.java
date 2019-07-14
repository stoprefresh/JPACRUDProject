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

class BreweryTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Brewery br;

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
		br = em.find(Brewery.class, 1);
		em = emf.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		br = null;
		em.close();
	}

	@Test
	@DisplayName("DB to Entity Mapping")
	void test_for_entity() {
		assertEquals("Russian River Brewing Co.", br.getName());
	}
}
