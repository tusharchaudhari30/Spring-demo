package com.studentcertificate.dao;

import java.util.List;

import com.studentcertificate.model.Certificate;
import com.studentcertificate.model.Student;



public interface CertificateDAO {
	public void addCertificate(Certificate u);
	public Certificate getCertificateById(int id);
	public List<Certificate> listCertificate();
	public Long getLCcount();
	public Long getBonafidecount();
}
