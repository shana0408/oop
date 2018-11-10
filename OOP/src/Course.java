import java.util.ArrayList;
/**
 Course is child class of Module class. As every year will have the same module but different lecturer teaching different
 students, it is used for specific elaborate the changing information.
 @author 4 Friends and Yoong Wei
 @version 2.1
 @since 2018-10-1
 */

public class Course extends Module
{
	/**
	 * course id
	 */
	private String courseId;
	/**
	 * person in charge
	 */
	private String staffId; // PIC
	/**
	 * teaching year
	 */
	private int year;
	/**
	 * which sem
	 */
	private int semester;
	/**
	 * its weightage
	 */
	private Weightage weightage;
	/**
	 * does it has tutorial
	 */
	private boolean hasTutorial;
	/**
	 * does it has lab
	 */
	private boolean hasLaboratory;
	/**
	 * which group
	 */
	private Group lecture;
	/**
	 * which tutorials
	 */
	private ArrayList<Group> tutorials;
	/**
	 * which labs
	 */
	private ArrayList<Group> laboratories;

	/**
	 * To create a course we the following information:
	 * 1.module id
	 * 2.description
	 * 3.staffId - who is the person in charge
	 * 4.year- which year
	 * 5.sem- which sem
	 * @param moduleId unique id for a course.
	 * @param description description.
	 * @param staffId pic.
	 * @param year which year.
	 * @param semester which sem.
	 */
	public Course(String moduleId, String description, String staffId, int year, int semester)
	{
		super(moduleId, description);

		this.staffId = staffId;
		this.year = year;
		this.semester = semester;
		this.courseId = moduleId + "-" + year + "-" + semester;
		
		weightage = new Weightage(0, 0);
		
		hasTutorial = false;
		hasLaboratory = false;

		lecture = null;
		tutorials = new ArrayList<Group>();
		laboratories = new ArrayList<Group>();
	}

	/**
	 * Gets the course id.
	 * @return course id.
	 */
	public String getCourseId()
	{
		return courseId;
	}

	/**
	 * Gets the staff id.
	 * @return staff id.
	 */
	public String getStaffId()
	{
		return staffId;
	}

	/**
	 * Changes staffId id
	 * @param staffId staffId id.
	 */
	public void setStaffId(String staffId)
	{
		this.staffId = staffId;
	}

	/**
	 * Gets the year
	 * @return year.
	 */
	public int getYear()
	{
		return year;
	}

	/**
	 * Changes year
	 * @param year year.
	 */
	public void setYear(int year)
	{
		this.year = year;
	}

	/**
	 * Gets the semester.
	 * @return semester.
	 */
	public int getSemester()
	{
		return semester;
	}

	/**
	 * Changes semester
	 * @param semester semester.
	 */
	public void setSemester(int semester)
	{
		this.semester = semester;
	}

	/**
	 * Gets the weightage.
	 * @return weightage.
	 */
	public Weightage getWeightage()
	{
		return weightage;
	}

	/**
	 * Changes weightage
	 * @param weightage weightage.
	 */
	public void setWeightage(Weightage weightage)
	{
		this.weightage = weightage;
	}

	/**
	 * Gets the lecture.
	 * @return lecture.
	 */
	public Group getLecture()
	{
		return lecture;
	}

	/**
	 * Changes pic
	 * @param lecture pic.
	 */
	public void setLecture(Group lecture)
	{
		this.lecture = lecture;
	}

	/**
	 * Gets the tutorials.
	 * @return tutorials.
	 */
	public ArrayList<Group> getTutorials()
	{
		return tutorials;
	}

	/**
	 * Changes tutorials
	 * @param tutorials tutorials.
	 */
	public void setTutorials(ArrayList<Group> tutorials)
	{
		this.tutorials = tutorials;
	}

	/**
	 * Gets the labs.
	 * @return labs.
	 */
	public ArrayList<Group> getLaboratories()
	{
		return laboratories;
	}

	/**
	 * Changes laboratories
	 * @param laboratories laboratories.
	 */
	public void setLaboratories(ArrayList<Group> laboratories)
	{
		this.laboratories = laboratories;
	}

	/**
	 * Gets the tutorial.
	 * @return tutorial.
	 */
	public boolean isHasTutorial()
	{
		return hasTutorial;
	}

	/**
	 * Changes hasTutorial
	 * @param hasTutorial true or false.
	 */
	public void setHasTutorial(boolean hasTutorial)
	{
		this.hasTutorial = hasTutorial;
	}

	/**
	 * Check does it has lab.
	 * @return true or false.
	 */
	public boolean isHasLaboratory()
	{
		return hasLaboratory;
	}

	/**
	 * Changes hasLaboratory
	 * @param hasLaboratory true or false.
	 */
	public void setHasLaboratory(boolean hasLaboratory)
	{
		this.hasLaboratory = hasLaboratory;
	}

	/**
	 * Check is the student registered in this course.
	 * @param studentId student id
	 * @return true or false.
	 */
	public boolean checkRegisteredStudent(String studentId)
	{
		for (String registeredStudentId : lecture.getStudentsId())
		{
			if (registeredStudentId.equals(studentId))
			{
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Output course's detail e.g its id, which year and sem, who in charge, has tutorial? has lab?
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append("Course ID: [" + courseId + "]\n");
		sb.append("Year-Semester: [" + year + "-" + semester + "]\n");
		sb.append("Coordinator ID: [" + staffId + "]\n");
		
		sb.append(lecture.toString());
		
		if (hasTutorial)
		{
			for (Group tutorial : tutorials)
			{
				sb.append(tutorial.toString());
			}
		}
		
		if (hasLaboratory)
		{
			for (Group lab : laboratories)
			{
				sb.append(lab.toString());
			}
		}

		return sb.toString();
	}
}
