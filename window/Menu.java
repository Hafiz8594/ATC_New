import ats.window.Game;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.io.IOException;

public class Menu extends JFrame implements ActionListener{

	
	private JMenuItem jmiGrades;
	private JMenuItem jmiSim;
	private JMenuItem jmiEdit;
	private JMenuItem jmiExit;
	public ShowGrades sg;
	public Menu(Person p){
		
		setTitle("Menu Demo");
		setSize(400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		// store all menu options in a menu bar.
		
		JMenuBar jmb = new JMenuBar();
		// jmb typically contains JMenu objects
		// JMenu objects may contain MenuItem objects or other JMenu objects
		
		JMenu jmFile = new JMenu("File");
		
		jmiGrades = new JMenuItem("Grades");
		jmiSim = new JMenuItem("Simulations");
		jmiEdit = new JMenuItem("Edit");
		jmiExit = new JMenuItem("Exit");
		
		// add File items to JMenu
		switch(p.getlevel()){
			case 1:
				jmFile.add(jmiSim);
				break;
			case 2:
				jmFile.add(jmiGrades);
				break;
			case 3:
				jmFile.add(jmiSim);
				jmFile.add(jmiGrades);
				jmFile.add(jmiEdit);
				break;
		}
		
		jmFile.add(jmiExit);
		
		
		
		
		// add all JMenu objects to the menu bar
		
		jmb.add(jmFile);
		
		setJMenuBar(jmb);
		
		//all JMenu Items should trigger events.
		jmiGrades.addActionListener(this);
		jmiSim.addActionListener(this);
		jmiExit.addActionListener(this);
		jmiExit.addActionListener(this);
		
		
		
		setVisible(true);
	}
	
	// handles all events being triggered
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("Edit"))
			System.exit(0);
		else if(ae.getActionCommand().equals("Simulations")){
                    Game game = new Game();        
                    new ats.window.Window("ATS Prototype", game);
                }
		else if(ae.getActionCommand().equals("Grades"))
			sg=new ShowGrades();
		else 
			System.exit(0);
	}
	
}
