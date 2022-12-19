package Connections;

import java.awt.BorderLayout;import java.util.Calendar;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JRadioButton;

import java.util.Calendar;

public class AddCourses extends JFrame{
	JPanel contentPane;
	private JTextField id_text;
	private JTextField label_text;
	private JTextField hour_text;
	public AddCourses()
	{
		
		setResizable(false);
		setBounds(new Rectangle(800, 300, 600, 600));
		
		setTitle("GNDEC -- add student data");
		setBackground(new Color(205, 92, 92));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MONIKA\\Downloads\\logo (1).jpg"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 179, 113));
		getContentPane().add(panel,BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel Course_heading = new JLabel("ADD COURSES");
		Course_heading.setBounds(199, 0, 335, 35);
		Course_heading.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(Course_heading);
		
		JLabel spacef = new JLabel("                          ");
		spacef.setBounds(0, 33, 78, 14);
		panel.add(spacef);
		
		JLabel id_label = new JLabel("ID :");
		id_label.setBounds(85, 88, 28, 20);
		id_label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(id_label);
		
		id_text = new JTextField();
		id_text.setBounds(199, 88, 335, 20);
		panel.add(id_text);
		id_text.setColumns(10);
		
		JLabel spaces = new JLabel("                                  ");
		spaces.setBounds(606, 33, 102, 14);
		panel.add(spaces);
		
		JLabel F_label = new JLabel("Label_label");
		F_label.setBounds(85, 141, 68, 20);
		F_label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel.add(F_label);
		
		label_text = new JTextField();
		label_text.setBounds(199, 142, 335, 20);
		panel.add(label_text);
		label_text.setColumns(10);
		
		JLabel l_name = new JLabel("Hour_Label");
		l_name.setBounds(85, 197, 102, 20);
		l_name.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel.add(l_name);
		
		hour_text = new JTextField();
		hour_text.setColumns(10);
		hour_text.setBounds(199, 198, 335, 20);
		panel.add(hour_text);
		ButtonGroup bg=new ButtonGroup();
	
		JButton submit_course = new JButton("Submit");
		submit_course.setBounds(416, 375, 117, 42);
		submit_course.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel.add(submit_course);
		

		submit_course.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int id=id_text.getHeight();
				String label=label_text.getText();
				int hour_number=hour_text.getHeight();
				
				
				Courses crs=new Courses();
				try {
					crs.insertUpdateDeleteCourses('i', id, label, hour_number);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		}	
	
	
	
}