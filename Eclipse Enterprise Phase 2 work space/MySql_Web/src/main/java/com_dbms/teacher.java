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


public class teacher {
	
	static List<teacher> teacher_list;
	String teacher_Name;
	String teacher_Id;
	String teacher_Dob;
	String teacher_City;
	
	public String getName() {
		return teacher_Name;
	}


	public void setName(String name) {
		this.teacher_Name = name;
	}


	public String getId() {
		return teacher_Id;
	}


	public void setId(String id) {
		this.teacher_Id = id;
	}


	public String getDob() {
		return teacher_Dob;
	}


	public void setDob(String dob) {
		this.teacher_Dob = dob;
	}


	public String getCity() {
		return teacher_City;
	}


	public void setCity(String city) {
		this.teacher_City = city;
	}
	
	public void generate_teacher_id()
	{
		String name=teacher_Name;
		String city=teacher_City;
		String dob=teacher_Dob;
		String[] db=dob.split("-");
		dob="";
		for(int i=0;i<db.length;i++)
		{
			dob=dob.concat(db[i]);
		}
		String id="";
		int count=get_toatalteachersindatabase()+1;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		
		id=id.concat(Integer.toString(count)+"."+name.strip()+"."+dtf.format(now));
		id=id.replaceAll("\\s", "");
		teacher_Id=id;
	}
	
	public int get_toatalteachersindatabase()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","dattago1");
			Statement statement = connection.createStatement();
			ResultSet rs=statement.executeQuery("select count(*) from teacher");
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
				System.out.println("com_dbms_teacher1 "+ex);
				System.out.println("com_dbms_teacher1 "+ex.getMessage());
				return(-3);
			}
	}
	
	public void storeindatabase()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","dattago1");
			Statement statement = connection.createStatement();
//			System.out.println("insert into student values('"+teacher_Name+"','"+teacher_Id+"',"+teacher_Dob+",'"+teacher_City+")");
			int rows=statement.executeUpdate("insert into teacher values('"+teacher_Name+"','"+teacher_Id+"','"+teacher_Dob+"','"+teacher_City+"')");
		}
		catch(Exception ex)
		{
			System.out.println("com_dbms_teacher2 "+ex);
			System.out.println("com_dbms_teacher2 "+ex.getMessage());
		}
	}
	
	public int remove_teacher(String rem_id)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","dattago1");
			Statement statement = connection.createStatement();
			int rows=statement.executeUpdate("Delete from teacher where teacher_id='"+rem_id+"'");
			return(1);
		}
		catch(Exception ex)
		{
			System.out.println("com_dbms_teacher5 "+ex);
			System.out.println("com_dbms_teacher5 "+ex.getMessage());
			return(0);
		}
	}
	
	public List<teacher> getallteachers()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","dattago1");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("Select * from teacher");
			ResultSetMetaData rsmd=rs.getMetaData();
			teacher_list=new ArrayList<teacher>();
			while(rs.next())
			{
				teacher s=new teacher();
				s.setName(rs.getString(1));
				s.setId(rs.getString(2));
				s.setDob(rs.getString(3));
				s.setCity(rs.getString(4));
				teacher_list.add(s);
			}
			if(teacher_list.isEmpty())
			{
				return(null);
			}
			return(teacher_list);
			
		}
		catch(Exception ex)
		{
			System.out.println("com_dbms_teacher4 "+ex);
			System.out.println("com_dbms_teacher4 "+ex.getMessage());
			return(null);
		}
	}


	@Override
	public String toString() {
		return "teacher [teacher_Name=" + teacher_Name + ", teacher_Id=" + teacher_Id + ", teacher_Dob=" + teacher_Dob
				+ ", teacher_City=" + teacher_City + "]";
	}
	
//	public static void main(String[] args) {
//	Scanner sc =new Scanner(System.in);
//	teacher s1=new teacher();
//	System.out.println("Enter the teacher Name");
//	s1.setName(sc.nextLine());
//	System.out.println("Enter the teacher City");
//	s1.setCity(sc.nextLine());
//	System.out.println("Enter the teacher Dob");
//	s1.setDob(sc.nextLine());
//	
//	s1.generate_teacher_id();
//	
//	System.out.println(s1);
//	
//	s1.storeindatabase();
//	
//}
	
}
