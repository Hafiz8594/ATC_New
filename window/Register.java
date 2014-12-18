//
//import java.awt.Color;
//import java.awt.GridLayout;
//import java.awt.event.*;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//import javax.swing.*;
//
//
//public class Register extends JFrame implements ActionListener{
//	
//	private static final long serialVersionUID = 1L;
//	private JRadioButton user;
//	private JRadioButton manager;
//	private JRadioButton admin;
//	private JTextField username;
//	private JTextField password;
//	private JTextField password2;
//	private JLabel passLabel;
//	private JLabel passLabel2;
//	private JLabel userLabel;
//	private JLabel welcomeLabel;
//	private JButton submit;
//	private int level;
//	private String u;
//	private String p;
//	
//	public Register(){
//		setSize(300,300);
//		setTitle("Simulator");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(null);
//		setLocationByPlatform(true);
//		getContentPane().setBackground(Color.white);
//		
//		welcomeLabel = new JLabel("Please Fill Out This Registration Form");
//		welcomeLabel.setBounds(70,5,240,30);
//		
//		userLabel = new JLabel("Enter Full Name");
//		userLabel.setBounds(40,30,80,30);
//
//		passLabel= new JLabel("Enter Password");
//		passLabel.setBounds(40,55,80,30);
//		passLabel2= new JLabel("Confirm Password");
//		passLabel2.setBounds(29,80,95,30);
//		
//		username = new JTextField(20);
//		username.setBounds(130,37,110,17);
//
//		password = new JTextField(20);
//		password.setBounds(130,63,110,17);
//		
//		password2 = new JTextField(20);
//		password2.setBounds(130,89,110,17);
//		
//		JPanel typePanel = new JPanel();
//		typePanel.setBounds(15,120,100,75);
//		typePanel.setLayout(new GridLayout(3,1));
//		typePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Security Level"));
//		typePanel.setOpaque(false);
//		user = new JRadioButton("User");
//		manager = new JRadioButton("Manager");
//		admin = new JRadioButton("Administrator");
//		ButtonGroup typeButtons = new ButtonGroup();
//		typeButtons.add(user);
//		typeButtons.add(manager);
//		typeButtons.add(admin);
//		typePanel.add(user);
//		typePanel.add(manager);
//		typePanel.add(admin);
//		
//		
//		submit = new JButton("Submit");
//		submit.setBounds(95,220,70,17);
//		
//		
//		add(welcomeLabel);
//		
//		add(userLabel);
//		add(username);
//		
//		add(passLabel);
//		add(password);
//		
//		add(passLabel2);	
//		add(password2);
//		
//		add(typePanel);
//		submit.addActionListener(this);
//		add(submit);
//		this.setVisible(true);	
//	}
//	
//	//evaluates the actions on the form
//	public void actionPerformed(ActionEvent ae){
//		
//		//checks the form when submit is clicked
//		if(ae.getActionCommand().equals("Submit")){
//			//fill out form
//			if((username.getText().equals("")|| password.getText().equals("")|| password2.getText().equals(""))||(!(user.isSelected()||manager.isSelected()||admin.isSelected())))
//			{
//					JOptionPane.showMessageDialog(null, "You must fill in all fields!","*ERROR*",JOptionPane.ERROR_MESSAGE);
//			}
//			//passwords match
//			else if(!password.getText().equals(password2.getText()))
//			{
//					JOptionPane.showMessageDialog(null, "Passwords do not match!","*ERROR*",JOptionPane.ERROR_MESSAGE);
//			}
//			//generate profile
//			else{
//				if(admin.isSelected())
//					setLevel(3);					
//				else if(manager.isSelected())
//					setLevel(2);
//				else
//					setLevel(1);
//				setU(username.getText());
//				setP(password.getText());
//				
//				JOptionPane.showMessageDialog(null, "You are registered. Please log in with your new account","Registration Complete",JOptionPane.ERROR_MESSAGE);
//				setVisible(false);
//			}
//		}
//		
//	}
//	
//	private void setU(String x){
//		u=x;
//	}
//	private void setP(String y){
//		p=y;
//	}
//	private void setLevel(int z){
//		level=z;
//	}
//	public Person getInfo(){
//		return new Person(u,p,level);
//	}
//}
