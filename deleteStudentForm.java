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

public class deleteStudentForm extends JFrame{
	JPanel contentPane;
	private JTextField id_text;
	public deleteStudentForm()
	{
		
		setResizable(false);
		setBounds(new Rectangle(400, 400, 600, 600));
		
		setTitle("GNDEC -- delete student data");
		setBackground(new Color(205, 92, 92));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MONIKA\\Downloads\\logo (1).jpg"));
		
		 JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 179, 113));
		getContentPane().add(panel,BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel Student_heading = new JLabel("DELETE STUDENT");
		Student_heading.setBounds(205, 38, 279, 35);
		Student_heading.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(Student_heading);
		
		JLabel spacef = new JLabel("                          ");
		spacef.setBounds(0, 33, 78, 14);
		panel.add(spacef);
		
		JLabel id_label = new JLabel("ID :");
		id_label.setBounds(71, 109, 46, 35);
		id_label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(id_label);
		
		id_text = new JTextField();
		id_text.setBounds(152, 111, 371, 35);
		panel.add(id_text);
		id_text.setColumns(10);
		
		JLabel spaces = new JLabel("                                  ");
		spaces.setBounds(606, 33, 102, 14);
		panel.add(spaces);
		ButtonGroup bg=new ButtonGroup();
	
		JButton submit = new JButton("Submit");
		submit.setBounds(263, 216, 117, 42);
		submit.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel.add(submit);
		

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String id=id_text.getText();
				
				
				
				Student std=new Student();
				try {
					std.insertUpdateDeleteStudent('d', id);
					dispose();
					//panel.setVisible(false);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		}	
	
	private void jTextField_PhoneKeyTyped(java.awt.event.KeyEvent evt)
	{
		if(!Character.isDigit(evt.getKeyChar()))
		{
			evt.consume();
		}
	}
	
}
