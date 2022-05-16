/**
 * 
 */
package jpa.dao;

import java.util.List;

import jpa.entitymodels.SMS.Course;
import jpa.entitymodels.SMS.Student;

/**
 * @author crice
 *
 */
public interface StudentDAO {

	public List<Student> getAllStudents();

	public Student getStudentByEmail(String sEmail);

	public boolean validateStudent(String sEmail, String sPass);

	public void registerStudentToCourse(String sEmail, int cId);

	public List<Course> getStudentCourses(String sEmail);

}
