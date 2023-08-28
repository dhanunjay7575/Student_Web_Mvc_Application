package com.jay.service;

import java.util.Arrays;
import java.util.List;

import javax.management.MXBean;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.binding.Student;
import com.jay.entity.StudentEntity;
import com.jay.repo.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;

	public boolean saveStudent(Student student) {
		
		StudentEntity entity = new StudentEntity();
		
		BeanUtils.copyProperties(student, entity);
		
		entity.setTimings(Arrays.toString(student.getTimings()));;
		
		System.out.println(entity);
		
		repo.save(entity);
		
		return true;
	}
	
	
	
	public List<String> getCourses() {
		
		return Arrays.asList("Java", "Python", "Devops","AWS");
	}
	
public List<String> getTimings() {
		
		return Arrays.asList("Morning", "AfterNoon", "Evening");
	}
}
