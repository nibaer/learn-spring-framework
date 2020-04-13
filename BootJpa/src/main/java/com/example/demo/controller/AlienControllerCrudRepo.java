package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienCrudRepo;
import com.example.demo.dao.AlienJpaRepo;
import com.example.demo.model.Alien;

/**
 * @author LisMacBook
 *
 */
@Controller
public class AlienControllerCrudRepo {
	
	@Autowired
	AlienCrudRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv= new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		
		System.out.println(repo.findByAidGreaterThan(100));
		System.out.println(repo.findByTechSorted("java"));
		
		mv.addObject(alien);
		return mv;
	}
	
	@RequestMapping("/getAlienByTech")
	public ModelAndView getAlienByTech(@RequestParam String tech) {
		ModelAndView mv= new ModelAndView("showAlien.jsp");
		List<Alien> aliens = repo.findByTech(tech);
		System.out.println(aliens);
		for(Alien alien:aliens)
			mv.addObject(alien);
		return mv;
	}
	
	// shows only one record, how to show all the records?
	@RequestMapping("/getAllAliens")
	public ModelAndView getAllAliens() {
		ModelAndView mv= new ModelAndView("showAlien.jsp");
		Iterable<Alien> aliens = repo.findAll();
		for(Alien alien:aliens) {
			mv.addObject(alien);
		}		
		return mv;
	}
	
	//restful style, you can test with postman
	@RequestMapping("/aliens")
	@ResponseBody
	public String getAliens() {
		return repo.findAll().toString();
	}
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public String getOneAlien(@PathVariable("aid") int aid) {
		return repo.findById(aid).toString();
	}
	
}
