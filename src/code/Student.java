package code;


/**
 * 
 * Class Student is responsible for knowing which Player they are loyal to, which department they are in,
 * and keeps track of whether or not the student has been moved per turn.
 * 
 * Class Invariants:
 * - the loyalty of the student, which will reflect the Player to which the student belongs to
 * - the departments for which the Student belongs to
 * - the student's "moved" status, which will be false at the start of each turn and should be changed to
 * true once moved
 * 
 * Instance Variables:
 * - _loyalty houses the loyalty of the student
 * - _dept houses which department the student belongs to
 * - _moved houses a boolean which tells whether or not the student has moved during the turn
 * 
 * @author Dom,Patrick,Chris,Rafael
 */

public class Student {
	private Player _loyalty; //what player it belongs to
	private Dept _dept; //what dept it is in
	private boolean _moved;
	
	public Student(Player loyal, Dept d){
		_loyalty = loyal;
		_dept = d;
		_moved = false;
	}
	/**
	 * Returns some basic information about the student
	 * @return (a string of basic information)
	 */
	public String toString(){
		return "My loyalty is to " + _loyalty.getName() + ". My major is " +
					_dept.getName()+ "";
	}
	/**
	 * Returns if a student has moved to an adjacent dept.
	 * @return true (if has moved)
	 */
	public boolean getMoved() {
		return _moved;
	}
	/**
	 * Sets _moved to a boolean value bool.
	 * @param bool
	 */
	public void setMoved(boolean bool) {
		_moved = bool;
	}
	/**
	 * Returns the Player that this student belongs to.
	 * @return _loyalty
	 */
	public Player getLoyalty(){
		return _loyalty;
	}
	/**
	 * Sets the owner of this student to Player newLoyalty.
	 * @param newLoyalty
	 */
	public void setLoyalty(Player newLoyalty){
		_loyalty = newLoyalty;
	}
	/**
	 * Returns the dept that this student is currently in.
	 * @return _dept
	 */
	public Dept getDept(){
		return _dept;
	}
	/**
	 * Sets the dept location to Dept d.
	 * @param d
	 */
	public void setDept(Dept d) {
		_dept = d; 
	}
	
}