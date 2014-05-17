package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Dept;

public class DeptTestsWhatSchool {

	@Test
	public void test0(){
		Dept d = new Dept("Music");
		String expected = "Arts";
		String actual = d.whatSchool(d).getName();
		assertTrue(actual.equals(expected));
	}
	
	@Test public void test1(){
		Dept d = new Dept("");
		String expected = "Major Not Found";
		String actual = d.whatSchool(d).getName();
		assertTrue(actual.equals(expected));
	}

}
