package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Dept;
import code.GameDriver;
import code.Player;

public class GameDriverTestStudentsToPlace {
	
	@Test
	public void test0(){
		GameDriver gd = new GameDriver();
		Dept[] depts = gd._gb.getDepts();
		Player p = gd.getCurrentPlayer();
		
		
		int expected = 0;
		int actual = gd.studentsToPlace();
		assertTrue(actual==expected);
	}
	
	
	@Test
	public void test1(){
		
		GameDriver gd = new GameDriver();
		Dept[] depts = gd._gb.getDepts();
		Player p = gd.getCurrentPlayer();
		
		
		p.addChair(depts[0]);
		
		
		int expected = 3;
		int actual = gd.studentsToPlace();
		assertTrue(actual==expected);
	}
	
	
	@Test
	public void test2(){
		GameDriver gd = new GameDriver();
		Dept[] depts = gd._gb.getDepts();
		Player p = gd.getCurrentPlayer();
		p.addChair(depts[0]);
		p.addChair(depts[1]);
		p.addChair(depts[2]);
		p.addChair(depts[3]);
		int expected = 30;
		int actual =gd.studentsToPlace();
		
		
		
		
		
		assertTrue(actual==expected);
	}
	
	@Test
	public void test3(){
		GameDriver gd = new GameDriver();
		Dept[] depts = gd._gb.getDepts();
		Player p = gd.getCurrentPlayer();
		for(int i = 0; i< depts.length;i++){
			p.addChair(depts[i]);
		}
		int actual = gd.studentsToPlace();
		int expected = 180;
		
		assertTrue(actual==expected);
	}
	
	@Test
	public void test4(){
		GameDriver gd = new GameDriver();
		Dept[] depts = gd._gb.getDepts();
		Player p = gd.getCurrentPlayer();
		for(int i = 0; i < 9;i++){
			p.addChair(depts[i]);
		}
		int actual = gd.studentsToPlace();
		int expected = 63;
		assertTrue(actual==expected);
	}
	
	
	
}
