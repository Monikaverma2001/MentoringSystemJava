package Connections;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollBar;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.Scrollbar;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Choice;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class DataFrame extends JFrame{
	static JPanel contentPane;
	private JList listsem;
	private JList listdep;
	/**
	 * @throws SQLException 
	 * @wbp.nonvisual location=19927,449
	 */
	public static void getStudent() throws SQLException
	{
		//if(i==1) {
		  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/stdmgdb","root","");
				Statement statement = con.createStatement();
				
				
				
				ResultSet rs = statement.executeQuery("SELECT * FROM student limit 30");
				 
				 
				// For each row of the result set ...
				
				
				//JFrame f=new JFrame();   
				
				 String data[][]=new String[31][7];         
				 String column[]={"SNO.","ID","NAME","PHONENUMBER","SEX","D.O.B","ADDRESS"};       
				 data[0][0]="SNO.";
			    data[0][1]="STUDENT ID";
			    data[0][2]="STUDENT NAME";
			    data[0][3]="PHONE NUMBER";
			    data[0][4]="SEX";
			    data[0][5]="D.O.B";
			    data[0][6]="ADDRESS";
				int i=1;
				while (rs.next()) {
					
					data[i][0]=Integer.toString(i);
	                data[i][1]= Integer.toString(rs.getInt("id"));
	                data[i][2]= rs.getString("first_name")+" "+rs.getString("last_name");
	               data[i][3] = Integer.toString(rs.getInt("phone"));
	               data[i][4]=rs.getString("sex");
	               
	               data[i][5]= rs.getString("birthdate");
	               data[i][6]= rs.getString("addess");
	               i++;
	               
	            }
				JTable jt=new JTable(data,column);  
				jt.setSize(new Dimension(2, 2));
				jt.setGridColor(new Color(0, 0, 0));
				
				jt.setRowHeight(20);
				jt.setRowMargin(20);
				
				jt.setColumnSelectionAllowed(true);
				jt.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				jt.setBackground(new Color(255, 255, 255));
				Border border = new LineBorder(Color.ORANGE, 4, true);
				jt.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			    //jt.setBounds(35, 22, 389, 223);          
			   // JScrollPane sp=new JScrollPane(jt);    
			    //f.getContentPane().add(sp);          
			    //f.setSize(300,400);    
			   // f.setVisible(true);
			    
				jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			    jt.setBounds(88, 160, 1077, 636);
			    
			    jt.setVisible(true);
			    contentPane.add(jt);
			    //setContentPane(contentPane);
				contentPane.setLayout(null);
			    contentPane.setVisible(true);
			    
			}
			catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
	//		}
		}
		//else if(i==2)
		//{
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/stdmgdb","root","");
//				Statement statement = con.createStatement();
//				
//				
//				
//				ResultSet rs = statement.executeQuery("SELECT * FROM course inner join student where student.id=course.id limit 30");
//				 
//				 
//				// For each row of the result set ...
//				
//				
//				//JFrame f=new JFrame();   
//				
//				 String data[][]=new String[15][7];         
//				 String column[]={"SNO.","ID","COURSE NAME","NOH"};       
//				 data[0][0]="SNO.";
//			    data[0][1]="ID";
//			    data[0][2]="COURSE NAME";
//			    data[0][3]="NOH";
//			    
//				int i=1;
//				while (rs.next()) {
//					
//					data[i][0]=Integer.toString(i);
//	                data[i][1]= Integer.toString(rs.getInt("id"));
//	                data[i][2]= rs.getString("label");
//	               data[i][3] = Integer.toString(rs.getInt("hours_number"));
//	              
//	               i++;
//	               
//	            }
//				JTable jt2=new JTable(data,column);  
//				jt2.setSize(new Dimension(2, 2));
//				jt2.setGridColor(new Color(0, 0, 0));
//				
//				jt2.setRowHeight(35);
//				jt2.setRowMargin(20);
//				
//				jt2.setColumnSelectionAllowed(true);
//				jt2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
//				jt2.setBackground(new Color(255, 255, 255));
//				Border border = new LineBorder(Color.ORANGE, 4, true);
//				jt2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//			    //jt.setBounds(35, 22, 389, 223);          
//			   // JScrollPane sp=new JScrollPane(jt);    
//			    //f.getContentPane().add(sp);          
//			    //f.setSize(300,400);    
//			   // f.setVisible(true);
//			    
//				jt2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//			    jt2.setBounds(1170, 158, 528, 641);
//			    
//			    jt2.setVisible(true);
//			    contentPane.add(jt2);
//			    //setContentPane(contentPane);
//				contentPane.setLayout(null);
//			    contentPane.setVisible(true);
//			    
//			}
//			catch (ClassNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		//}
		
//	}
//	
//	
//	
	
	
	
	public static void getStudent(String d,String s) throws SQLException
	{
		//if(i==1) {
		  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/stdmgdb","root","");
				Statement statement = con.createStatement();
				
				
				
				ResultSet rs = statement.executeQuery(" SELECT student.id,first_name,last_name,phone,sex,addess ,birthdate,label,hours_number FROM student inner join course where course.id=student.id and course.label='"+d+"' and course.hours_number='"+s+"' limit 30");
				 
				 
				// For each row of the result set ...
				
				
				//JFrame f=new JFrame();   
				
				 String data[][]=new String[31][10];         
				 String column[]={"SNO.","ID","NAME","PHONENUMBER","BIRTHDATE","SEX","D.O.B","ADDRESS","DEPT","SEMESTER"};       
				 data[0][0]="SNO.";
			    data[0][1]="STUDENT ID";
			    data[0][2]="STUDENT NAME";
			    data[0][3]="L NAMe";
			    data[0][4]="PHONE NUMBER";
			    data[0][5]="SEX";
			    data[0][6]="D.O.B";
			    data[0][7]="ADDRESS";
			    data[0][8]="DEPT";
			    data[0][9]="SEMESTER";
				int i=1;
				while (rs.next()) {
					
					data[i][0]=Integer.toString(i);
	                data[i][1]= Integer.toString(rs.getInt("student.id"));
	                data[i][2]= rs.getString("first_name");
	                data[i][3]= rs.getString("last_name");
	               data[i][4] = Integer.toString(rs.getInt("phone"));
	               data[i][5]=rs.getString("sex");
	               
	               data[i][6]= rs.getString("birthdate");
	               data[i][7]= rs.getString("addess");
	               data[i][8]= rs.getString("label");
	               data[i][9]= rs.getString("hours_number");
	               
	               i++;
	               
	            }
				JTable jt=new JTable(data,column);  
				jt.setSize(new Dimension(2, 2));
				jt.setGridColor(new Color(0, 0, 0));
				
				jt.setRowHeight(30);
				jt.setRowMargin(20);
				
				jt.setColumnSelectionAllowed(false);
				jt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				jt.setBackground(new Color(255, 255, 255));
				Border border = new LineBorder(Color.ORANGE, 4, true);
				jt.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			   
			    
				jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			    jt.setBounds(88, 158, 955, 641);
			    
			    jt.setVisible(true);
			    contentPane.add(jt);
			   
				contentPane.setLayout(null);
			    contentPane.setVisible(true);
			    
			}
			catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
	
		}
		
		
	}
	
	
	
	//private final JScrollPane scrollPane = new JScrollPane();
	DataFrame(final String usernamearea) throws SQLException
	{
		JPanel panel = new JPanel();
		getContentPane().add(panel,BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("hello");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblNewLabel);
		//JFrame j=new JFrame();
		setResizable(true);
		setTitle("GNDEC Mentoring App");
		setBackground(new Color(205, 92, 92));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MONIKA\\Downloads\\logo (1).jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1942, 1162);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(20, 20));
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBackground(new Color(60, 179, 113));
		contentPane.setBorder(new LineBorder(new Color(0, 128, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 20000, 50);
		contentPane.add(menuBar);
	//	getStudent();
		JLabel lblNewLabel_1 = new JLabel("");
		menuBar.add(lblNewLabel_1);
		
		JMenu mnNewMenu_2_1 = new JMenu("student\r\n");
		mnNewMenu_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		menuBar.add(mnNewMenu_2_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("ADD NEW STUDENT");
		mnNewMenu_2_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem2_1 = new JMenuItem("ADD NEW COURSES");
		mnNewMenu_2_1.add(mntmNewMenuItem2_1);
		
		JMenu viewStudent = new JMenu("ViewStudent");
		viewStudent.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		menuBar.add(viewStudent);
		
		JMenuItem viewstd = new JMenuItem("View Student");
		viewStudent.add(viewstd);
		viewstd.setMaximumSize(new Dimension(600, 100));
		//viewstd.setVerifyInputWhenFocusTarget(false);
		//viewstd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UNDEFINED, 0));
		viewstd.setHorizontalAlignment(SwingConstants.LEFT);
		viewstd.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		viewstd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try {
					getStudent();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblWelcome = new JLabel("WELCOME<###########>");
		lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblWelcome.setText("welcome "+usernamearea);

		lblWelcome.setBounds(63, 69, 354, 65);
		contentPane.add(lblWelcome);
		
		JLabel lblTotalNumberOf_1 = new JLabel("TOTAL NUMBER OF COURSES = "+MyFunction.countData("course"));
		lblTotalNumberOf_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblTotalNumberOf_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTotalNumberOf_1.setBounds(0, 912, 378, 50);
		//lblTotalNumberOf_1.setText("TOTAL NUMBER OF COURSES = "+MyFunction.countData("user"));
		//System.out.println(MyFunction.countData("user"));
		contentPane.add(lblTotalNumberOf_1);
		
		JLabel icon_label = new JLabel("New label");
		icon_label.setForeground(new Color(60, 179, 113));
		icon_label.setMinimumSize(new Dimension(20, 20));
		icon_label.setMaximumSize(new Dimension(20, 20));
		icon_label.setIcon(new ImageIcon("C:\\Users\\MONIKA\\Documents\\logo.jpg"));
	
		
		icon_label.setBounds(10, 61, 56, 73);
		//icon_label.setIcon((Icon) Toolkit.getDefaultToolkit().getImage("C:\\Users\\MONIKA\\Downloads\\logo (1).jpg"));
		contentPane.add(icon_label);
		
		JButton addstd = new JButton("ADD STUDENT");
		addstd.setIcon(new ImageIcon(DataFrame.class.getResource("/Connections/icons/addstd.jpg")));
	    addstd.setBackground(new Color(240, 240, 240));
	    addstd.setFont(new Font("Times New Roman", Font.BOLD, 18));
	    addstd.setBounds(528, 849, 243, 50);
	    contentPane.add(addstd);
	    addstd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AddStudentForm std=new AddStudentForm();
				std.setVisible(true);
				
			    
				std.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
	    
	    JButton dltstd = new JButton("DELETE STUDENT");
	    dltstd.setIcon(new ImageIcon(DataFrame.class.getResource("/Connections/icons/deltestd.png")));
	    dltstd.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    dltstd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				deleteStudentForm std=new deleteStudentForm();
				std.setVisible(true);
				std.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
	   // getStudent(contentPane);
	    dltstd.setHorizontalAlignment(SwingConstants.LEFT);
	    dltstd.setFont(new Font("Times New Roman", Font.BOLD, 18));
	    dltstd.setBackground(SystemColor.menu);
	    dltstd.setBounds(861, 849, 225, 50);
	    contentPane.add(dltstd);
	    
	    JButton uptstd = new JButton("UPDATE STUDENT");
	    uptstd.setIcon(new ImageIcon(DataFrame.class.getResource("/Connections/icons/editstd.jpg")));
	    uptstd.setFont(new Font("Times New Roman", Font.BOLD, 18));
	    uptstd.setBackground(SystemColor.menu);
	    uptstd.setBounds(1182, 849, 230, 50);
	    contentPane.add(uptstd);
	    
	    uptstd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				UpdateStudentForm std=new UpdateStudentForm();
				std.setVisible(true);
				std.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
	    JLabel lblTotalNumberOf = new JLabel("TOTAL NUMBER OF STUDENTS = "+MyFunction.countData("student"));
	    lblTotalNumberOf.setBounds(368, 912, 393, 50);
	    contentPane.add(lblTotalNumberOf);
	    lblTotalNumberOf.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    //lblTotalNumberOf.setText(" = 1");
	    
	    JButton rfreshbtn = new JButton("Refresh");
	    rfreshbtn.setIcon(new ImageIcon(DataFrame.class.getResource("/Connections/icons/ref.jpg")));
	    rfreshbtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	    rfreshbtn.setBounds(1728, 84, 141, 44);
	    contentPane.add(rfreshbtn);
	    
	    JLabel tableName = new JLabel("STUDENT DETAIL");
	    tableName.setIcon(new ImageIcon(DataFrame.class.getResource("/Connections/icons/STDICON.jpg")));
	    tableName.setBackground(Color.WHITE);
	    tableName.setFont(new Font("Times New Roman", Font.BOLD, 40));
	    tableName.setHorizontalAlignment(SwingConstants.CENTER);
	    tableName.setBounds(581, 81, 868, 53);
	    contentPane.add(tableName);
	    
	    JLabel lblNewLabel_2 = new JLabel("ENTER DETAILS");
	    lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
	    lblNewLabel_2.setBounds(1248, 197, 545, 65);
	    contentPane.add(lblNewLabel_2);
	    
	    Button gettable = new Button("Get Data");
	    gettable.setFont(new Font("Times New Roman", Font.PLAIN, 25));
	    gettable.setForeground(Color.BLACK);
	    gettable.setBounds(1440, 614, 160, 39);
	    contentPane.add(gettable);
	    
	    final String week[]= { "IT", "CSE", "ECE", "ME", "CE", "Saturday", "Sunday"};

//create list
	    
	    
	    final JList listdep ;
	    listdep = new JList(week);
	    listdep.setSelectedIndex(0);
	    listdep.setBorder(new TitledBorder(null, "department", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.BLACK));
	    listdep.setFont(new Font("Times New Roman", Font.PLAIN, 17));
	    listdep.setBounds(1215, 329, 218, 226);//listdep.setSelectedIndex(0);
	    contentPane.add(listdep);
	    
	    final String sem[]= { "1", "2", "3", "4", "5", "6", "7","8"};
	    final JList listsem;
	    listsem = new JList(sem);
	    listsem.setSelectedIndex(0);
	    listsem.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Semester", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
	    listsem.setFont(new Font("Times New Roman", Font.PLAIN, 17));
	    listsem.setBounds(1556, 329, 218, 226);//listsem.setSelectedIndex(0);
	    contentPane.add(listsem);
	    
	    JButton logout = new JButton("Log out");
	    logout.setIcon(new ImageIcon(DataFrame.class.getResource("/Connections/icons/logout.jpg")));
	    logout.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	    logout.setBounds(1577, 86, 141, 44);
	    contentPane.add(logout);
	    
	    logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				LoginForm login;
				try {
					login=new LoginForm();
					login.setVisible(true);
					//login.setExtendedState(jframe.MAXIMIZED_BOTH);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); 
	    
	    gettable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int dept=listdep.getSelectedIndex();
				int id=listsem.getSelectedIndex();
				//dispose();
				DataFrame jframe;
				try {
					jframe = new DataFrame(usernamearea);
					getStudent(week[dept],sem[id]);
					jframe.setVisible(true);
					jframe.setExtendedState(jframe.MAXIMIZED_BOTH);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	    
	    rfreshbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				DataFrame jframe;
				try {
					jframe = new DataFrame(usernamearea);
					//getStudent();
					contentPane.setVisible(true);
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
