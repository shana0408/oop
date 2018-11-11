/**
 Student Course, a course that taken by a student.
 One student can take many course
 @author 4 Friends and Yoong Wei
 @version 2.1
 @since 2018-10-1
 */
public class StudentCourse
{
	/**
	 * unique ID for course
	 */
	private String courseId;
	/**
	 * exam marks
	 */
	private float examMarks;
	/**
	 * coursework mark
	 */
	private float courseworkMarks;

	/**
	 * Create new StudentCourse with course Id
	 * @param courseId course ID.
	 */
	public StudentCourse(String courseId)
	{
		this.courseId = courseId;
	}

	/**
	 * Gets the course ID.
	 * @return course ID.
	 */
	public String getCourseId()
	{
		return courseId;
	}

	/**
	 * Changes course's id
	 * @param courseId This student's new id.
	 */
	public void setCourseId(String courseId)
	{
		this.courseId = courseId;
	}

	/**
	 * Gets the exam marks.
	 * @return exam marks.
	 */
	public float getExamMarks()
	{
		return examMarks;
	}

	/**
	 * Changes exam's mark
	 * @param examMarks exam marks for particular student who is taking whatever course.
	 */
	public void setExamMarks(float examMarks)
	{
		this.examMarks = examMarks;
	}

	/**
	 * Gets the coursework marks.
	 * @return coursework marks.
	 */
	public float getCourseworkMarks()
	{
		return courseworkMarks;
	}

	/**
	 * Changes coursework's mark
	 * @param courseworkMarks coursework marks for particular student who is taking whatever course.
	 */
	public void setCourseworkMarks(float courseworkMarks)
	{
		this.courseworkMarks = courseworkMarks;
	}

	/**
	 * Output StudentCourse's detail e.g course id, exam marks and coursework mark.
	 * it will print out student course detail for particular student.
	 */
	public String toString()
	{
		String format = "| %-28s | %-6.2f | %-6.2f |\n";

		StringBuilder sb = new StringBuilder();
		sb.append("+------------------------------+--------+--------+\n");
		sb.append("| Course ID                    | Exam   | Course |\n");
		sb.append("+------------------------------+--------+--------+\n");
		sb.append(String.format(format, courseId, examMarks, courseworkMarks));
		sb.append("+------------------------------+--------+--------+\n");

		return sb.toString();
	}
}
