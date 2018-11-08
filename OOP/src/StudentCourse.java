public class StudentCourse
{
	private String courseId;
	private float examMarks;
	private float courseworkMarks;
	
	public StudentCourse(String courseId)
	{
		this.courseId = courseId;
	}

	public String getCourseId()
	{
		return courseId;
	}

	public void setCourseId(String courseId)
	{
		this.courseId = courseId;
	}

	public float getExamMarks()
	{
		return examMarks;
	}

	public void setExamMarks(float examMarks)
	{
		this.examMarks = examMarks;
	}

	public float getCourseworkMarks()
	{
		return courseworkMarks;
	}

	public void setCourseworkMarks(float courseworkMarks)
	{
		this.courseworkMarks = courseworkMarks;
	}
	
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
