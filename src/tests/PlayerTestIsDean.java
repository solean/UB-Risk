package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Dept;
import code.GameBoard;
import code.Player;
import code.School;

public class PlayerTestIsDean {

	

	@Test
	public void test(){
		Player p = new Player("P");
		School s = new School("Arts");
		GameBoard gb = new GameBoard();
		System.out.println(s.getDepts().length);
 		for(Dept d:s.getDepts()){
			d.setChair(p);
			p.addChair(d);
		}
 		for(Dept d:p.getChairs()){
 			System.out.println(d.getName());
 		}
 		boolean expected=true;
 		boolean actual=p.isDean(s, gb);
 		assertTrue(actual==expected);
 		
		
	}
}
