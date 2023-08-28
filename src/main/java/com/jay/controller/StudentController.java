package com.jay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.jay.binding.Student;
import com.jay.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String loadIndexPage(Model model) {
		
		//Student sobj = new Student(); passing the object in the down
		
		formInitBinding(model); //extracted method
		
		return "index";
	}
	
	private void formInitBinding(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("preTimings", service.getTimings());
		model.addAttribute("courses", service.getCourses());
	}
	
	@PostMapping("/save")
	public String handleSubmitBtn(Student s, Model model) {
		
		boolean isSaved = service.saveStudent(s);
		if(isSaved) {
			model.addAttribute("msg", "Data Saved...");
		}
		
		formInitBinding(model); //extracted method
		
		return "index";
	}
}
