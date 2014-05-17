package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Dept;
import code.GameBoard;

public class GameBoardTest {

	@Test
	public void test(){
		GameBoard gb =new GameBoard();
		Dept[] da= gb.getDepts();
		String expected = "Music";
		String actual = da[0].getName();
		assertTrue(actual==expected);
	}
}
