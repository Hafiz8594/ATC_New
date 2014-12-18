//
//import java.net.*;
//import java.util.*;
//import java.io.*;
//import java.awt.*;
//import javax.swing.*;
//
//import java.awt.event.*;
//
////Login GUI to attempt password connections
//
//public class Login extends JFrame implements ActionListener {
//
//	private JTextField username;
//	private JTextField password;
//	private JButton login;
//	
//	private JLabel uLabel;
//	private JLabel pLabel;
//	public ArrayList<Person> copy;
//
//	public Login(ArrayList<Person>p){
//		
//		makeArray(p);
//		setSize(300,200);
//		setTitle("Simulator");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(null);
//		setLocationByPlatform(true);
//		getContentPane().setBackground(Color.white);
//
//		uLabel = new JLabel("Username");
//		uLabel.setBounds(40,30,80,30);
//
//		pLabel = new JLabel("Password");
//		pLabel.setBounds(40,55,80,30);
//
//		add(uLabel);
//		add(pLabel);
//
//		username = new JTextField(20);
//		username.setBounds(130,37,110,17);
//
//		password = new JTextField(20);
//		password.setBounds(130,63,110,17);
//
//		add(username);
//		add(password);
//
//		login = new JButton("Login");
//		login.setBounds(90,120,100,15);
//		login.addActionListener(this);
//
//		add(login);
//
//		setVisible(true);
//	}
//
//	public void actionPerformed(ActionEvent ae){
//		
//		if(copy.isEmpty()){
//			JOptionPane.showMessageDialog(null, "No Current Users. Please Register.","EMPTY",JOptionPane.ERROR_MESSAGE);
//			return;
//		}
//		else if(ae.getActionCommand().equals("Login")){
//			if(username.getText().equals("")|| password.getText().equals("")){
//				JOptionPane.showMessageDialog(null, "You must fill in all fields!","*Retry*",JOptionPane.ERROR_MESSAGE);
//			}
//			else{
//				for(int i=0;i<copy.size();i++){
//					if(copy.get(i).getName().equals(username.getText())){
//						boolean failed=true;
//						while(failed){
//							if(copy.get(i).getPassword().equals(password.getText())){
//								JOptionPane.showMessageDialog(null, "Logging in","Success",JOptionPane.ERROR_MESSAGE);
//								failed=false;
//								this.setVisible(false);
//								Menu m=new Menu();
//								
//							}
//							else{
//								JOptionPane.showMessageDialog(null, "Password Incorrect","Failed",JOptionPane.ERROR_MESSAGE);
//								this.repaint();
//								return;
//							}
//								
//						}
//					}
//						
//					else{
//						JOptionPane.showMessageDialog(null, "Username Not Recognized","Failed",JOptionPane.ERROR_MESSAGE);
//					}
//				}
//			}
//		}		
//	}
//	
//	public ArrayList<Person> getRoster(){
//		return copy;
//	}
//	
//	private void makeArray(ArrayList<Person> i){
//		for(Person p: i){
//			copy.add(p);
//		}
//	}
//	
//	public static void main(String[] args)throws IOException{
//		ArrayList<Person>c=new ArrayList<Person>();
//		c.add(new Person("Sam","Cheng", 1));
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//			new Login(c);
//		} catch (Exception e) {
//			// ignore
//		}
//		
//		
//	}
//}
//
//
//
//
