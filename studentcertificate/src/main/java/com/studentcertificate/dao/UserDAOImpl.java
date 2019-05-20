package com.studentcertificate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studentcertificate.model.USER;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(USER u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(u);
		
	}

	@Override
	public void updateUser(USER u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(u);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<USER> listUser() {
		Session session = this.sessionFactory.getCurrentSession();
		List<USER> userList =  session.createQuery("from USER").list();
		return userList;
	}

	@Override
	public USER getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		USER u=(USER) session.load(USER.class, new Integer(id));
		return u;
	}

	@Override
	public void removeUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		USER u=(USER) session.load(USER.class,new Integer(id));
		if(null !=u) {
			session.delete(u);
		}
		
	}

	

}
