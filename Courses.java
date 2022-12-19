package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Courses {

	

	 

	public void insertUpdateDeleteCourses(char operation, int id, String label, int hours_number) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost/stdmgdb","root","");
			Statement stmt=con.createStatement();
			PreparedStatement ps;
			if(operation == 'i')
			{
				try {
					ps=con.prepareStatement("INSERT INTO course(id, label, hours_number) VALUES (?,?,?)");
					ps.setInt(1,id );
					ps.setString(2,label );
					ps.setInt(3,hours_number );
					
					
					if(ps.executeUpdate() >0)
					{
						JOptionPane.showMessageDialog(null, "New Courses Added");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
}
