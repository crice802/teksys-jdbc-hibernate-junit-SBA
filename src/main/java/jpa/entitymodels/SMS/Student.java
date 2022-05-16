/**
 * 
 */
package jpa.entitymodels.SMS;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author crice
 *
 */
@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "email", nullable = false, length = 50)
	private String sEmail;
	@Column(name = "name", nullable = false, length = 50)
	private String sName;
	@Column(name = "password", nullable = false, length = 50)
	private String sPass;

	@ManyToMany(targetEntity = Course.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "student_course")
	private List<Course> sCourses;

	/**
	 * @param sEmail
	 * @param sName
	 * @param sPass
	 * @param sCourses
	 */
	public Student(String sEmail, String sName, String sPass, List<Course> sCourses) {
		this();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourses = sCourses;
	}

	/**
	 * 
	 */
	public Student() {

		sEmail = "";
		sName = "";
		sPass = "";
		sCourses = new ArrayList<Course>();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the sEmail
	 */
	public String getsEmail() {
		return sEmail;
	}

	/**
	 * @param sEmail the sEmail to set
	 */
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	/**
	 * @return the sName
	 */
	public String getsName() {
		return sName;
	}

	/**
	 * @param sName the sName to set
	 */
	public void setsName(String sName) {
		this.sName = sName;
	}

	/**
	 * @return the sPass
	 */
	public String getsPass() {
		return sPass;
	}

	/**
	 * @param sPass the sPass to set
	 */
	public void setsPass(String sPass) {
		this.sPass = sPass;
	}

	/**
	 * @return the sCourses
	 */
	public List<Course> getsCourses() {
		return sCourses;
	}

	/**
	 * @param sCourses the sCourses to set
	 */
	public void setsCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}

}
