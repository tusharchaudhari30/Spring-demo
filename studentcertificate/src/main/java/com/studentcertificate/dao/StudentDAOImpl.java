package com.studentcertificate.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studentcertificate.model.Student;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addStudent(Student u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(u);
	}

	@Override
	public void updateStudent(Student u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(u);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listStudent() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> studentList =  session.createQuery("from Student").list();
		return studentList;
	}

	@Override
	public Student getStudentById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student u=(Student) session.load(Student.class, new Integer(id));
		if(null == u) {
			u=new Student();
		}
		return u;
	}

	@Override
	public void removeStudent(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student u=(Student) session.load(Student.class,new Integer(id));
		if(null !=u) {
			session.delete(u);
		}
		
	}

	@Override
	public long getStudentCount() {
		Session session = this.sessionFactory.getCurrentSession();
		Long count = (Long)session.createQuery("select count(*) from Student student").uniqueResult();
		
		return count;
	}
	

}
