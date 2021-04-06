package com.restapi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.entities.Course;
import com.restapi.repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepo courserepo;
	//List<Course> list;
	
	 public CourseServiceImpl() {
	  
		 //list =new ArrayList<>();
	     //list.add(new Course(145,"Java Core","This is Prashant"));
	     //list.add(new Course(245,"Java Advance","This is Rajput"));
	
	 }
	@Override
	public List<Course> getCourses() {
		
		return courserepo.findAll();
	}
	@Override
	public Course getCourse(long courseId) {
	   
//		Course c=null;
//	    for(Course course : list) {
//	    	if(course.getId()==courseId) {
//	    		c = course;
//	    		break;
//	    	}
//	    }
		return courserepo.getOne(courseId);
	}
	@Override
	public Course addCourse(Course course) {
		
		//list.add(course);
		courserepo.save(course);
		return course;
	}
	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e -> {
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		courserepo.save(course);
		return course;
	}
	@Override
	public void deleteCourse(long parseLong) {
		//list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Course entity=courserepo.getOne(parseLong);
	    courserepo.delete(entity);
	}
	

}
 