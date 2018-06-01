import java.sql.*;
public class Driver {

	public static void main(String[] args) {
	
		try	{
			// 1. Conseguir conexão à um banco de dados
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");
			
			// 2. Criar uma declaração
			Statement myStmt = myConn.createStatement();
			
			// 3. Executar uma SQL Query
			ResultSet myRs = myStmt.executeQuery("select * from employees");		
			
			// 4. Processar o Result set
			while (myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
