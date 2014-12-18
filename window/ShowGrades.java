import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Implements a simple text-based gradebook.
 * @author Sam Cheng COSC 439
 *
 */
public class ShowGrades extends JFrame {

	private static final long serialVersionUID = -6254669082841469244L;

	private class Picture extends JPanel {

		
		private static final long serialVersionUID = -6554009805972583032L;
		
		private BufferedImage image;
		private int width, height;

		public Picture(String fname){
			try {
				image = ImageIO.read(new File(fname));
				width = image.getWidth();
				height = image.getHeight();

			} catch (IOException ioe) {
				System.out.println("Could not read in the pic");
				System.exit(0);
			}
		}
		
		public Dimension getPreferredSize() {
			return new Dimension(width,height);
		}
		//this will draw the image
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(image,0,0,this);
		}

	}
	
	private List<Person> students;
	private JList gradeList;
	private JLabel selectedLabel;
	
	//Create the Grades GUI.
	public ShowGrades(){
		students = new ArrayList<Person>();
		readInGrades();
		
		this.setTitle("Grades");
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(450, 300);
		
		Picture bg = new Picture("background.jpg");
		this.add(bg);
		bg.setLayout(new GridLayout(3,1));
		
		JLabel title = new JLabel("Grades:");
		bg.add(title);
		
		SelectionL listener = new SelectionL();
		
		gradeList = new JList();
		gradeList.addListSelectionListener(listener);
		
		DefaultListModel listModel = new DefaultListModel();
		for (Person s: students){
			listModel.addElement(s.getName());
		}
		gradeList.setModel(listModel);
		
		JScrollPane scrollBar = new JScrollPane(gradeList);
		bg.add(scrollBar);
		
		selectedLabel = new JLabel();
		bg.add(selectedLabel);
		
		setVisible(true);
	}
	
	// Read in grades from an existing "grades.txt".
	 
	private void readInGrades(){
		File gradesFile = new File("grades.txt");
		try {
			Scanner gradesReader = new Scanner(gradesFile);
			while (gradesReader.hasNextLine()){
				String name = gradesReader.nextLine();
				int grade = gradesReader.nextInt();
				// handle grades.txt with no EOF whitespace
				if (gradesReader.hasNextLine())
					gradesReader.nextLine();
				students.add(new Person(name,grade));
			}
		} catch (FileNotFoundException e) {
			
			throw new RuntimeException(e);
		}
	}
	
	private class SelectionL implements ListSelectionListener {

		public void valueChanged(ListSelectionEvent arg0) {
			int[] selected = gradeList.getSelectedIndices();
			List<Integer> g = new ArrayList<Integer>();
			for (int i : selected)
				g.add(students.get(i).getGrade());
			double avg = GradeCalc.calculateGrades(g);
			String label;
			if (selected.length==1)
				label="Grade: ";
			else
				label="Average: ";
			label+=String.format("%-3.2f",avg);
			selectedLabel.setText(label);
		}
		
	}
	
	public static void main(String[] args){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// ignore
		}
		new ShowGrades();
	}
	
}
