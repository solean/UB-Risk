package code;

import java.util.ArrayList;

import javax.swing.JOptionPane;
/**
 * class Player is responsible for holding each player's name, the Depts of which the player is chair,
 * and an Arraylist containing the Students "onhand" and an ArrayList of Student "inField"
 * 
 * Class Invariants:
 * - name of the player
 * - amount of students player owns on GameBoard
 * - amount of students ready to be placed at the start of each turn
 * - the departments that the Player is chair of
 * 
 * Instance Variables:
 * - _name holds the Player's name
 * - _chairs holds the departments the player is chair of
 * - _onhand holds the amount of players to be dispursed at the start of each turn
 * - _inField holds the amount of players that are on the GameBoard
 * 
 * @author Dom,Patrick,Chris,Rafael
 *
 */
public class Player {
	
	private String _name;
	private ArrayList<Dept> _chairs = new ArrayList<Dept>();
	private int _onhand;
	private ArrayList<Student> _inField;
	private boolean _firstTurn;
	

	public Player(String name){
		_name = name;
		_inField = new ArrayList<Student>();
		_firstTurn = true;
		if(_firstTurn){
			_onhand = 3;
		}
	}
	/**
	 * Sets the _firstTurn to false.
	 */
	public void setFirstTurnFalse(){
		_firstTurn = false;
	}
	/**
	 * Returns if its the Player's first turn.
	 * @return true (if first turn)
	 */
	public boolean getFirstTurn(){
		return _firstTurn;
	}
	/**
	 * Return the Players name.
	 * @return _name (the players name)
	 */
	public String getName(){
		return _name;
	}
	
	/**
	 * isDean(School school, GameBoard gb)
	 * 
	 * Checks if the Player has the necessary departments to be considered the dean of the respective school.
	 * 
	 * @param school (School object)
	 * @param gb (GameBoard object)
	 * @return boolean true or false
	 */
	
	public boolean isDean(School school, GameBoard gb){
		if (school.getName().equals("Arts")) {
			if (_chairs.contains(gb.getArts().getDepts()[0]) && _chairs.contains(gb.getArts().getDepts()[1]) && _chairs.contains(gb.getArts().getDepts()[2]) && _chairs.contains(gb.getArts().getDepts()[3])) {
				return true;
			}
		}
		else if (school.getName().equals("Sciences")) {
			if (_chairs.contains(gb.getSciences().getDepts()[0]) && _chairs.contains(gb.getSciences().getDepts()[1]) && _chairs.contains(gb.getSciences().getDepts()[2]) && _chairs.contains(gb.getSciences().getDepts()[3])) {
				return true;
			}
		}
		else if (school.getName().equals("Humanities")) {
			if (_chairs.contains(gb.getHumanities().getDepts()[0]) && _chairs.contains(gb.getHumanities().getDepts()[1]) && _chairs.contains(gb.getHumanities().getDepts()[2]) && _chairs.contains(gb.getHumanities().getDepts()[3])) {
				return true;
			}
		}
		else if (school.getName().equals("Engineering")) {
			if (_chairs.contains(gb.getEngineering().getDepts()[0]) && _chairs.contains(gb.getEngineering().getDepts()[1]) && _chairs.contains(gb.getEngineering().getDepts()[2]) && _chairs.contains(gb.getEngineering().getDepts()[3])) {
				return true;
			}
		}
		else if (school.getName().equals("Law")) {
			if (_chairs.contains(gb.getLaw().getDepts()[0]) && _chairs.contains(gb.getLaw().getDepts()[1]) && _chairs.contains(gb.getLaw().getDepts()[2]) && _chairs.contains(gb.getLaw().getDepts()[3])) {
				return true;
			}
		}
		else if (school.getName().equals("Medicine")) {
			if (_chairs.contains(gb.getMedicine().getDepts()[0]) && _chairs.contains(gb.getMedicine().getDepts()[1]) && _chairs.contains(gb.getMedicine().getDepts()[2]) && _chairs.contains(gb.getMedicine().getDepts()[3])) {
				return true;
			}
		}
		return false;
		
	}
	/**
	 * Returns the depts in which the player is a chair.
	 * @return _chairs
	 */
	public ArrayList<Dept> getChairs(){
		return _chairs;
	}
	/**
	 * Adds dept in which the player is a chair
	 * @param d (dept that the player is chair of)
	 */
	public void addChair(Dept d) {
		_chairs.add(d);
	}
	/**
	 * Removes a dept in which the player is no longer a chair of.
	 * @param d (dept that the player is no longer chair of)
	 */
			
	public void removeChair(Dept d) {
		_chairs.remove(d);
	}
	
	/**
	 * studentMovement(Dept origin, Dept dest, int amountToMove)
	 * 
	 * Asks the player to make a decision on moving their students to an adjacent department.
	 * 
	 * @param origin (Dept)
	 * @param dest
	 * @param amountToMove
	 */
	public void studentMovement(Dept origin, Dept dest, int amountToMove){
		if (countInDept(origin) < amountToMove) {
			JOptionPane.showMessageDialog(null, "You do not have that many students in the Department of " + origin.getName());
			throw new IllegalArgumentException("You do not have that many students in the " + origin.getName() + " department");
		}
		
		if (!origin.isAdjacent(dest)) {
			JOptionPane.showMessageDialog(null, "These departments are not adjacent, so you can't move students between them.");
			throw new IllegalArgumentException("These departments are not adjacent, so you can't move students between them.");
		}
		
		for(int i = 0; i < amountToMove; i++) {
			Student st = _inField.get(i);
			if (st.getDept().equals(origin)) {
				if (!st.getMoved()) {
					st.setDept(dest);
					st.setMoved(true);
				}
			}
		}
	}
	/**
	 * countInDept(Dept dept)
	 * 
	 * Returns the amount of students this Player owns in a specified department.
	 * 
	 * @param dept
	 * @return count
	 */
	
	public int countInDept(Dept dept) {
		int count = 0;
		for(Student s:dept.getStudents()){
			if(s.getLoyalty().equals(this))
				count ++;
		}
		return count;

	}
	
	/**
	 * getMovableStudents(Dept d)
	 * 
	 * Returns the amount of students in a specified department able to be moved by the Player.
	 * 
	 * @param d
	 * @return count (int)
	 */
	
	public int getMovableInDept(Dept d){
		int count = 0;
		for(Student s:d.getStudents()){
			if(s.getLoyalty().equals(this) && !s.getMoved()){
				count ++;
			}
		}
		return count;
	}
	/**
	 * Returns the number of new Students that can be added to the field.
	 * @return _onHand
	 */
	public int getOnhand() {
		return _onhand;
	}
	/**
	 * Resets all of the Players students to movable.
	 */
	public void resetMovable(){
		for(Student s: getInField()){
			s.setMoved(false);
		}
	}
	/**
	 * Adds 'x' amount of players to be added to the field.
	 * @param x
	 */
	public void addOnHand(int x){
		_onhand = _onhand + x;
	}
	/**
	 * Removes 'x' amount of players from _onHand.
	 * @param x
	 */
	public void removeOnHand(int x){
		_onhand = _onhand - x;
	}
	/**
	 * Adds a player to the ArrayList that keeps track of all of the placed students.
	 * @param s
	 */
	public void addInField(Student s){
		_inField.add(s);
	}
	/**
	 * Returns all of the players placed students.
	 * @return _inField
	 */
	public ArrayList<Student> getInField() {
		return _inField;
	}
	/**
	 * Sets the _inField variable to an ArrayList<Student> a.
	 * @param a
	 */
	public void setinField(ArrayList<Student> a){
		_inField = a;
	}

	
}
