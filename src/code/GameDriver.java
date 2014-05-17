package code;

import java.awt.Frame;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
/**
 * class GameDriver is responsible for initializing all of the other game components and controlling 
 * the flow of the game
 * 
 * Class invariants:
 * _playerCount should always be the number of players in the game
 * _players should always be the ArrayList containing each Player object in the game 
 * 
 * @author Dom
 * @author Pat
 * @author Rafael
 * @author Chris
 *
 */

public class GameDriver {
	//keeps track of rules 
	//makes gameboard
	//winElection() method must make all students in the dept set to the winning player
	
	//to start game:
	// 1.prompt for number of players 2 -20
	// 2.make a for loop that prompts for each players name
	// 3.figure out how to distribute departments
	
	
	//somewhere in here add the initial player distribution

	private int _currentPlayerIndex;

	//private ArrayList<Player> _players = new ArrayList<Player>();
	public GameBoard _gb;
	private ArrayList<Player> _players;
	private DragGUI _g;
	public ArrayList<School> _deanSchools = new ArrayList<School>(); //School for which current player is dean
	public ArrayList<Integer> eliminatedIndexes;
	
	public GameDriver(DragGUI g, String[] args){
		 //set up the player//
	    //String[] names = {"Chris", "Dom", "Pat", "Raf"};
	    //just for testing//
		_players = new ArrayList<Player>();
		_gb = new GameBoard();
		_g = g;
		_g.setGameDriver(this);
		
	    createPlayers(args);
	    eliminatedIndexes = new ArrayList<Integer>();
		_g.updateUI();
		_currentPlayerIndex = 0;
		
	}
	
	public GameDriver(){
		_players=new ArrayList<Player>();
		_players.add(new Player("Rafael"));
		_gb = new GameBoard();
		_currentPlayerIndex=0;
	}
	
	/**
	 * foundEliminated()
	 * 
	 * Checks to see if someone has been eliminated from the game, then removes them.
	 * @return true (if player has been removed)
	 */
	public boolean foundEliminated(){
		for(Player p: _players){
			if(p.getChairs().size() < 1){
				JOptionPane.showMessageDialog(new Frame(),p.getName() + " has been eliminated.");
				eliminatedIndexes.add(_players.indexOf(p));
				_players.remove(p);
				
				
				if(_players.size() == 1)JOptionPane.showMessageDialog(new Frame(), "CONGRATULATIONS! " + _players.get(0).getName() + " has won the game!");
				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * nextTurn()
	 * 
	 * Advances the to the next player and prepares the game for the next turn phase.
	 * 
	 */
	public void nextTurn(){
		if(getCurrentPlayer().getOnhand() == 0){


			if(!getCurrentPlayer().getFirstTurn()){
				getCurrentPlayer().addOnHand(studentsToPlace());
			while(!eliminatedIndexes.contains(_currentPlayerIndex)){
				if(_currentPlayerIndex < _players.size()-1)
						_currentPlayerIndex++;
				else
					_currentPlayerIndex = 0;
			}
				getCurrentPlayer().resetMovable();
				


				for (Dept d : getGameBoard().getDepts()) {
					d.setElectionCalled(false);
				}
			}
			else{
				if(getCurrentPlayer().getFirstTurn()){
					getCurrentPlayer().setFirstTurnFalse();
				}
				getCurrentPlayer().addOnHand(studentsToPlace());
				if(_currentPlayerIndex < _players.size()-1)
					_currentPlayerIndex++;
				else
					_currentPlayerIndex = 0;
				getCurrentPlayer().resetMovable();

				for (Dept d : getGameBoard().getDepts()) {
					d.setElectionCalled(false);
				}
			}
		}
		
	}

	/**
	 * studentsToPlace()
	 * 
	 * Calculates to see how many students the player gets to place based on their owned property.
	 * @return total (all of the new students that can be added)
	 */
	
	public int studentsToPlace(){
		int deanStudents = getNumberOfDeanships() * 10;
		int total = 0;
		int numOfChairsWithDeanship = 0;
		int numOfChairsWithoutDeanship = 0;
		int studentsFromChairsWithoutDeanship = 0;
		int studentsFromChairsWithDeanship = 0;
		
		
		for(Dept chair: getCurrentPlayer().getChairs()){
			numOfChairsWithoutDeanship++;
			if(_deanSchools.size()>0){
				for(School school: _deanSchools){
					if(school.getName().equals(chair.whatSchool(chair).getName())){
						numOfChairsWithDeanship++;
					}
				}
			}			
		}
		numOfChairsWithoutDeanship = numOfChairsWithoutDeanship - numOfChairsWithDeanship;
		
		studentsFromChairsWithoutDeanship = numOfChairsWithoutDeanship * 3;		
		studentsFromChairsWithDeanship = numOfChairsWithDeanship * 5;
		total = deanStudents + studentsFromChairsWithoutDeanship + studentsFromChairsWithDeanship;
		
		return total;
	}
	
	/**
	 * removeAllFromDeanList()
	 * 
	 * Removes every player from the _deanSchools ArrayList.
	 */
	public void removeAllFromDeanList(){
		if(!_deanSchools.isEmpty()){
			for(int i = 0; i < _deanSchools.size(); i++){
				_deanSchools.remove(i);
			}
		}
	}
	/**
	 * getNumberOfDeanships()
	 * 
	 * Calculates and then returns the total number of "deanships" the current player has
	 * @return count (the total number of schools the current player is a dean of)
	 */
	public int getNumberOfDeanships(){
		int count = 0;
		removeAllFromDeanList();
		if(getCurrentPlayer().isDean(_gb.getArts(),_gb)){
			_deanSchools.add(_gb.getArts());
			count ++;
		}
		if(getCurrentPlayer().isDean(_gb.getSciences(),_gb)){
			_deanSchools.add(_gb.getSciences());
			count ++;
		}
		if(getCurrentPlayer().isDean(_gb.getLaw(),_gb)){
			_deanSchools.add(_gb.getLaw());
			count ++;
		}
		if(getCurrentPlayer().isDean(_gb.getHumanities(),_gb)){
			_deanSchools.add(_gb.getHumanities());
			count ++;
		}
		if(getCurrentPlayer().isDean(_gb.getEngineering(),_gb)){
			_deanSchools.add(_gb.getEngineering());
			count ++;
		}
		if(getCurrentPlayer().isDean(_gb.getMedicine(),_gb)){
			_deanSchools.add(_gb.getMedicine());
			count ++;
		}
		return count;
	}
	
	/**
	 * createPlayers(String[] names)
	 * 
	 * createPlayers creates and returns an ArrayList of Player objects
	 * @param names 
	 * @return
	 */
	public void createPlayers(String[] names) {
		for(int i = 0; i<names.length; i++) {
			_players.add(new Player(names[i]));
		}
		Random rand = new Random();
		ArrayList<Dept> depts = new ArrayList<Dept>();
		for(Dept d : _gb.getDepts()) {
			depts.add(d);
		}
		for (Player p : _players) {
			if (p.getChairs().isEmpty()) {
				int n = rand.nextInt(depts.size());
				Dept randDept = depts.get(n);
				p.addChair(randDept);
				for (Dept d : _gb.getDepts()) {
					if (d.equals(randDept)) {
						d.setChair(p);
					}
				}
				depts.remove(n);
			}
		}
	}
	
	/**
	 * wonElection(Player p, Dept d)
	 * 
	 * Returns if Player p wins an election in Department d.
	 * @param p (the player calling the election)
	 * @param d (the department in which the election is called)
	 * @return true (if Player p wins the election)
	 */
	
	public boolean wonElection(Player p, Dept d){
		
		if (p.countInDept(d) == 0) {
			JOptionPane.showMessageDialog(null, "You do not have any students in this department so you can not call an election here.");
			throw new IllegalArgumentException("You do not have any students in this department so you can not call an election here.");
		}
		if (p.getChairs().contains(d)) {
			JOptionPane.showMessageDialog(null, "You can't call an election here since you are already the Chair of this department.");
			throw new IllegalArgumentException("You can't call an election here since you are already the Chair of this department.");
		}
		if (d.getElectionCalled()) {
			JOptionPane.showMessageDialog(null, "You can't call an election here since you have already called one this turn.");
			throw new IllegalArgumentException("You can't call an election here since you have already called one this turn.");
		}
		
		Random rand = new Random();
		int yesVotes = 0;
		for(Student pl:d.getStudents()){
			if(pl.getLoyalty().equals(p)){
				if(rand.nextInt(100) + 1 < 66){
					yesVotes ++;
				}
			}
			else{
				if(rand.nextInt(100) + 1 >=66){
					yesVotes ++;
				}
			}		
		}
		
		d.setElectionCalled(true);
		
		if(yesVotes >= d.getStudents().size()/2){
			d.getChair().removeChair(d);
			p.addChair(d); d.setChair(p);
			if (p.isDean(d.getSchool(), _gb)) {
				JOptionPane.showMessageDialog(null, getCurrentPlayer().getName() + " has won the election in " + d.getName() + 
						" and has become Chair of the Department. " + getCurrentPlayer().getName() + " has also become Dean of the School of " + d.whatSchool(d).getName() + ".");
				//sets loyalty of all students in school to player
				Dept[] schoolDepts = d.getSchool().getDepts();
				for (Dept i : schoolDepts) {
					for (Student s : i.getStudents()) {
						s.setLoyalty(p);
					}
				}

			}
			else {
				//if player doesn't become dean, only set loyalty of students in just this department to player
				for (Student s : d.getStudents()) {
					s.setLoyalty(p);
				}
				JOptionPane.showMessageDialog(null, getCurrentPlayer().getName() + 
						" has won the election in " + d.getName() + " and has assumed the position of Chair of the Department.");
			}
			
			return true;
		}
		JOptionPane.showMessageDialog(null, getCurrentPlayer().getName() + " has lost the election in " + d.getName() 
				+ " and may not call another election in this Department this turn.");
		return false;
	}
	
	
	/**
	 * isPresident(Player p)
	 * 
	 * Returns if Player p is the president.
	 * @param p (the player being checked)
	 * @return true (if Player p is president)
	 */
	public boolean isPresident(Player p) {
		ArrayList<School> schools = _gb.getSchools();
		if (p.isDean(schools.get(0), _gb) && p.isDean(schools.get(1), _gb) && p.isDean(schools.get(2), _gb) && p.isDean(schools.get(3), _gb) && p.isDean(schools.get(4), _gb) && p.isDean(schools.get(5), _gb)) {
			return true;
		}
		return false;
	}
	/**
	 * getAllStudents()
	 * 
	 * Accessor method that returns all of the students currently on the board
	 * @return allStudents (all of the students on the board)
	 */
	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> allStudents = new ArrayList<Student>();
		for (int i = 0; i < _players.size(); i++) {
			Player player = _players.get(i);
			for (int j = 0; j < player.getInField().size(); j++) {
				allStudents.add(player.getInField().get(j));
			}
		}
		return allStudents;
	}
	
	
	public static void main(String[] args){	
		new GameDriver(new DragGUI(), args);
	}
	
	/**
	 * getCurrentPlayer()
	 * 
	 * Returns the current Player based on the variable _currentPlayerIndex.
	 * @return (the current Player)
	 */
	
	public Player getCurrentPlayer(){
		return _players.get(_currentPlayerIndex);
	}
	/**
	 * getGameBoard()
	 * 
	 * Accessor method for the GameBoard
	 * @return _gb (the GameBoard)
	 */
	public GameBoard getGameBoard(){
		return _gb;
	}
	/**
	 * everyoneElsesStudents(Dept dept)
	 * 
	 * Returns everyone else's students in the Department dept except for the current Players.
	 * @param dept (the department in which the students are being counted)
	 * @return count (all of the students that don't belong to the current player in dept)
	 */
	public int everyoneElsesStudents(Dept dept){
		int count = 0;
		for(Player p: _players){
			if(!p.equals(getCurrentPlayer())) count = p.countInDept(dept) + count;
		}
		return count;
	}
	
	
}
