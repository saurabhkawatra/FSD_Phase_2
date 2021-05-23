package jdbc_crud_ps_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

class EmployeeOperation {
	
	Scanner sc=new Scanner(System.in);
	Connection connection=null;
	PreparedStatement pstatement=null;
	
	public void getAllEmployees() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb","root","dattago1");
			PreparedStatement stat=con.prepareStatement("Select * from employee");
			ResultSet rs=stat.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			
			int colcount=rsmd.getColumnCount();
			int rowcount=rs.getFetchSize();
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}

	public void getEmployeeById() {
		System.out.println("Enter the id :-");
		int id=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb","root","dattago1");
			pstatement = connection.prepareStatement("Select * from Employee where empid=?");
			pstatement.setInt(1,id);
			ResultSet rs=pstatement.executeQuery();
			while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	public void insertEmployee()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Select user(); in sql to check under which user you are connected
			//show variables where variable_name ='port';
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb","root","dattago1");
			pstatement = connection.prepareStatement("insert into Employee vlaues(?,?,?);");
			pstatement.setInt(1,108);
			pstatement.setString(2, "Bhawna");
			pstatement.setFloat(3, 12345.78F);
			int rows = pstatement.executeUpdate();
			if(rows > 0)
				System.out.println(rows + " record(s) inserted sucessfully");
			connection.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void UpdateEmployee() {
		System.out.println("Enter the id you want to update");
		int id=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb","root","dattago1");
			pstatement = connection.prepareStatement("Select * from Employee where empid=?");
			pstatement.setInt(1,id);
			ResultSet rs=pstatement.executeQuery();
			while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			System.out.println("Enter the field you want to want to update");
			System.out.println("1. Name");
			System.out.println("2. Salary");
			int choice=sc.nextInt();
			if(choice==1)
			{
				System.out.println("Enter the new Name");
				String name=sc.nextLine();
				pstatement = connection.prepareStatement("Update Employee set empname="+name+" where empid="+id);
				System.out.println(pstatement.executeUpdate());
				
			}
			else if(choice==2)
			{
				System.out.println("Enter the new Salary");
				int salary=sc.nextInt();
				pstatement = connection.prepareStatement("Update Employee set salary="+salary+" where empid="+id);
				System.out.println(pstatement.executeUpdate());
				
			}
			else
			{
				System.out.println("Invalid Choice");
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}

	public void DeleteEmployee() {
		
		System.out.println("Enter the id you want to delete");
		int id=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb","root","dattago1");
			pstatement = connection.prepareStatement("Delete from Employee where empid=?");
			pstatement.setInt(1,id);
			ResultSet rs=pstatement.executeQuery();
			System.out.println("Employee Deleted with id= "+id);
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
	
	public class EmployeeCRUD {

	public static void main(String[] args) {
		
		EmployeeOperation empOperation = new EmployeeOperation();
		Scanner scan= new Scanner(System.in);
		System.out.println("1: Get All Employees");
		System.out.println("2: Get Employee by Id");
		System.out.println("3: Insert New Employee");
		System.out.println("4: Update Existing Employee");
		System.out.println("5. Delete Existing Employee");
		System.out.print("Enter your choice :");
		
		int choice=scan.nextInt();
		
		switch(choice) {
		
		case 1:{
			empOperation.getAllEmployees();
			break;
		}
		case 2:{
			System.out.print("Enter employee Id to fetch the employee details:");
			empOperation.getEmployeeById();
			break;
			
		}
		case 3:{
			empOperation.insertEmployee();
			break;
		}
		case 4:{
			empOperation.UpdateEmployee();
			break;
		}
		case 5:{
			empOperation.DeleteEmployee();
			break;
		}
		default:{
			System.out.println("Invalid choice");
			break;
		}
		
		}
		

	}

}
