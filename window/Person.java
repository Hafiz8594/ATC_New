
/**
 * Represents a Person
 * @author Sam Cheng COSC 439
 *
 */
public class Person {
	
	private String name;
	private String password;
	private int type;
	private int grade;
	
	public Person(String n, String p, int t){
		name = n;
		password = p;
		type = t;
		grade=-1;
	}
	public Person(String n, int g){
		name = n;
		grade=g;
	}
	
	public String getName(){
		return name;
	}
	
	public String getPassword(){
		return password;
	}
	
	
	public int getGrade(){
		return grade;
	}
	
	public int getlevel(){
		return type;
	}
	
	public void setGrade(int g){
		grade=g;
	}
	
	public String toString(){
		String l="";
		switch(type){
			case 3:
				l="Admin";
				break;
			case 2:
				l="Manager";
				break;
			default:
				l="User";
		}
		return "Name: " + name + "\nType: " + l;
	}

}
