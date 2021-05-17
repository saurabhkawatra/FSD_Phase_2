package jdbc_crud_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EmployeeDeleteById {

	public static void main(String[] args) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Select user(); in sql to check under which user you are connected
			//show variables where variable_name ='port';
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb","root","dattago1");
			Statement statement = connection.createStatement();
			
			int rows=statement.executeUpdate("delete from employee where empid = 107");
			
			System.out.println(rows+" rows deleted");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

}
