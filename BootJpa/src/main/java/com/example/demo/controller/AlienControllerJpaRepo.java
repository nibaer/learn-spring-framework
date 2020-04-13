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

@Controller
public class AlienControllerJpaRepo {
	
	@Autowired
	AlienJpaRepo repo;
	
	
	//test with postman
	//http://localhost:8080/alien
	//Headers: Content-Type: application/json
	//Body: {   "aid": 103,
    //"aname": "kirschen_li",
    // "tech": "KI"}
	@PostMapping("/alien")
	@ResponseBody
	public Alien addAlien2(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		Alien a = repo.getOne(aid);
		repo.delete(a);
		return "deleted";
	}
	
	@PutMapping("/alien")
	@ResponseBody
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@RequestMapping("/aliens2")
	@ResponseBody
	public List<Alien> getAliens2() {
		return repo.findAll();
	}
	
	@RequestMapping("/alien2/{aid}")
	@ResponseBody
	public Optional<Alien> getOneAlien2(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
}
