package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Dept;
import code.GameDriver;
import code.Player;

public class GameDriverTestGetNumberOfDeanships {
	
	@Test
	public void test0(){
		GameDriver gd = new GameDriver();
		Dept[] depts = gd._gb.getDepts();
		Player p = gd.getCurrentPlayer();
		for(int i=0;i<depts.length;i++){
		p.addChair(depts[i]);
		}
		int expected = 6;
		int actual = gd.getNumberOfDeanships();
		assertTrue(actual==expected);
	}
	
	@Test
	public void test1(){
		GameDriver gd = new GameDriver();
		Dept[] depts = gd._gb.getDepts();
		Player p = gd.getCurrentPlayer();
		int expected = 0;
		int actual = gd.getNumberOfDeanships();
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
		int expected = 1;
		int actual = gd.getNumberOfDeanships();
		assertTrue(actual==expected);
	}

}
