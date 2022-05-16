/**
 * 
 */
package jpa.entitymodels.SMS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author crice
 *
 */

@Entity
@Table(name = "course")
public class Course {

	@Override
	public String toString() {
		return +cId + "-Course Name: " + cName + ",Instructor Name: " + cInstructorName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int cId;
	@Column(name = "name", nullable = false, length = 50)
	private String cName;
	@Column(name = "instructor", nullable = false, length = 50)
	private String cInstructorName;

	/**
	 * @param cId
	 * @param cName
	 * @param cInstructorName
	 */
	public Course(int cId, String cName, String cInstructorName) {
		this();
		this.cId = cId;
		this.cName = cName;
		this.cInstructorName = cInstructorName;
	}

	/**
	 * 
	 */
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the cId
	 */
	public int getcId() {
		return cId;
	}

	/**
	 * @param cId the cId to set
	 */
	public void setcId(int cId) {
		this.cId = cId;
	}

	/**
	 * @return the cName
	 */
	public String getcName() {
		return cName;
	}

	/**
	 * @param cName the cName to set
	 */
	public void setcName(String cName) {
		this.cName = cName;
	}

	/**
	 * @return the cInstructorName
	 */
	public String getcInstructorName() {
		return cInstructorName;
	}

	/**
	 * @param cInstructorName the cInstructorName to set
	 */
	public void setcInstructorName(String cInstructorName) {
		this.cInstructorName = cInstructorName;
	}

}
