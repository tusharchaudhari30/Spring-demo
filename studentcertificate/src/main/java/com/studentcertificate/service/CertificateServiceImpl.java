package com.studentcertificate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentcertificate.dao.CertificateDAO;
import com.studentcertificate.model.Certificate;



@Service
public class CertificateServiceImpl implements CertificateService{
	@Autowired
	private CertificateDAO certificateDAO;

	@Override
	@Transactional
	public void addCertificate(Certificate s) {
		this.certificateDAO.addCertificate(s);
		
	}

	@Override
	@Transactional
	public Certificate getCertificateByid(int ref) {
		return this.certificateDAO.getCertificateById(ref);
	}
	
	@Override
	@Transactional
	public List<Certificate> listCertificate()
	{
		return this.certificateDAO.listCertificate();
	}

	@Override
	@Transactional
	public Long getLCcount() {
		
		return this.certificateDAO.getLCcount();
	}

	@Override
	@Transactional
	public Long getBonafidecount() {
		return this.certificateDAO.getBonafidecount();
	}
	
	
	

}
