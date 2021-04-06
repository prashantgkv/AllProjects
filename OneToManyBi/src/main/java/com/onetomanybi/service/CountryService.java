package com.onetomanybi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetomanybi.entities.Country;
import com.onetomanybi.repository.CountryRepository;

@Service
public class CountryService {


	@Autowired
	private CountryRepository countryRepository;
	
	public Country addOrUpdate(Country country) {
		return countryRepository.save(country);
	}
	
	public boolean deleteById(int id) {
		countryRepository.deleteById(id);
		return true;
	}
	
	public List<Country> getAll(){
		return countryRepository.findAll();
	}
	public Country getById(int id) {
		return countryRepository.findById(id).get();
		
	}
}
