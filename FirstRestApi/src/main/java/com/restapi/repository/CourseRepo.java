package com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.entities.Course;

public interface CourseRepo extends JpaRepository<Course, Long>{

}
