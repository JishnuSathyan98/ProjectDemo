package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.Teacher;

@Controller
public class AdminController {

	@GetMapping("/admin")
	public String viewAdminPage() {
		return "admin";
	}
}
