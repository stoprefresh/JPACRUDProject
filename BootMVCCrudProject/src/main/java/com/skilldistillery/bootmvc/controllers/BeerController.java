package com.skilldistillery.bootmvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.bootmvc.data.BeerDAO;
import com.skilldistillery.jpacrudproject.entities.Beer;

@Controller
public class BeerController {
	
	@Autowired
	private BeerDAO dao;
	
	@RequestMapping(path="/")
	public String index(Model model) {
		List<Beer> beers = dao.findAll();
		model.addAttribute("beers", beers);
		return "index";
	}
	
	@RequestMapping(path="getFilm.do")
	public String showFilm(@RequestParam("fid") Integer filmId, Model model) {
		Beer beer = dao.findByName();
		model.addAttribute("beer", beer);
		return "beer/show";
	}

}
