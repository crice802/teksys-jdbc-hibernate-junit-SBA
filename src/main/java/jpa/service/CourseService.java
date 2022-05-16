/**
 * 
 */
package jpa.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jpa.dao.CourseDAO;
import jpa.entitymodels.SMS.Course;
import jpa.entitymodels.SMS.Student;

/**
 * @author crice
 *
 */
public class CourseService implements CourseDAO {

	static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
			.addAnnotatedClass(Course.class).buildSessionFactory();
	public static Session session = factory.openSession();

	public List<Course> getAllCourses() {

		Query<Course> q = session.createQuery("from Course c");
		List<Course> result = q.getResultList();
		return result;
	}

	public static List<Course> GetCourseById(int cId) {
		Query q = session.createQuery("FROM Course c WHERE c.cId =:id");
		q.setParameter("id", cId);
		List<Course> result = q.getResultList();
		return result;
	}
}
