package code;

import java.util.ArrayList;

/**
 * GameBoard is responsible for initializing all Dept objects 
 * in its Constructor
 * 
 * @author Dom,Chris,Patrick,Rafael
 *
 */
public class GameBoard {
	
	private School _arts = new School("Arts");
	private School _sciences = new School("Sciences");
	private School _engineering = new School("Engineering");
	private School _humanities = new School("Humanities");
	private School _law = new School("Law");
	private School _medicine = new School("Medicine");
	private boolean _foundPresident = false;
	
	public ArrayList<School> _schools = new ArrayList<School>();
	
	public GameBoard(){

		setUp();
		
	}
	/**
	 * Mutator method that sets _foundPresident to true.
	 */
	public void hasFoundPresident(){
		_foundPresident = true;
	}
	/**
	 * Accessor method that returns if a president has been found.
	 * @return _foundPresident (if a president has been found)
	 */
			
	public boolean getFoundPresident(){
		return _foundPresident;
	}
	
	/**
	 * getDepts()
	 * 
	 * An accessor method used to retrieve a specific Dept object.
	 * 
	 * @return temp (an Array of Dept objects)
	 */
	
	public Dept[] getDepts(){
		Dept[] temp = new Dept[24];
		int i = 0;
		for(Dept d:_arts.getDepts()){
			temp[i] = d;
			i ++;
		}
			
		for(Dept d:_sciences.getDepts()){
			temp[i] = d;
			i ++;
		}
		for(Dept d:_law.getDepts()){
			temp[i] = d;
			i ++;
		}
		for(Dept d:_humanities.getDepts()){
			temp[i] = d;
			i ++;
		}
		for(Dept d:_engineering.getDepts()){
			temp[i] = d;
			i ++;
		}
		for(Dept d:_medicine.getDepts()){
			temp[i] = d;
			i ++;
		}
		
		return temp;
	}
	/**
	 * setUp()
	 * 
	 * Puts each department in their respective schools upon the start of the game.
	 */
	
	public void setUp(){
		Dept[] temp = new Dept[4];
		temp[0] = new Dept("Music");
	    temp[1] = new Dept("Theatre");
	    temp[2] = new Dept("Dance");
	    temp[3] = new Dept("Visual Arts");
		_arts.addDept(temp);
		temp = new Dept[4];
		temp[0] = new Dept("Biology");
	    temp[1] = new Dept("Chemistry");
	    temp[2] = new Dept("Physics");
	    temp[3] = new Dept("Mathematics");
		_sciences.addDept(temp);
		temp = new Dept[4];
	
		temp[0] = new Dept("History");
	    temp[1] = new Dept("Linguistics");
	    temp[2] = new Dept("Literature");
	    temp[3] = new Dept("Religion");
		_humanities.addDept(temp);
		temp = new Dept[4];

		temp[0] = new Dept("Computer");
	    temp[1] = new Dept("Electrical");
	    temp[2] = new Dept("Mechanical");
	    temp[3] = new Dept("Civil");
		_engineering.addDept(temp);
		temp = new Dept[4];

		temp[0] = new Dept("Business");
	    temp[1] = new Dept("Family");
	    temp[2] = new Dept("Criminal");
	    temp[3] = new Dept("Immigration");
		_law.addDept(temp);
		temp = new Dept[4];
		temp[0] = new Dept("Anesthesia");
	    temp[1] = new Dept("Otolaryngology");
	    temp[2] = new Dept("Pathology");
	    temp[3] = new Dept("Pediatrics");
		_medicine.addDept(temp);
		
		
		_schools.add(_arts);
		_schools.add(_sciences);
		_schools.add(_humanities);
		_schools.add(_engineering);
		_schools.add(_law);
		_schools.add(_medicine);
		
		
	}
	/**
	 * Returns all of the schools.
	 * @return _schools
	 */
			
	public ArrayList<School> getSchools(){
		return _schools;
	}
	
	/**
	 * Returns the school Art.
	 * @return _arts
	 */
	public School getArts(){
		return _arts;
	}
	/**
	 * Returns the school Science.
	 * @return _sciences
	 */
	public School getSciences(){
		return _sciences;
	}
	/**
	 * Returns the school Law.
	 * @return _law
	 */
	public School getLaw(){
		return _law;
	}
	/**
	 * Return the school Humanities.
	 * @return _hamnities
	 */
	public School getHumanities(){
		return _humanities;
	}
	/**
	 * Return the school Medicine.
	 * @return _medicine
	 */
	public School getMedicine(){
		return _medicine;
	}
	/**
	 * Return the school of engineering.
	 * @return _engineering
	 */
	public School getEngineering(){
		return _engineering;
	}
	
	
	
}