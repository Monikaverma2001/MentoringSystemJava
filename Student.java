package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Student {
	public void insertUpdateDeleteStudent(char operation,String id,String fname,String lname,
			                              String sex,String birthdate,String phone,String addess) throws ClassNotFoundException
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost/stdmgdb","root","");
			Statement stmt=con.createStatement();
			PreparedStatement ps;
			if(operation == 'i')
			{
				try {
					ps=con.prepareStatement("INSERT INTO student(id, first_name, last_name, sex, birthdate, phone, addess) VALUES (?,?,?,?,?,?,?)");
					ps.setString(1,id );
					ps.setString(2,fname );
					ps.setString(3,lname );
					ps.setString(4, sex);
					ps.setString(5,birthdate );
					ps.setString(6,phone );
					ps.setString(7,addess );
					
					if(ps.executeUpdate() >0)
					{
						JOptionPane.showMessageDialog(null, "New Student Added");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "New Student NOT Added");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			if(operation == 'u')
			{
				try {
					
					ps=con.prepareStatement("UPDATE student SET id="+id+",first_name="+fname+",last_name="+lname+",sex="+sex+",birthdate="+ birthdate +",phone="+phone+",addess="+addess+" WHERE id="+id);
					
					
					if(ps.executeUpdate() >0)
					{
						JOptionPane.showMessageDialog(null, "New Student Added");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "New Student NOT Added");
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
	public void insertUpdateDeleteStudent(char operation,String id) throws ClassNotFoundException
{

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost/stdmgdb","root","");
			Statement stmt=con.createStatement();
			PreparedStatement ps;


			if(operation == 'd')
				{
					try {
						ps=con.prepareStatement("DELETE FROM `student` WHERE id="+id);

						if(ps.executeUpdate() >0)
						{
							JOptionPane.showMessageDialog(null, "Student deleted");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "student donot delete");
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
