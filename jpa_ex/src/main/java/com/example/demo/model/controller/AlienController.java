package com.example.demo.model.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;
import com.example.demo.model.RestResponse;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mView = new ModelAndView("home.jsp");
		
		return mView;
	}
	
	@DeleteMapping("/alien/{aid}")
	public RestResponse deleteAlien(@PathVariable int aid) {
		
		if (repo.existsById(aid)) {
			repo.deleteById(aid);
			
			return new RestResponse("Succesfully Deleted");
		} else {
			return new RestResponse("Could not be Deleted");
		}
		
	}
	
	@PostMapping("/addAlien")
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
//		return "home.jsp";
		return alien;
	}
	
	@PutMapping("/addAlien")
	public Alien updateAlien(@RequestBody Alien alien) {
		repo.save(alien);
//		return "home.jsp";
		return alien;
	}
	
	@GetMapping("/getAlien")
	public ModelAndView getAlien( Integer aid) {
		ModelAndView mView = new ModelAndView("show.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		mView.addObject(alien);
		
//		System.out.println(repo.findByLang("Java"));
//		System.out.println(repo.findByAidGreaterThan(102));
//		System.out.println(repo.findByLangSorted("Java"));
		
		return mView;
	}
	/*
	 *  REST APIs implementation
	 */
	
	@GetMapping("/aliens")
//	@ResponseBody --> Not needed in Rest Controller
	public List<Alien> aliens() {
//		return repo.findAll().toString();
		return repo.findAll(); // prints in json format
	}
	
	@RequestMapping(
			path="/alien/{aid}",
			produces = {"application/xml"}, // restricts to only XMLresponse
			method = RequestMethod.GET 
		) 
	public Optional<Alien> GETAlien(@PathVariable("aid") int aid){
//		return repo.findById(aid).toString();
		return repo.findById(aid); // prints in json format
	}
}
