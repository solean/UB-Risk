package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Dept;
import code.Player;
import code.Student;

public class DeptTestaddStudent {

	@Test
	public void test0(){
		Dept d = new Dept("Music");
		d.addStudent(new Student(new Player("A"),d));
		int expected = 1;
		int actual = d.getStudents().size();
		assertTrue(actual==expected);
	}
	
	
}
