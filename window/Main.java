import java.io.*;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*;

//Login Screen

public class Main extends JFrame implements ActionListener {

	/**
	 * Default Serial ID
	 */
	private Person register;
	private static final long serialVersionUID = 1L;
	private JButton loginButton;
	private JButton registerButton;
	private ArrayList<Person> roster;
	private Login l;
	private int level;
	private String u;
	private String p;
	
	private JLabel userLabel;
	

	public Main(){
		
		roster=new ArrayList<Person>();
		setSize(300,200);
		setTitle("Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocationByPlatform(true);
		getContentPane().setBackground(Color.white);

		userLabel = new JLabel("Welcome to Air Traffic Control Simulation ");
		userLabel.setBounds(20,30,240,30);

		add(userLabel);

		loginButton = new JButton("Login");
		loginButton.setBounds(40,120,90,15);
		loginButton.addActionListener(this);
		
		registerButton = new JButton("Register");
		registerButton.setBounds(140,120,90,15);
		registerButton.addActionListener(this);

		add(loginButton);
		add(registerButton);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae){
		
		if(ae.getActionCommand().equals("Login")){
			if(roster.isEmpty()){
				JOptionPane.showMessageDialog(null, "No Current Users. Please Register.","EMPTY",JOptionPane.ERROR_MESSAGE);
			}
			else{
				Login l=new Login();
				setVisible(false);
			}
		}
		//When the user attempts to register
		else if(ae.getActionCommand().equals("Register")){
			Register r=new Register();		
		}
	}

	public static void main(String[] args)throws IOException{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Main();
		} catch (Exception e) {
			// ignore
		}
		
		
	}
	
	public class Register extends JFrame implements ActionListener{
		
		private static final long serialVersionUID = 1L;
		private JRadioButton user;
		private JRadioButton manager;
		private JRadioButton admin;
		private JTextField username;
		private JTextField password;
		private JTextField password2;
		private JLabel passLabel;
		private JLabel passLabel2;
		private JLabel userLabel;
		private JLabel welcomeLabel;
		private JButton submit;
		
		
		public Register(){
			setSize(300,300);
			setTitle("Simulator");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(null);
			setLocationByPlatform(true);
			getContentPane().setBackground(Color.white);
			
			welcomeLabel = new JLabel("Please Fill Out This Registration Form");
			welcomeLabel.setBounds(70,5,240,30);
			
			userLabel = new JLabel("Enter Full Name");
			userLabel.setBounds(40,30,80,30);

			passLabel= new JLabel("Enter Password");
			passLabel.setBounds(40,55,80,30);
			passLabel2= new JLabel("Confirm Password");
			passLabel2.setBounds(29,80,95,30);
			
			username = new JTextField(20);
			username.setBounds(130,37,110,17);

			password = new JTextField(20);
			password.setBounds(130,63,110,17);
			
			password2 = new JTextField(20);
			password2.setBounds(130,89,110,17);
			
			JPanel typePanel = new JPanel();
			typePanel.setBounds(15,120,100,75);
			typePanel.setLayout(new GridLayout(3,1));
			typePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Security Level"));
			typePanel.setOpaque(false);
			user = new JRadioButton("User");
			manager = new JRadioButton("Manager");
			admin = new JRadioButton("Administrator");
			ButtonGroup typeButtons = new ButtonGroup();
			typeButtons.add(user);
			typeButtons.add(manager);
			typeButtons.add(admin);
			typePanel.add(user);
			typePanel.add(manager);
			typePanel.add(admin);
			
			
			submit = new JButton("Submit");
			submit.setBounds(95,220,70,17);
			
			
			add(welcomeLabel);
			
			add(userLabel);
			add(username);
			
			add(passLabel);
			add(password);
			
			add(passLabel2);	
			add(password2);
			
			add(typePanel);
			submit.addActionListener(this);
			add(submit);
			this.setVisible(true);	
		}
		
		//evaluates the actions on the form
		public void actionPerformed(ActionEvent ae){
			
			//checks the form when submit is clicked
			if(ae.getActionCommand().equals("Submit")){
				//fill out form
				if((username.getText().equals("")|| password.getText().equals("")|| password2.getText().equals(""))||(!(user.isSelected()||manager.isSelected()||admin.isSelected())))
				{
						JOptionPane.showMessageDialog(null, "You must fill in all fields!","*ERROR*",JOptionPane.ERROR_MESSAGE);
				}
				else if(checkRoster(username.getText())){
					JOptionPane.showMessageDialog(null, "You already have an account!","*Duplicate*",JOptionPane.ERROR_MESSAGE);
					setVisible(false);
				}
				//passwords match
				else if(!password.getText().equals(password2.getText()))
				{
						JOptionPane.showMessageDialog(null, "Passwords do not match!","*ERROR*",JOptionPane.ERROR_MESSAGE);
				}
				//generate profile
				else{
					if(admin.isSelected())
						level=3;					
					else if(manager.isSelected())
						level=2;
					else
						level=1;
					u=username.getText();
					p=password.getText();
					roster.add(new Person(u,p,level));
					JOptionPane.showMessageDialog(null, "You are registered. Please log in with your new account","Registration Complete",JOptionPane.ERROR_MESSAGE);
					setVisible(false);
				}
			}
			
		}

		private boolean checkRoster(String text) {
			for(Person p: roster){
				if(p.getName().equals(text))
					return true;
			}
			return false;
		}
		
	}

	//Login GUI to attempt password connections

	public class Login extends JFrame implements ActionListener {

		private static final long serialVersionUID = 1L;
		private JTextField username;
		private JTextField password;
		private JButton login;
		
		private JLabel uLabel;
		private JLabel pLabel;

		public Login(){
			
			setSize(300,200);
			setTitle("Simulator");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(null);
			setLocationByPlatform(true);
			getContentPane().setBackground(Color.white);

			uLabel = new JLabel("Username");
			uLabel.setBounds(40,30,80,30);

			pLabel = new JLabel("Password");
			pLabel.setBounds(40,55,80,30);

			add(uLabel);
			add(pLabel);

			username = new JTextField(20);
			username.setBounds(130,37,110,17);

			password = new JTextField(20);
			password.setBounds(130,63,110,17);

			add(username);
			add(password);

			login = new JButton("Login");
			login.setBounds(90,120,100,15);
			login.addActionListener(this);

			add(login);

			setVisible(true);
		}

		public void actionPerformed(ActionEvent ae){
			
			if(roster.isEmpty()){
				JOptionPane.showMessageDialog(null, "No Current Users. Please Register.","EMPTY",JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if(ae.getActionCommand().equals("Login")){
				if(username.getText().equals("")|| password.getText().equals("")){
					JOptionPane.showMessageDialog(null, "You must fill in all fields!","*Retry*",JOptionPane.ERROR_MESSAGE);
				}
				else{
					for(int i=0;i<roster.size();i++){
						if(roster.get(i).getName().equals(username.getText())){
							boolean failed=true;
							while(failed){
								if(roster.get(i).getPassword().equals(password.getText())){
									JOptionPane.showMessageDialog(null, "Logging in","Success",JOptionPane.ERROR_MESSAGE);
									failed=false;
									this.setVisible(false);
									Menu m=new Menu(roster.get(i));
								}
								else{
									JOptionPane.showMessageDialog(null, "Password Incorrect","Failed",JOptionPane.ERROR_MESSAGE);
									this.repaint();
									return;
								}
									
							}
						}
							
						else{
							JOptionPane.showMessageDialog(null, "Username Not Recognized","Failed",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}		
		}
	}
}