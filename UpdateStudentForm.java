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

public class UpdateStudentForm extends JFrame{
	JPanel contentPane;
	private JTextField id_text;
	private JTextField f_text;
	private JTextField d_text;
	private JTextField p_text;
	private JTextField a_text;
	private JTextField l_text;
	public UpdateStudentForm()
	{
		
		setResizable(false);
		setBounds(new Rectangle(800, 300, 600, 900));
		
		setTitle("GNDEC -- upadte student data");
		setBackground(new Color(205, 92, 92));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MONIKA\\Downloads\\logo (1).jpg"));
		
		 JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 179, 113));
		getContentPane().add(panel,BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel Student_heading = new JLabel("UPDATE STUDENT");
		Student_heading.setBounds(255, 0, 279, 35);
		Student_heading.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(Student_heading);
		
		JLabel spacef = new JLabel("                          ");
		spacef.setBounds(0, 33, 78, 14);
		panel.add(spacef);
		
		JLabel id_label = new JLabel("ID :");
		id_label.setBounds(88, 28, 28, 20);
		id_label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(id_label);
		
		id_text = new JTextField();
		id_text.setBounds(199, 35, 335, 24);
		panel.add(id_text);
		id_text.setColumns(10);
		
		JLabel spaces = new JLabel("                                  ");
		spaces.setBounds(606, 33, 102, 14);
		panel.add(spaces);
		
		JLabel F_label = new JLabel("First Name");
		F_label.setBounds(84, 69, 68, 20);
		F_label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel.add(F_label);
		
		f_text = new JTextField();
		f_text.setBounds(199, 70, 335, 28);
		panel.add(f_text);
		f_text.setColumns(10);
		
		JLabel l_name = new JLabel("Last Name");
		l_name.setBounds(84, 113, 67, 20);
		l_name.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel.add(l_name);
		
		JLabel sex_label = new JLabel("Sex : ");
		sex_label.setBounds(83, 152, 34, 20);
		sex_label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel.add(sex_label);
		
		d_text = new JTextField();
		d_text.setFont(new Font("Yu Gothic Light", Font.PLAIN, 13));
		d_text.setText("month date,year");
		d_text.setBounds(198, 201, 335, 28);
		panel.add(d_text);
		d_text.setColumns(10);
		
		JLabel dob_label = new JLabel("D.O.B");
		dob_label.setBounds(83, 201, 41, 20);
		dob_label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel.add(dob_label);
		
		JLabel phone_label = new JLabel("Phone :");
		phone_label.setBounds(83, 254, 45, 20);
		phone_label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel.add(phone_label);
		
		p_text = new JTextField();
		p_text.setBounds(198, 255, 336, 28);
		panel.add(p_text);
		p_text.setColumns(10);
		
		JLabel add_label = new JLabel("Address :");
		add_label.setBounds(83, 300, 58, 20);
		add_label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel.add(add_label);
		
		a_text = new JTextField();
		a_text.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		a_text.setBounds(198, 301, 335, 28);
		panel.add(a_text);
		a_text.setColumns(90);
		
		
		final JRadioButton radio_male = new JRadioButton("male");
		radio_male.setBounds(250, 152, 110, 23);
		panel.add(radio_male);
		
		final JRadioButton radio_female = new JRadioButton("female");
		radio_female.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radio_female.setBounds(385, 152, 110, 23);
		panel.add(radio_female);
		
		l_text = new JTextField();
		l_text.setColumns(10);
		l_text.setBounds(199, 109, 335, 25);
		panel.add(l_text);
		ButtonGroup bg=new ButtonGroup();
		bg.add(radio_female);
		bg.add(radio_male);
		radio_male.setSelected(true);
	
		JButton submit = new JButton("Submit");
		submit.setBounds(417, 425, 117, 42);
		submit.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel.add(submit);
		

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String id=id_text.getText();
				
				String fname=f_text.getText();
				String lname=l_text.getText();
				String phone=p_text.getText();
				String address=a_text.getText();
				
				String bdate=d_text.getText();
				String sex="Male";
				if(radio_female.isSelected())
				{
					sex="Female";
				}
				
				Student std=new Student();
				try {
					std.insertUpdateDeleteStudent('u', id, fname, lname, sex, bdate, phone, address);
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
