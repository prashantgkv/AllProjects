package com.onetomanybi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetomanybi.entities.City;
import com.onetomanybi.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;
	
	public City addOrUpdate(City city) {
		return cityRepository.save(city);
	}
	
	public boolean deleteById(int id) {
		cityRepository.deleteById(id);
		return true;
	}
	
	public List<City> getAll(){
		return cityRepository.findAll();
	}
	
	public City getById(int id) {
		return cityRepository.findById(id).get();
		
	}
	
}
