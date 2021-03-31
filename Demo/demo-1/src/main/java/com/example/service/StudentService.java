package com.example.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Students;
import com.example.repository.StudentRepository;
@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
	public List<Students> listAll(){
		return repo.findAll();		
	}
	public void register(Students student) {
		repo.save(student);
		
	}
	public Students get(int id) {
		return repo.findById((long) id).get();
	}
	public void delete(int id) {
		repo.deleteById((long) id);
	}
}
