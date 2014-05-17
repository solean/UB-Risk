package code;


/**
 * 
 * Class School is responsible for housing its name.
 * 
 * Class Invariants:
 * - the School's name
 * 
 * Instance Variables:
 * - _name houses the name of the School
 * 
 * @author Dom,Patrick,Chris,Rafael
 *
 */

public class School {
	private String _name;
	private Player _dean;
	private Dept[] _depts;
	
	
	
	public School(String name){
		_name = name;
		_depts = new Dept[4];
	}
	/**
	 * Returns the name of the School.
	 * @return _name
	 */
	public String getName(){
		return _name;
	}
	/**
	 * Returns the dean of the school.
	 * @return _dean
	 */
	public Player getDean(){
		return _dean;
	}
	/**
	 * Sets a the dean to the Player d.
	 * @param d
	 */
	public void newDean(Player d){
		_dean = d;
	}
	
	/**
	 * Returns whether there's a dean in this school.
	 * @return true (if there's a dean)
	 */
	public boolean checkIfDeanExists(){
		if(_dean == (null)){
			return false;
		}
		else{return true;}
	}
	/**
	 * Adds an array of depts that the school owns.
	 * @param d
	 */
	public void addDept(Dept[] d){
		_depts = d;
	}
	/**
	 * Returns an array of depts that the school owns.
	 * @return _depts
	 */
	public Dept[] getDepts(){
		return _depts;
	}
	/**
	 * Returns a string of all the depts this School owns
	 * @return (string of all owned depts)
	 */
	public String toString(){
		return  "_depts[0] + _depts[1] + _depts[2] + _depts [3]";
	}
	
	
}
