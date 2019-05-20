package com.studentcertificate.service;

import java.util.List;

import com.studentcertificate.model.Student;

public interface StudentService {
	public void addStudent(Student s);
	public Student getStudentByid(int enroll);
	public void updateStudent(Student s);
	public void removeStudent(int enroll);
	public List<Student> listStudent();
	public long getStudentCount();

	

}
