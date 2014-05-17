package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeptTestsIsAdjacent {

	@Test
	public void testAdjacent0(){
		boolean expected = true;
		boolean actual = new code.Dept("Music").isAdjacent(new code.Dept("Physics"));
		assertTrue("",expected==actual);
	}
	@Test
	public void testAdjacent1(){
		boolean expected = true;
		boolean actual = new code.Dept("Visual Arts").isAdjacent(new code.Dept("Mechanical"));
		assertTrue("",expected==actual);
	}
	@Test
	public void testAdjacent2(){
		boolean expected = true;
		boolean actual = new code.Dept("Linguistics").isAdjacent(new code.Dept("Computer"));
		assertTrue("",expected==actual);
	}
	@Test
	public void testAdjacent3(){
		boolean expected = true;
		boolean actual = new code.Dept("Religion").isAdjacent(new code.Dept("Mathematics"));
		assertTrue("",expected==actual);
	}
	@Test
	public void testAdjacent4(){
		boolean expected = true;
		boolean actual = new code.Dept("Chemistry").isAdjacent(new code.Dept("Anesthesia"));
		assertTrue("",expected==actual);
	}
	@Test
	public void testAdjacent5(){
		boolean expected = true;
		boolean actual = new code.Dept("Civil").isAdjacent(new code.Dept("Business"));
		assertTrue("",expected==actual);
	}
	@Test
	public void testAdjacent6(){
		boolean expected = true;
		boolean actual = new code.Dept("Criminal").isAdjacent(new code.Dept("Pathology"));
		assertTrue("",expected==actual);
	}
	
	
	@Test
	public void testNotAdjacent(){
		boolean expected = false;
		boolean actual = new code.Dept("Otolaryngology").isAdjacent(new code.Dept("Family"));
		assertTrue("",expected==actual);
	}
	

	@Test public void testAdjacent7(){
		boolean expected = true;
		boolean actual = new code.Dept("Family").isAdjacent(new code.Dept("Criminal"));
		assertTrue("", expected == actual);
	}	

}
