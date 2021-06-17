package com_dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class class_base {
	
	static List<class_base> class_list;
	String class_Name;
	String class_Id;
	
	public String getName() {
		return class_Name;
	}
	public void setName(String class_Name) {
		this.class_Name = class_Name;
	}
	public String getId() {
		return class_Id;
	}
	public void setId(String class_Id) {
		this.class_Id = class_Id;
	}
	
	public void generate_class_id()
	{
		String name=class_Name;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
//		System.out.println(dtf.format(now));
		
		String id="";
		int count=get_toatalclassesindatabase()+1;
		id=id.concat(Integer.toString(count)+"."+name.strip()+"."+dtf.format(now).strip());
		id=id.replaceAll("\\s", "");
		class_Id=id;
	}
	
	public int get_toatalclassesindatabase()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","dattago1");
			Statement statement = connection.createStatement();
			ResultSet rs=statement.executeQuery("select count(*) from class");
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
				System.out.println("com_dbms_class_base1 "+ex);
				System.out.println("com_dbms_class_base1 "+ex.getMessage());
				return(-3);
			}
	}
	
	
	public void storeindatabase()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","dattago1");
			Statement statement = connection.createStatement();
//			System.out.println("insert into class values('\"+class_Name+\"','\"+class_Id+\"')\"");
			int rows=statement.executeUpdate("insert into class values('"+class_Name+"','"+class_Id+"')");
		}
		catch(Exception ex)
		{
			System.out.println("com_dbms_class_base2 "+ex);
			System.out.println("com_dbms_class_base2 "+ex.getMessage());
		}
	}
	
	
	public int remove_subject(String rem_id)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","dattago1");
			Statement statement = connection.createStatement();
			int rows=statement.executeUpdate("Delete from class where class_id='"+rem_id+"'");
			return(1);
		}
		catch(Exception ex)
		{
			System.out.println("com_dbms_class_base5 "+ex);
			System.out.println("com_dbms_class_base5 "+ex.getMessage());
			return(0);
		}
	}
	
	
	public List<class_base> getallclasses()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","dattago1");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("Select * from class");
			ResultSetMetaData rsmd=rs.getMetaData();
			class_list=new ArrayList<class_base>();
			while(rs.next())
			{
				class_base s=new class_base();
				s.setName(rs.getString(1));
				s.setId(rs.getString(2));
				class_list.add(s);
			}
			if(class_list.isEmpty())
			{
				return(null);
			}
			return(class_list);
			
		}
		catch(Exception ex)
		{
			System.out.println("com_dbms_class_base4 "+ex);
			System.out.println("com_dbms_class_base4 "+ex.getMessage());
			return(null);
		}
	}
	
	public void assign_student_to_class(String student_id,String class_id)
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","dattago1");
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into assign_student_to_class values ('"+student_id+"','"+class_id+"')");
			
		}catch(Exception ex)
		{
			System.out.println("com_dbms_class_base7 "+ex);
			System.out.println("com_dbms_class_base7 "+ex.getMessage());
		}
		
	}
	
	public void assign_teacher_to_class()
	{
		
	}
	public void assign_subject_to_class()
	{
		
	}
	
	@Override
	public String toString() {
		return "class_base [class_Name=" + class_Name + ", class_Id=" + class_Id + "]";
	}
	
	
//	public static void main(String[] args) 
//	{
//		
//	Scanner sc =new Scanner(System.in);
//	class_base s1=new class_base();
//	
//	System.out.println("Enter the Class Name");
//	s1.setName(sc.nextLine());
//
//	s1.generate_class_id();
//	
//	System.out.println(s1);
//	
//	s1.storeindatabase();
//	
//	}
	

}
