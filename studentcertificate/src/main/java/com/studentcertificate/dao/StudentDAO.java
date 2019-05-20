package com.studentcertificate.dao;

import java.util.List;

import com.studentcertificate.model.Student;


public interface StudentDAO {
	public void addStudent(Student u);
	public void updateStudent(Student u);
	public List<Student> listStudent();
	public Student getStudentById(int id);
	public void removeStudent(int id);
	public long getStudentCount();

}
