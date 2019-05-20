package com.studentcertificate.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentcertificate.dao.StudentDAO;
import com.studentcertificate.model.Student;
@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentDAO studentDAO;

	@Override
	@Transactional
	public void addStudent(Student s) {
		this.studentDAO.addStudent(s);
		
	}

	@Override
	@Transactional
	public Student getStudentByid(int enroll) {
		
		return this.studentDAO.getStudentById(enroll);
		
		
	}

	@Override
	@Transactional
	public void updateStudent(Student s) {
		this.studentDAO.updateStudent(s);
		
	}

	@Override
	@Transactional
	public void removeStudent(int enroll) {
		this.studentDAO.removeStudent(enroll);
		
	}

	@Override
	@Transactional
	public List<Student> listStudent() {
		
		return this.studentDAO.listStudent();
	}

	@Override
	@Transactional
	public long getStudentCount() {
		return this.studentDAO.getStudentCount();
	}
	
	

}
