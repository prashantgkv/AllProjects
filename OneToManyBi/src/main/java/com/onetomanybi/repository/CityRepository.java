package com.onetomanybi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetomanybi.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
