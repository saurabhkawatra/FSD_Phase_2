package jdbc_crud_ps_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

class EmployeeOperation {
	
	Connection connection=null;
	PreparedStatement pstatement=null;
	
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
}
	
	public class EmployeeCRUD {

	public static void main(String[] args) {
		
		EmployeeOperation empOperation = new EmployeeOperation();
		Scanner scan= new Scanner(System.in);
		System.out.println("1: Get All Employees");
		System.out.println("2: Get Employee by Id");
		System.out.println("3:  ");
		System.out.println();
		

	}

}
