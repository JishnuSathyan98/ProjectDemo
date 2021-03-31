package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Students;
import com.example.service.StudentService;
@Controller
public class StudentController {
	@Autowired 
	private StudentService studentservice;
	
	@GetMapping("/")
	public String viewHomePage() {
		return "index";
	}
	@GetMapping("/student")
	public String viewStudentPage() {
		return "student";
	}
	@GetMapping("/register")
	public String viewRegisterStudent(Model model) {
		Students student=new Students();
		model.addAttribute("student",student);
		return "newStudent";
	}
	@PostMapping("/registerStudent")
	public String addStudent(@ModelAttribute("student") Students student) {
		studentservice.register(student);
		return "redirect:/student";		
	}

	@GetMapping("/allstudents")
	public String viewAllStudents(Model model) {
		List<Students> list=studentservice.listAll();
		model.addAttribute("liststudent", list);
		return "allStudents";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView viewEditStudentPage(@PathVariable(name = "id") int id) {
		ModelAndView mav=new ModelAndView("editstudent");
		Students student=studentservice.get(id);
		mav.addObject("student", student);
		return mav;
	}
	@PostMapping("/editstudent")
	public String editStudent(@ModelAttribute("student") Students student) {
		studentservice.register(student);
		return "redirect:/student";		
	}
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(name = "id") int id) {
		studentservice.delete(id);
		return "redirect:/allstudents";
	}
}
