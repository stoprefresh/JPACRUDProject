package com.skilldistillery.bootmvccrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.bootmvccrud.data.BeerDAO;
import com.skilldistillery.jpacrudproject.entities.Beer;
import com.skilldistillery.jpacrudproject.entities.Brewery;

@Controller
public class BeerController {

	@Autowired
	private BeerDAO dao;
	
	@RequestMapping(path="/")
	public String splashPage(Model model){
		return "splash";
	}
	
	@RequestMapping(path = "getBeerIndex.do")
	public String beerHome(Model model) {
		
		List<Beer> beers = dao.findAllBeer();
		model.addAttribute("beers", beers);
		
		return "beer/beerIndex";
	}
	
	@RequestMapping(path = "getBreweryIndex.do")
	public String breweryHome(Model model) {
		
		List<Brewery> breweries = dao.findAllBrewery();
		model.addAttribute("breweries", breweries);
		
		return "beer/breweryIndex";
	}
	
	@RequestMapping(path = "getBeer.do")
	public String showBeer(@RequestParam("fid") Integer beerId, Model model) {
		
		Beer beer = dao.findBeerById(beerId);
		model.addAttribute("beer", beer);
		
		return "beer/show";
	}
	
	@RequestMapping(path = "getBrewery.do")
	public String showBrewery(@RequestParam("fid") Integer breweryId, Model model) {
		
		Brewery brewery = dao.findBreweryById(breweryId);
		model.addAttribute("brewery", brewery);
		
		return "beer/showBrewery";
	}

	@RequestMapping(path = "getAdded.do")
	public String showNewBeer(@RequestParam("name") String name, @RequestParam("type") String type,
			@RequestParam("brewery") String brewery, @RequestParam("description") String description,
			@RequestParam("notes") String notes, @RequestParam("abv") Double abv, Model model) {

		model.addAttribute("beer", dao.addNewBeer(new Beer(abv, name, type, brewery, description, notes)));

		return "beer/show";
	}

	@RequestMapping(path = "getBeerAdd.do")
	public String addBeer(Model model) {
		
		return "beer/add";
	}

	@RequestMapping(path = "getBeerDelete.do")
	public String deleteBeer(@RequestParam("fid") Integer beerId, Model model) {
		
		dao.deleteBeer(beerId);
		List<Beer> beers = dao.findAllBeer();
		model.addAttribute("beers", beers);
		
		return "index";
	}

	@RequestMapping(path = "getBeerUpdate.do")
	public String updateBeer(@RequestParam("fid") Integer beerId, Model model) {
		
		model.addAttribute("beer", dao.findBeerById(beerId));

		return "beer/update"; 
		
	}

	@RequestMapping(path = "getUpdated.do")
	public String displayUpdated(@RequestParam("fid") Integer beerId, @RequestParam("name") String name, @RequestParam("type") String type,
			@RequestParam("brewery") String brewery, @RequestParam("description") String description,
			@RequestParam("notes") String notes, @RequestParam("abv") Double abv, Model model) {
		
		model.addAttribute("beer", dao.updateBeer(beerId, new Beer(abv, name, type, brewery, description, notes)));

		return "beer/show";
	}
}