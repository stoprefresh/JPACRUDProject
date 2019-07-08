package com.skilldistillery.bootmvccrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.bootmvccrud.data.BeerDAO;
import com.skilldistillery.jpacrudproject.entities.Beer;

@Controller
public class BeerController {

	@Autowired
	private BeerDAO dao;

	@RequestMapping(path = "/")
	public String index(Model model) {
		List<Beer> beers = dao.findAll();
		model.addAttribute("beers", beers);
		return "index";
	}

	@RequestMapping(path = "getBeer.do")
	public String showBeer(@RequestParam("fid") Integer beerId, Model model) {
		Beer beer = dao.findById(beerId);
		model.addAttribute("beer", beer);
		return "beer/show";
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

	@RequestMapping(path = "getHome.do")
	public String home(Model model) {
		List<Beer> beers = dao.findAll();
		model.addAttribute("beers", beers);
		return "index";
	}
	
	@RequestMapping(path = "getBeerDelete.do")
	public String deleteBeer(@RequestParam("fid") Integer beerId, Model model) {
		dao.deleteBeer(beerId);
		List<Beer> beers = dao.findAll();
		model.addAttribute("beers", beers);
		return "index";
	}

	@RequestMapping(path = "getBeerUpdate.do")
	public String updateBeer(@RequestParam("fid") Integer beerId, Model model) {
		model.addAttribute("beer", dao.findById(beerId));
		return "beer/update";
	}

	@RequestMapping(path = "getUpdated.do")
	public String displayUpdated(@RequestParam("fid") Integer beerId, @RequestParam("name") String name, @RequestParam("type") String type,
			@RequestParam("brewery") String brewery, @RequestParam("description") String description,
			@RequestParam("notes") String notes, @RequestParam("abv") Double abv, Model model) {
		
		model.addAttribute("beer", dao.update(beerId, new Beer(abv, name, type, brewery, description, notes)));

		return "beer/show";
	}
}