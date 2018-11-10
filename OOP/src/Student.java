import java.util.ArrayList;
/**
 Student, a the person enrolled in school.
 Student is an extended identity from a person as
 we can be whoever we wanted to be.
 @author 4 Friends and Yoong Wei
 @version 2.1
 @since 2018-10-1
 */
public class Student extends Person
{
	/**
	 * unique ID for student
	 */
	private String studentId;
	/**
	 * student can have many courses
	 */
	private ArrayList<StudentCourse> registeredCourses;

	/**
	 * Create new student with name , age ,gender and student ID
	 * @param name This student's name.
	 * @param age This student's age.
	 * @param gender This student's gender.
	 * @param studentId This student's student Id.
	 */
	public Student(String name, int age, char gender, String studentId)
	{
		super(name, age, gender);
		this.studentId = studentId;
		registeredCourses = new ArrayList<StudentCourse>();
	}

	/**
	 * Gets the student ID.
	 * @return student ID.
	 */
	public String getStudentId()
	{
		return studentId;
	}


	/**
	 * Changes student's id
	 * @param studentId This student's new id.
	 */
	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}

	/**
	 * Gets the student's registered courses.
	 * @return student's registered courses.
	 */
	public ArrayList<StudentCourse> getRegisteredCourses()
	{
		return registeredCourses;
	}

	public void setRegisteredCourses(ArrayList<StudentCourse> registeredCourses)
	{
		this.registeredCourses = registeredCourses;
	}

	/**
	 * Gets the student's registered course by course id.
	 * @param courseId course id.
	 * @return student's registered courses by course id.
	 */
	public StudentCourse getRegisteredCourseById(String courseId)
	{
		for (StudentCourse studentCourse : registeredCourses)
		{
			if (studentCourse.getCourseId().equals(courseId))
			{
				return studentCourse;
			}
		}
		
		return null;
	}

	/**
	 * Output student's detail e.g student id and its designation.
	 * Take note student is inheritance from person.
	 * Hence, student's detail will be printed out.
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("Student ID: [" + studentId + "]\n");
		sb.append(super.toString());

		return sb.toString();
	}

	/**
	 * Output student's registered courses and its marks.
	 * @return output string.
	 */
	public String coursesToString()
	{
		StringBuilder sb = new StringBuilder();
		
		String format = "| %-28s | %-6.2f | %-6.2f |\n";

		sb.append("+------------------------------+--------+--------+\n");
		sb.append("| Course ID                    | Exam   | Course |\n");
		sb.append("+------------------------------+--------+--------+\n");
		for (StudentCourse studentCourse : registeredCourses)
		{
			sb.append(String.format(format, studentCourse.getCourseId(), studentCourse.getExamMarks(), studentCourse.getCourseworkMarks()));
		}
		sb.append("+------------------------------+--------+--------+\n");

		return sb.toString();
	}
}
