package Connections;

import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordarea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void ActionListerner()
	{
		this.dispose();
	}
	public LoginForm() {
		setResizable(false);
		setTitle("GNDEC Mentoring App");
		setBackground(new Color(205, 92, 92));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MONIKA\\Downloads\\logo (1).jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 401);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBackground(new Color(60, 179, 113));
		contentPane.setBorder(new LineBorder(new Color(0, 128, 0), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JButton lb1_U = new JButton("*");
		lb1_U.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lb1_U.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		lb1_U.setBorder(null);
		lb1_U.setForeground(new Color(255, 0, 0));
		lb1_U.setBackground(new Color(60, 179, 113));
		lb1_U.setBounds(465, 69, 47, 37);
		contentPane.add(lb1_U);
		lb1_U.setVisible(false);
		
		final JButton lb2_U = new JButton("*");
		lb2_U.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		lb2_U.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lb2_U.setBorder(null);
		lb2_U.setForeground(new Color(255, 0, 0));
		lb2_U.setBackground(new Color(60, 179, 113));
		lb2_U.setBounds(465, 139, 47, 37);
		contentPane.add(lb2_U);
		lb2_U.setVisible(false);
		
		JLabel loginlabel = new JLabel("Log In");
		loginlabel.setBounds(10, 10, 534, 31);
		loginlabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		loginlabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginlabel.setBackground(new Color(95, 158, 160));
		contentPane.add(loginlabel);
		
		JLabel userlabel = new JLabel("Username :");
		userlabel.setHorizontalAlignment(SwingConstants.CENTER);
		userlabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		userlabel.setBackground(new Color(95, 158, 160));
		userlabel.setBounds(33, 69, 117, 31);
		contentPane.add(userlabel);
		
		JLabel passwordlabel = new JLabel("Password :");
		passwordlabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordlabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		passwordlabel.setBackground(new Color(95, 158, 160));
		passwordlabel.setBounds(41, 132, 96, 30);
		contentPane.add(passwordlabel);
		
		final JTextArea usernamearea = new JTextArea();
		usernamearea.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		usernamearea.setBounds(187, 66, 257, 51);
		contentPane.add(usernamearea);
		
		JButton loginbtn = new JButton("Log In..");
		loginbtn.setIcon(new ImageIcon(LoginForm.class.getResource("/Connections/icons/login.png")));
		loginbtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		loginbtn.setBackground(Color.WHITE);
		
		
		passwordarea = new JPasswordField();
		passwordarea.setFont(new Font("Tahoma", Font.PLAIN, 23));
		passwordarea.setBounds(187, 131, 257, 51);
		contentPane.add(passwordarea);
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {              
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/stdmgdb","root","");
					Statement stmt=con.createStatement();
					
					
					
					String sql="Select * from login where username='"+ usernamearea.getText()+"'and password= '" +passwordarea.getText().toString()+"'";
					ResultSet rs= stmt.executeQuery(sql);
					if(usernamearea.getText().equals("") && passwordarea.getText().toString().equals("")) 
					{
						lb1_U.setVisible(true);
						lb2_U.setVisible(true);
						JOptionPane.showMessageDialog(null, "Please Enter Username and password...");
						
						
					}
					
					else if(usernamearea.getText().equals("")) 
					{
						lb1_U.setVisible(true);
						lb2_U.setVisible(false);
						JOptionPane.showMessageDialog(null, "Please Enter Username...");
						
					}
					
					
					else if(passwordarea.getText().toString().equals("")) 
					{
						lb2_U.setVisible(true);
						lb1_U.setVisible(false);
						JOptionPane.showMessageDialog(null, "Please Enter Password...");
					}
					else if(rs.next()) {
						lb1_U.setVisible(false);
						lb2_U.setVisible(false);
						dispose();
						DataFrame jframe=new DataFrame(usernamearea.getText());	
						jframe.setVisible(true);
						jframe.setExtendedState(jframe.MAXIMIZED_BOTH);
												//JOptionPane.showMessageDialog(null, "Login successfully....");
						//contentPane.disable();
						con.close();
						}
					else
					{
						lb1_U.setVisible(true);
						lb2_U.setVisible(true);
						JOptionPane.showMessageDialog(null, "Incorrect username and password...");
						
						
					}
					//con.close();
					
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		loginbtn.setBounds(70, 220, 125, 37);
		contentPane.add(loginbtn);
		
		JButton signupbtn = new JButton("SignUp");
		signupbtn.setIcon(new ImageIcon(LoginForm.class.getResource("/Connections/icons/signup.png")));
		signupbtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		signupbtn.setBackground(Color.WHITE);
		signupbtn.setBounds(365, 220, 125, 37);
		contentPane.add(signupbtn);
		
		JButton forgotbtn = new JButton("forgot your password?");
		forgotbtn.setBorderPainted(false);
		forgotbtn.setForeground(new Color(255, 0, 0));
		forgotbtn.setBackground(new Color(60, 179, 113));
		forgotbtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		forgotbtn.setBounds(10, 289, 534, 37);
		contentPane.add(forgotbtn);
		
		
	}
}

