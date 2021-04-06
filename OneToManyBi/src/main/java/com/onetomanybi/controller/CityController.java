package com.onetomanybi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onetomanybi.entities.City;
import com.onetomanybi.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityService cityService;
	
	@GetMapping
	private List<City> getAll(){
		return cityService.getAll();
	}
	
	@GetMapping("/{id}")
	private City getById(@PathVariable int id) {
		return cityService.getById(id);
	}
	
	@PostMapping
	private City add(@RequestBody City city) {
		return cityService.addOrUpdate(city);
	}
	
	@PutMapping("/{id}")
	private City update(@PathVariable int id,@RequestBody City city) {
		city.setCityId(id);
		return cityService.addOrUpdate(city);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		cityService.deleteById(id);
	}
}
