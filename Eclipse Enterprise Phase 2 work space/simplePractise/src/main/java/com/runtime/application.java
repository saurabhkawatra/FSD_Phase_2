package com.runtime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.to.student;

public class application {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		student s1=new student("idisabc","rahul","12-6-1996","Nagpur",12345678);
		
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		session.save(s1);
		
		transaction.commit();
		session.close();
	}

}
