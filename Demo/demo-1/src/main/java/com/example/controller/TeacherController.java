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

import com.example.model.Teacher;
import com.example.service.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	private TeacherService teacherservice;

	@GetMapping("/teacher")
	public String viewStudentPage() {
		return "teacher";
	}

	@GetMapping("/tregister")
	public String viewRegisterTeacher(Model model) {
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		return "newTeacher";
	}

	@PostMapping("/registerTeacher")
	public String addTeacher(@ModelAttribute("teacher") Teacher teacher) {
		teacherservice.register(teacher);
		return "redirect:/teacher";
	}

	@GetMapping("/allteachers")
	public String viewAllTeachers(Model model) {
		List<Teacher> listteacher = teacherservice.listall();
		model.addAttribute("listteacher", listteacher);
		return "allteachers";
	}

	@RequestMapping("/tedit/{id}")
	public ModelAndView viewEditTeacherPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editteacher");
		Teacher teacher = teacherservice.get(id);
		mav.addObject("teacher", teacher);
		return mav;
	}

	@PostMapping("/editteacher")
	public String editTeacher(@ModelAttribute("teacher") Teacher teacher) {
		teacherservice.register(teacher);
		return "redirect:/teacher";
	}

	@RequestMapping("/tdelete/{id}")
	public String deleteTeacher(@PathVariable(name = "id") int id) {
		teacherservice.delete(id);
		return "redirect:/allteachers";
	}

}
