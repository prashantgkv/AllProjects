package com.dtotoentity.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.dtotoentity.dto.StudentDto;
import com.dtotoentity.entities.Student;

@Service
public class StudentConvertor {
	
	public StudentDto entityToDto(Student student) {
//		StudentDto dto =new StudentDto();
//		dto.setId(student.getId());
//		dto.setName(student.getName());
//		dto.setUsername(student.getUsername());
//		dto.setPassword(student.getPassword());
//		
//		return dto;
		ModelMapper mapper=new ModelMapper();
		StudentDto map=mapper.map(student, StudentDto.class);
		return map;
	}

	
	public Student dtoToEntity(StudentDto dto) {
//		Student st=new Student();
//		st.setId(dto.getId());
//		st.setName(dto.getName());
//		st.setUsername(dto.getUsername());
//		st.setPassword(dto.getPassword());
//		
//		return st;
		
		ModelMapper mapper=new ModelMapper();
		Student map=mapper.map(dto, Student.class);
		return map;
		
	}
	
	
	public List<StudentDto> entityToDto(List<Student> student) {
		
		return student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	
	public List<Student> dtoToEntity(List<StudentDto> dto) {
		
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
