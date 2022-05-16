/**
 * 
 */
package jpa.service;

import java.util.List;

import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jpa.dao.StudentDAO;
import jpa.entitymodels.SMS.Course;
import jpa.entitymodels.SMS.Student;

/**
 * @author crice
 *
 */
public class StudentService implements StudentDAO {

	static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
			.addAnnotatedClass(Course.class).buildSessionFactory();
	public static Session session = factory.openSession();

	public List<Student> getAllStudents() {

		Query q = session.createQuery("from Student s");
		List<Student> result = q.getResultList();
		return result;
	}

	public Student getStudentByEmail(String sEmail) {

		Student result = new Student();
		List<Student> students = getAllStudents();
		for (Student student : students) {
			if (student.getsEmail().equals(sEmail)) {
				result = student;
			}
		}
		return result;

	}

	public boolean validateStudent(String sEmail, String sPass) {

		boolean login = false;

		List<Student> students = getAllStudents();
		for (Student student : students) {
			if (student.getsEmail().equals(sEmail)) {
				if (student.getsPass().equals(sPass)) {
					login = true;
				}
			}
		}
		return login;
	}

	public static Course getCourseById(int cId) {
		Query q = session.createQuery("FROM Course c WHERE c.cId =:id");
		q.setParameter("id", cId);
		Course result = (Course) q.getSingleResult();
		return result;
	}

	public void registerStudentToCourse(String sEmail, int cId) {

		EntityTransaction transaction = session.beginTransaction();
		Student student = getStudentByEmail(sEmail);

		if (student.getsCourses().contains(getCourseById(cId))) {

			System.out.println("Student is already registered to that course.");
		} else {
			List<Course> courses = student.getsCourses();
			courses.add(getCourseById(cId));
			session.update(student);
			transaction.commit();
			// System.out.println(sEmail + "registered to" +
			// CourseService.GetCourseById(cId).toString());
		}
	}

	public List<Course> getStudentCourses(String sEmail) {

		Query q = session.createQuery("SELECT sCourses FROM Student s WHERE s.sEmail = :email");
		q.setParameter("email", sEmail);
		List<Course> result = q.getResultList();
		return result;
	}

}
