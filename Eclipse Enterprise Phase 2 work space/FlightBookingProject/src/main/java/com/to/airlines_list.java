package com.to;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@Entity
public class airlines_list {
	
	@Column
	@Id
	private String airline_id;
	
	@Column
	private String airlinename;
	
	public static List<airlines_list> getallairlineslist()
	{
		List<airlines_list> allairlinelist=new ArrayList<>();
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionfactory=cfg.buildSessionFactory();
		Session session=sessionfactory.openSession();
		allairlinelist=session.createNativeQuery("select * from airlines_list",airlines_list.class).getResultList();
		return(allairlinelist);
		
	}
	
	public airlines_list() {
		super();
	}

	public airlines_list(String airline_id, String airlinename) {
		super();
		this.airline_id = airline_id;
		this.airlinename = airlinename;
	}



	@Override
	public String toString() {
		return "airlines_list [airline_id=" + airline_id + ", airlinename=" + airlinename + "]";
	}

	public String getAirline_id() {
		return airline_id;
	}

	public void setAirline_id(String airline_id) {
		this.airline_id = airline_id;
	}

	public String getAirlinename() {
		return airlinename;
	}

	public void setAirlinename(String airlinename) {
		this.airlinename = airlinename;
	}

}
