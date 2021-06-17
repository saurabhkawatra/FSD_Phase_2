package com.to;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
public class source_list {
	
	@Column(nullable=false)
	@Id
	private String source_id;
	
	@Column
	private String source;

	public String getSource_id() {
		return source_id;
	}

	public void setSource_id(String source_id) {
		this.source_id = source_id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public source_list() {
		super();
	}

	public source_list(String source_id, String source) {
		super();
		this.source_id = source_id;
		this.source = source;
	}
	
	@Override
	public String toString() {
		return "source_list [source_id=" + source_id + ", source=" + source + "]";
	}
	
	public static List<source_list> getallsources()
	{
		List<source_list> allsources=new ArrayList<>();
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionfactory=cfg.buildSessionFactory();
		Session session=sessionfactory.openSession();
		allsources=session.createNativeQuery("Select * from source_list",source_list.class).getResultList();
		
		return(allsources);
	}
	
//	public static void main(String[] args)
//	{
//		List<source_list> s=source_list.getallsources();
//		for(source_list e:s)
//		{
//			System.out.println(e);
//		}
//	}
	
	
}
