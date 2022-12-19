package Connections;

import java.sql.*;



public class MyFunction {
	public static int countData(String tableName) throws SQLException
	{
		int total=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/stdmgdb","root","");
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * from "+tableName);
			while(rs.next())
			{
				total++;
			}
			
			
//			ResultSet results = statement.executeQuery("SELECT * FROM student");
//			 
//			 
//			// For each row of the result set ...
//			 
//			while (results.next()) {
//			 
//			 
//			  // Get the data from the current row using the column index - column data are in the VARCHAR format
//			 
//			  String data = results.getString(1);
//			 
//			  System.out.println("Fetching data by column index for row " + results.getRow() + " : " + data);
//			 
//			 
//			  // Get the data from the current row using the column name - column data are in the VARCHAR format
//			 
//			  data = results.getString("first_name");
//			 
//			  System.out.println("Fetching data by column name for row " + results.getRow() + " : " + data);
//			 
//			 
//			}
		}
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		
		
		return total;
	}
}
