package com.skilldistillery.bootmvccrud.controllers;

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
		
		model.addAttribute("beers", dao.findAllBeer());
		return "beer/beerIndex";
	}
	
	@RequestMapping(path = "getBreweryIndex.do")
	public String breweryHome(Model model) {
		
		model.addAttribute("breweries", dao.findAllBrewery());
		return "beer/breweryIndex";
	}
	
	@RequestMapping(path = "getBeer.do")
	public String showBeer(@RequestParam("fid") Integer beerId, Model model) {
		
		model.addAttribute("beer", dao.findBeerById(beerId));
		return "beer/show";
	}
	
	@RequestMapping(path = "getBrewery.do")
	public String showBrewery(@RequestParam("fid") Integer breweryId, Model model) {
		
		model.addAttribute("brewery", dao.findBreweryById(breweryId));
		return "beer/showBrewery";
	}

	@RequestMapping(path = "getAdded.do")
	public String showNewBeer(@RequestParam("name") String name, @RequestParam("type") String type,
			 @RequestParam("description") String description, @RequestParam("brewery") int breweryId,
			@RequestParam("notes") String notes, @RequestParam("abv") Double abv, Model model) {
		
		model.addAttribute("beer", dao.addNewBeer(new Beer(dao.findBreweryById(breweryId), abv, name, type, description, notes)));

		return "beer/show";
	}
	
	@RequestMapping(path = "getAddedBrewery.do")
	public String showNewBrewery(@RequestParam("name") String name, @RequestParam("website") String website,
			@RequestParam("city") String city, @RequestParam("state") String state,
			@RequestParam("yearEstablished") String yearEstablished, @RequestParam("notes") String notes, 
			@RequestParam("country") String country, @RequestParam("address") String address, Model model) {

		model.addAttribute("brewery", dao.addNewBrewery(new Brewery(name, city, state, yearEstablished, country, address, notes, website)));

		return "beer/showBrewery";
	}

	//TODO
	@RequestMapping(path = "getBeerAdd.do")
	public String addBeer(Model model) {
		model.addAttribute("breweries", dao.findAllBrewery());
		return "beer/add";
	}
	
	@RequestMapping(path = "getBreweryAdd.do")
	public String addBrewery(Model model) {
		return "beer/addBrewery";
	}

	@RequestMapping(path = "getBeerDelete.do")
	public String deleteBeer(@RequestParam("fid") Integer beerId, Model model) {
		
		dao.deleteBeer(beerId);
		model.addAttribute("beers", dao.findAllBeer());
		return "beer/beerIndex";
	}
	
	@RequestMapping(path = "getBreweryDelete.do")
	public String deleteBrewery(@RequestParam("fid") Integer breweryId, Model model) {
		
		dao.deleteBrewery(breweryId);
		
		model.addAttribute("breweries", dao.findAllBrewery());
		
		return "beer/breweryIndex";
	}

	@RequestMapping(path = "getBeerUpdate.do")
	public String updateBeer(@RequestParam("fid") Integer beerId, Model model) {
		model.addAttribute("beer", dao.findBeerById(beerId));
		model.addAttribute("breweries", dao.findAllBrewery());
		return "beer/update"; 
	}
	
	@RequestMapping(path = "getBreweryUpdate.do")
	public String updateBrewery(@RequestParam("fid") Integer breweryId, Model model) {
		model.addAttribute("brewery", dao.findBreweryById(breweryId));
		
		return "beer/updateBrewery"; 
	}

	@RequestMapping(path = "getUpdated.do")
	public String displayUpdated(@RequestParam("fid") Integer beerId, @RequestParam("name") String name, @RequestParam("type") String type,
			 @RequestParam("description") String description, @RequestParam("brewery") int breweryId,
			@RequestParam("notes") String notes, @RequestParam("abv") Double abv, Model model) {
		
		model.addAttribute("beer", dao.updateBeer(beerId, new Beer(dao.findBreweryById(breweryId), abv, name, type, description, notes)));

		return "beer/show";
	}
	
	@RequestMapping(path = "getBreweryUpdated.do")
	public String displayUpdatedBrewery(@RequestParam("fid") Integer breweryId, @RequestParam("name") String name, @RequestParam("website") String website,
			@RequestParam("city") String city, @RequestParam("state") String state, @RequestParam("beer") Beer beer,
			@RequestParam("yearEstablished") String yearEstablished, @RequestParam("notes") String notes, 
			@RequestParam("country") String country, @RequestParam("address") String address, Model model) {
		
		model.addAttribute("brewery", dao.updateBrewery(breweryId, new Brewery(name, city, state, yearEstablished, country, address, notes, website)));

		return "beer/showBrewery";
	}
}