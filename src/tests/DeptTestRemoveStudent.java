package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Dept;
import code.Player;
import code.Student;

public class DeptTestRemoveStudent {

	@Test
	public void test0(){
		Dept d = new Dept("Music");
		Player a = new Player("A");
		d.addStudent(new Student(a,d));
		d.removeStudent(a);
		int expected = 0;
		int actual = d.getStudents().size();
		assertTrue(actual==expected);
	}
	
	
}
