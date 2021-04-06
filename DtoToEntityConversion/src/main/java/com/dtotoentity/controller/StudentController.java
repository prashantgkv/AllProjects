package com.dtotoentity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dtotoentity.dto.StudentDto;
import com.dtotoentity.entities.Student;
import com.dtotoentity.repository.StudentTRepository;
import com.dtotoentity.service.StudentConvertor;

@RestController
public class StudentController {

	@Autowired
	StudentTRepository studentrepo;
	@Autowired
	StudentConvertor stconvertor;
	
	@GetMapping("/findAll")
	public List<StudentDto> findAll() {
		
		List<Student> st=studentrepo.findAll();
		return stconvertor.entityToDto(st);
	}
	
	@GetMapping("/find/{id}")
	public StudentDto findById(@PathVariable Long id) {
		
	 Student st=studentrepo.findById(id).orElse(null);
		return stconvertor.entityToDto(st);
	}
	
	@PostMapping("/save")
	public StudentDto save(@RequestBody StudentDto dto) {
	
		Student student = stconvertor.dtoToEntity(dto);
		 student = studentrepo.save(student);
		 return stconvertor.entityToDto(student);
		
	}


}
