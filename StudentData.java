package Connections;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class StudentData extends JFrame {
	private JTable table;
	StudentData() throws SQLException
	{
		
		JPanel panel = new JPanel();
		//getContentPane().add(panel);
		//panel.setLayout(null);
		
		//JScrollBar scrollBar = new JScrollBar();
		//scrollBar.setBounds(398, 22, 26, 223);
		//panel.add(scrollBar);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/stdmgdb","root","");
			Statement statement = con.createStatement();
			
			
			
			ResultSet rs = statement.executeQuery("SELECT * FROM student");
			 
			 
			// For each row of the result set ...
			
			
			JFrame f=new JFrame();    
			String data[][]=new String[31][6];         
			 String column[]={"ID","NAME","PHONENUMBER","SEX","D.O.B","ADDRESS"};         
		    data[0][0]="STUDENT ID";
		    data[0][1]="STUDENT NAME";
		    data[0][2]="PHONE NUMBER";
		    data[0][3]="SEX";
		    data[0][4]="D.O.B";
		    data[0][5]="ADDRESS";
			int i=1;
			while (rs.next()) {
				
				
               data[i][0]= rs.getString("id");
               data[i][1]= rs.getString("first_name")+" "+rs.getString("last_name");
              data[i][2] = Integer.toString(rs.getInt("phone"));
              data[i][3]=rs.getString("sex");
              
              data[i][4]= rs.getString("birthdate");
              data[i][5]= rs.getString("addess");
              i++;
              
           }
			JTable jt=new JTable(data,column);  
			jt.setSize(new Dimension(2, 2));
			jt.setGridColor(new Color(0, 0, 0));
			
			jt.setRowHeight(35);
			jt.setRowMargin(20);
			
			jt.setColumnSelectionAllowed(true);
			jt.setFont(new Font("Times New Roman", Font.BOLD, 18));
			jt.setBackground(new Color(255, 255, 255));
			Border border = new LineBorder(Color.ORANGE, 4, true);
			jt.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			 jt.setBounds(40, 141, 1829, 627);
			    
			    jt.setVisible(true);
			    f.add(jt);
			
		}
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
