package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import code.Dept;
import code.GameDriver;
import code.Player;
import code.Student;
public class GameDriverTestWonElection {

	@Test
	public void Test(){
		GameDriver gd = new GameDriver();
		Dept[] depts = gd._gb.getDepts();
		Dept d = depts[0];
		Player p = gd.getCurrentPlayer();
		Player p1 = new Player("Dom");
		gd.getAllStudents().add(p1);
		
		Student s0 = new Student(p,d);
		d.addStudent(s0);
		boolean actual = gd.wonElection(p, d);
		boolean expected = true;
		assertTrue(actual=expected);
		
		
	}
	
	
	@Test
	public boolean Test1(){
		GameDriver gd = new GameDriver();
		Dept[] depts = gd._gb.getDepts();
		Dept d = depts[0];
		Player p = gd.getCurrentPlayer();
		Player p1 = new Player("Dom");
		gd._players.add(p1);
		
		Student s0 = new Student(p,d);
		Student s1 = new Student(p1,d);
	
		d.addStudent(s0);
		d.addStudent(s1);
	
		
		System.out.println(d.getStudents());
		boolean actual = gd.wonElection(p, d);
		boolean expected = false;
		assertTrue(actual==expected);
		
		return gd.wonElection(p, d);
	}
	
	
	

}
