package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Students;
import com.example.model.Teacher;
import com.example.repository.TeacherRepository;

@Service
@Transactional
public class TeacherService {

	@Autowired
	private TeacherRepository repo;

	public List<Teacher> listall() {
		return repo.findAll();
	}
	public void register(Teacher teacher) {
		repo.save(teacher);
		
	}
	public Teacher get(long id) {
		return repo.findById(id).get();
	}
	public void delete(long id) {
		repo.deleteById(id);
	}
}
