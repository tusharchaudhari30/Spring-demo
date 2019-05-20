package com.studentcertificate.dao;


import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studentcertificate.model.Certificate;

@Repository
@Transactional
public class CertificateDAOImpl  implements CertificateDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCertificate(Certificate u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(u);		
	}

	@Override
	public Certificate getCertificateById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Certificate u=(Certificate) session.load(Certificate.class, new Integer(id));
		if(null == u) {
			u=new Certificate();
		}
		return u;
	}
	@Override
	public List<Certificate> listCertificate()
	{
		Session session = this.sessionFactory.getCurrentSession();
		List<Certificate> certificateList =  session.createQuery("from Certificate").list();
		return certificateList;
	}

	@Override
	public Long getLCcount() {
		Session session = this.sessionFactory.getCurrentSession();
		Long count = (Long)session.createQuery("select count(*) from Certificate certificate where certificate.certificate='LC'").uniqueResult();
		return count;
	}

	@Override
	public Long getBonafidecount() {
		Session session = this.sessionFactory.getCurrentSession();
		Long count = (Long)session.createQuery("select count(*) from Certificate certificate where certificate.certificate='Bonafide'").uniqueResult();
		return count;
	}
	
	

}
