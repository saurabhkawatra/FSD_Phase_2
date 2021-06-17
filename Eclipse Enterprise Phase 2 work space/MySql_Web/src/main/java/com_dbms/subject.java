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

public class subject {
	
	static List<subject> subject_list;
	String subject_Name;
	String subject_Id;
	String subject_Domain;
	
	
	public String getName() {
		return subject_Name;
	}
	public void setName(String subject_Name) {
		this.subject_Name = subject_Name;
	}
	public String getId() {
		return subject_Id;
	}
	public void setId(String subject_Id) {
		this.subject_Id = subject_Id;
	}
	public String getDomain() {
		return subject_Domain;
	}
	public void setDomain(String subject_Domain) {
		this.subject_Domain = subject_Domain;
	}
	
	public void generate_subject_id()
	{
		String name=subject_Name;
		String domain=subject_Domain;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
//		System.out.println(dtf.format(now));
		
		String id="";
		int count=get_toatalsubjectsindatabase()+1;
		id=id.concat(Integer.toString(count)+"."+name.strip()+"."+dtf.format(now).strip());
		id=id.replaceAll("\\s", "");
		subject_Id=id;
	}
	
	public int get_toatalsubjectsindatabase()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","dattago1");
			Statement statement = connection.createStatement();
			ResultSet rs=statement.executeQuery("select count(*) from subject");
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
				System.out.println("com_dbms_subject1 "+ex);
				System.out.println("com_dbms_subject1 "+ex.getMessage());
				return(-3);
			}
	}
	
	public void storeindatabase()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","dattago1");
			Statement statement = connection.createStatement();
//			System.out.println("insert into subject values('\"+subject_Name+\"','\"+subject_Id+\"','\"+subject_Domain+\"')");
			int rows=statement.executeUpdate("insert into subject values('"+subject_Name+"','"+subject_Id+"','"+subject_Domain+"')");
		}
		catch(Exception ex)
		{
			System.out.println("com_dbms_subject2 "+ex);
			System.out.println("com_dbms_subject2 "+ex.getMessage());
		}
	}
	
	public int remove_subject(String rem_id)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","dattago1");
			Statement statement = connection.createStatement();
			int rows=statement.executeUpdate("Delete from subject where subject_id='"+rem_id+"'");
			return(1);
		}
		catch(Exception ex)
		{
			System.out.println("com_dbms_subject5 "+ex);
			System.out.println("com_dbms_subject5 "+ex.getMessage());
			return(0);
		}
	}
	
	public List<subject> getallsubjects()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","dattago1");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("Select * from subject");
			ResultSetMetaData rsmd=rs.getMetaData();
			subject_list=new ArrayList<subject>();
			while(rs.next())
			{
				subject s=new subject();
				s.setName(rs.getString(1));
				s.setId(rs.getString(2));
				s.setDomain(rs.getString(3));
				subject_list.add(s);
			}
			if(subject_list.isEmpty())
			{
				return(null);
			}
			return(subject_list);
			
		}
		catch(Exception ex)
		{
			System.out.println("com_dbms_subject4 "+ex);
			System.out.println("com_dbms_subject4 "+ex.getMessage());
			return(null);
		}
	}
	
	
	@Override
	public String toString() {
		return "subject [subject_Name=" + subject_Name + ", subject_Id=" + subject_Id + ", subject_Domain="
				+ subject_Domain + "]";
	}

	
//	public static void main(String[] args) {
//	Scanner sc =new Scanner(System.in);
//	subject s1=new subject();
//	
//	System.out.println("Enter the Subject Name");
//	s1.setName(sc.nextLine());
//	System.out.println("Enter the Subject Domain");
//	s1.setDomain(sc.nextLine());
//
//	s1.generate_subject_id();
//	
//	System.out.println(s1);
//	
//	s1.storeindatabase();
//	
//}
	
}
