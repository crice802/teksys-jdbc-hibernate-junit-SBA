/**
 * 
 */
package jpa.mainrunner;

import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.SMS.Course;
import jpa.entitymodels.SMS.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

/**
 * @author crice
 *
 */
public class SMSRunner {

	private Scanner sin;
	private StringBuilder sb;

	private CourseService courseService;
	private StudentService studentService;
	private Student currentStudent;

	public SMSRunner() {
		sin = new Scanner(System.in);
		sb = new StringBuilder();
		courseService = new CourseService();
		studentService = new StudentService();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SMSRunner sms = new SMSRunner();
		sms.run();
	}

	private void run() {
		// Login or quit
		switch (menu1()) {
		case 1:
			if (studentLogin()) {
				registerMenu();
			}
			break;
		case 2:
			System.out.println("Goodbye!");
			break;

		default:

		}
	}

	private int menu1() {
		sb.append("\n1.Student Login\n2. Quit Application\nPlease Enter Selection: ");
		System.out.print(sb.toString());
		sb.delete(0, sb.length());

		return sin.nextInt();
	}

	private boolean studentLogin() {
		boolean retValue = false;
		System.out.print("Enter your email address: ");
		String email = sin.next();
		System.out.print("Enter your password: ");
		String password = sin.next();

		if (studentService.validateStudent(email, password)) {
			List<Course> courses = studentService.getStudentCourses(email);
			System.out.println("MyClasses");
			System.out.printf("%-4s%-28s %-16s\n", "#", "COURSE NAME", "INSTRUCTOR NAME");
			System.out.println("==================================================");
			currentStudent = studentService.getStudentByEmail(email);
			for (Course course : courses) {
				System.out.printf("%-4s%-28s %-16s\n", course.getcId(), course.getcName(), course.getcInstructorName());
			}
			retValue = true;

		} else {
			System.out.println("User Validation failed. GoodBye!");
		}
		return retValue;
	}

	private void registerMenu() {
		sb.append("\n1.Register a class\n2. Logout\nPlease Enter Selection: ");
		System.out.print(sb.toString());
		sb.delete(0, sb.length());

		switch (sin.nextInt()) {
		case 1:
			List<Course> allCourses = courseService.getAllCourses();
			System.out.printf("%-4s%-28s %-16s\n", "#", "COURSE NAME", "INSTRUCTOR NAME");
			System.out.println("==================================================");
			for (Course course : allCourses) {
				// System.out.printf("%-4s%-28s %-16s\n", course.getcId(), course.getcName(),
				// course.getcInstructorName());
				System.out.println(course.toString());
			}
			System.out.println();
			System.out.print("Enter Course Number: ");
			int number = sin.nextInt();
			Course newCourse = studentService.getCourseById(number);

			if (newCourse != null) {
				studentService.registerStudentToCourse(currentStudent.getsEmail(), newCourse.getcId());
				Student temp = studentService.getStudentByEmail(currentStudent.getsEmail());

//				StudentCourseService scService = new StudentCourseService();
				List<Course> studentCourses = studentService.getStudentCourses(temp.getsEmail());

				System.out.println("MyClasses");
				for (Course course : studentCourses) {
					System.out.println(course);
				}
			}
			break;
		case 2:
		default:
			System.out.println("Goodbye!");
		}
	}

}
