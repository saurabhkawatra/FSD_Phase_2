package com.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class student {
	
	@Column(name="student_id",nullable=false)
	@Id
	String id;
	
	@Column(name="student_name",nullable=false,length=40)
	String name;
	@Column(name="student_dob",nullable=false,length=30)
	String dob;
	@Column(name="student_city",nullable=false,length=30)
	String city;
	@Column(name="student_phno",nullable=false,length=20)
	int phno;
	
	
	
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	

	public student(String id, String name, String dob, String city, int phno) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.city = city;
		this.phno = phno;
	}



	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", dob=" + dob + ", city=" + city + ", phno=" + phno + "]";
	}



	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPhno() {
		return phno;
	}
	public void setPhno(int phno) {
		this.phno = phno;
	}
	

}
