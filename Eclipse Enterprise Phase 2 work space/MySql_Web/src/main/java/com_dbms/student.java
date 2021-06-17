package com_dbms;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class student {
	static List<student> student_list;
	String student_Name;
	String student_Id;
	String student_Dob;
	String student_City;
	
	

	public String getName() {
		return student_Name;
	}


	public void setName(String name) {
		this.student_Name = name;
	}


	public String getId() {
		return student_Id;
	}


	public void setId(String id) {
		this.student_Id = id;
	}


	public String getDob() {
		return student_Dob;
	}


	public void setDob(String dob) {
		this.student_Dob = dob;
	}


	public String getCity() {
		return student_City;
	}


	public void setCity(String city) {
		this.student_City = city;
	}
	
	public void generate_student_id()
	{
		String name=student_Name;
		String city=student_City;
		String dob=student_Dob;
		String[] db=dob.split("-");
		dob="";
		for(int i=0;i<db.length;i++)
		{
			dob=dob.concat(db[i]);
		}
		String id="";
		int count=get_toatalstudentsindatabase()+1;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		id=id.concat(Integer.toString(count)+"."+name.strip()+"."+dtf.format(now).strip());
		id=id.replaceAll("\\s", "");
		student_Id=id;
	}
	public int get_toatalstudentsindatabase()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","dattago1");
			Statement statement = connection.createStatement();
			ResultSet rs=statement.executeQuery("select count(*) from student");
				if(rs==null)
				{
					return(1);
				}
				else
				{
					rs.next();
					return(rs.getInt(1));
				}
				
			}
			catch(Exception ex)
			{
				System.out.println("com_dbms_student1 "+ex);
				System.out.println("com_dbms_student1 "+ex.getMessage());
				return(-3);
			}
	}
	
	public void storeindatabase()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","dattago1");
			Statement statement = connection.createStatement();
//			System.out.println("insert into student values('"+student_Name+"','"+student_Id+"',"+student_Dob+",'"+student_City+")");
			int rows=statement.executeUpdate("insert into student values('"+student_Name+"','"+student_Id+"','"+student_Dob+"','"+student_City+"')");
		}
		catch(Exception ex)
		{
			System.out.println("com_dbms_student2 "+ex);
			System.out.println("com_dbms_student2 "+ex.getMessage());
		}
	}
	public int remove_student(String rem_id)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","dattago1");
			Statement statement = connection.createStatement();
			int rows=statement.executeUpdate("Delete from student where student_id='"+rem_id+"'");
			return(1);
		}
		catch(Exception ex)
		{
			System.out.println("com_dbms_student5 "+ex);
			System.out.println("com_dbms_student5 "+ex.getMessage());
			return(0);
		}
	}
	
	public List<student> getallstudents()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","dattago1");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("Select * from student");
			ResultSetMetaData rsmd=rs.getMetaData();
			student_list=new ArrayList<student>();
			while(rs.next())
			{
				student s=new student();
				s.setName(rs.getString(1));
				s.setId(rs.getString(2));
				s.setDob(rs.getString(3));
				s.setCity(rs.getString(4));
				student_list.add(s);
			}
			if(student_list.isEmpty())
			{
				return(null);
			}
			return(student_list);
			
		}
		catch(Exception ex)
		{
			System.out.println("com_dbms_student4 "+ex);
			System.out.println("com_dbms_student4 "+ex.getMessage());
			return(null);
		}
	}


	@Override
	public String toString() {
		return "student [student_Name=" + student_Name + ", student_Id=" + student_Id + ", student_Dob=" + student_Dob
				+ ", student_City=" + student_City + "]";
	}


//	public static void main(String[] args) {
//		Scanner sc =new Scanner(System.in);
//		student s1=new student();
//		System.out.println("Enter the Student Name");
//		s1.setName(sc.nextLine());
//		System.out.println("Enter the Student City");
//		s1.setCity(sc.nextLine());
//		System.out.println("Enter the Student Dob");
//		s1.setDob(sc.nextLine());
//		
//		s1.generate_student_id();
//		
//		System.out.println(s1);
//		
//		s1.storeindatabase();
//		
//	}

}
