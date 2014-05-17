package code;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;
/**
 * Dept is an object class that represents the departments of a school.
 * @author Patrick,Dom,Chris,Rafael
 *
 */
public class Dept {
	private String _name;
	private School _school;
	private Player _chair;
	private ArrayList<Student> _studentsInDept;
	private boolean _electionCalled;
	
	public Dept(String name){
		_name = name;
		_school = whatSchool(this); //this might not work or might have weird errors
		_studentsInDept = new ArrayList<Student>();
		_chair = new Player("no chair");
		_electionCalled = false;
	}
	
	/**
	 * isAdjacent(Dept dept)
	 * 
	 * Puts department names in one array and their adjacent
	 * ones in another. Then uses a for loop to check if the
	 * desired department is adjacent using the indexes of the
	 * arrays.
	 * @param dept
	 * @return
	 */
	public boolean isAdjacent(Dept dept){
		String[] oneSide = new String[7];
		String[] otherSide = new String[7];
		oneSide[0] = "Music";
		otherSide[0] = "Physics";
		oneSide[1] = "Visual Arts";
		otherSide[1] = "Mechanical";
		oneSide[2] = "Linguistics";
		otherSide[2] = "Computer";
		oneSide[3] = "Religion";
		otherSide[3] = "Mathematics";
		oneSide[4] = "Chemistry";
		otherSide[4] = "Anesthesia";
		oneSide[5] = "Civil";
		otherSide[5] = "Business";
		oneSide[6] = "Criminal";
		otherSide[6] = "Pathology";
		for(int i = 0; i < oneSide.length; i ++){
			if(oneSide[i].equals(_name))
				if(otherSide[i].equals(dept.getName()))
					return true;
			if(otherSide[i].equals(_name))
				if(oneSide[i].equals(dept.getName()))
					return true;		
		}
		School deptSchool = whatSchool(dept);
		if(deptSchool.getName().equals(_school.getName()))
			return true;
		return false;
	}
	/**
	 * Accessor method for the name of the department.
	 * @return _name (the name of the department)
	 */
	public String getName(){
		return _name;
	}
	/**
	 * Accessor method to see if a election has been called in this department.
	 * @return _electionCalled (whether an election has been called or not.
	 */
	public boolean getElectionCalled() {
		return _electionCalled;
	}
	/**
	 * Set the election called to either true or false.
	 * @param b (a boolean value that is being set to _electionCalled)
	 */
	public void setElectionCalled(boolean b) {
		_electionCalled = b;
	}
	/**
	 * A method that checks what School a Department is apart of.
	 * @param major (the department being checked)
	 * @return (a school that the dept belongs to)
	 */
	public School whatSchool(Dept major){
		if(major.getName().equals("Music")||major.getName().equals("Theatre")||major.getName().equals("Dance")||major.getName().equals("Visual Arts"))
			return new School("Arts");
		if(major.getName().equals("Biology")||major.getName().equals("Chemistry")||major.getName().equals("Physics")||major.getName().equals("Mathematics"))
			return new School("Sciences");
		if(major.getName().equals("History")||major.getName().equals("Linguistics")||major.getName().equals("Literature")||major.getName().equals("Religion"))
			return new School("Humanities");
		if(major.getName().equals("Computer")||major.getName().equals("Electrical")||major.getName().equals("Mechanical")||major.getName().equals("Civil"))
			return new School("Engineering");
		if(major.getName().equals("Business")||major.getName().equals("Family")||major.getName().equals("Criminal")||major.getName().equals("Immigration"))
			return new School("Law");
		if(major.getName().equals("Anesthesia")||major.getName().equals("Otolaryngology")||major.getName().equals("Pathology")||major.getName().equals("Pediatrics"))
			return new School("Medicine");
		return new School("Major Not Found");
	}
	/**
	 * Accessor method for the school that the department belongs to.
	 * @return _school (the school that the dept belongs to)
	 */
	public School getSchool(){
		return _school;
	}
	/**
	 * Adds a student to the _studentsInDept ArrayList.
	 * @param s (the student being added)
	 */
	public void addStudent(Student s){
		_studentsInDept.add(s);
		s.setDept(this);
		s.setMoved(true);
	}
	/**
	 * Removes the first student belonging to Player p from the _studentsInDept ArrayList.
	 * @param p (the desired player)
	 * @return (the student that has been removed)
	 */
	public Student removeStudent(Player p){
		Student temp = null;
		java.util.Iterator<Student> itr = _studentsInDept.iterator();
		while(temp == null && itr.hasNext()){
			Student st = itr.next();
			if(st.getLoyalty().equals(p))
				temp = st;
			
		}
		_studentsInDept.remove(temp);
		return temp;
	}
	/**
	 * Returns all the students in the dept.
	 * @return _studentsInDept (all of the students)
	 */
	public ArrayList<Student> getStudents(){
		return _studentsInDept;
	}
	/**
	 * Returns the chair of the dept.
	 * @return _chair (the chair)
	 */
	public Player getChair(){
		return _chair;
	}
	/**
	 * Adds a new student to the _studentsInDept ArrayList.
	 * @param p
	 * @param d
	 */
	public void addNewStudent(Player p,Dept d){
		Student s = new Student(p,d);
		_studentsInDept.add(s);
		p.addInField(s);
	}
	/**
	 * Returns the total amount of movable students that Player p owns.
	 * @param p (the player)
	 * @return (Player p's movable students)
	 */
	public int getMovableStudents(Player p){
		int count = 0;
		for(Student s:_studentsInDept){
			if(s.getLoyalty().equals(p) && !s.getMoved())
				count ++;
		}
		return count;
	}
	/**
	 * Sets the chair to Player p.
	 * @param p (the new chair)
	 */
			
	public void setChair(Player p) {
		_chair = p;
	}
	/**
	 * Returns the number of students in this dept owned by Player p.
	 * @param p (the desired Player)
	 * @return (the number Player p's students)
	 */
	public int getPlayersStudents(Player p){
		int count = 0;
		for(Student s:_studentsInDept){
			if(s.getLoyalty().equals(p))
				count ++;
		}
		return count;
		
	}
	/**
	 * Returns an ArrayList of all the players that have students in this dept.
	 * @return (ArrayList<Student> of all  the players)
	 */
	public ArrayList<Player> getPlayerList(){
		ArrayList<Player> pl = new ArrayList<Player>();
		for(int i=0;i<_studentsInDept.size();i++){
			Student s = _studentsInDept.get(i);
			if(!pl.contains(s.getLoyalty())){
				pl.add(s.getLoyalty());
			}
		}
		return pl;
	}

}