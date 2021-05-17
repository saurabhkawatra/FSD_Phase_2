package jdbc_crud_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDetailById {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Select user(); in sql to check under which user you are connected
			//show variables where variable_name ='port';
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb","root","dattago1");
			Statement statement = connection.createStatement();
			
			ResultSet rs=statement.executeQuery("Select * from employee where empid ="+102);
			if(rs.next()) {
				
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
			}
			else {
				System.out.println("No record is present with id 102");
			}
			
			rs=statement.executeQuery("Select * from employee where empid ="+103);
			
			if(rs.next()) {
				
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
			}
			else {
				System.out.println("No record is present with id 103");
			}
			
			connection.close();
		}catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}

	}

}
