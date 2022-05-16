/**
 * 
 */
package jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jpa.entitymodels.SMS.Student;
import junit.framework.TestCase;

/**
 * @author crice
 *
 */
public class TestLogin extends TestCase {
	Student student;
	StudentService studentService;
	List<Student> students = new ArrayList<Student>();

	public void setUp() {
		student = new Student("crice@crice.com", "Cory Rice", "crice", null);
		students.add(student);
		studentService = new StudentService();
	}

	@Test
	public void testValidateUser() {

		assertEquals(true, studentService.validateStudent(student.getsEmail(), student.getsPass()));
	}

	@Test
	public void testInvalidUser() {

		assertEquals(true, studentService.validateStudent(student.getsPass(), student.getsEmail()));
	}

}
