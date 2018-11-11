import java.util.ArrayList;

public class Student extends Person
{
	private String studentId;
	private ArrayList<StudentCourse> registeredCourses;
	
	public Student(String name, int age, char gender, String studentId)
	{
		super(name, age, gender);
		this.studentId = studentId;
		registeredCourses = new ArrayList<StudentCourse>();
	}

	public String getStudentId()
	{
		return studentId;
	}

	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}

	public ArrayList<StudentCourse> getRegisteredCourses()
	{
		return registeredCourses;
	}

	public void setRegisteredCourses(ArrayList<StudentCourse> registeredCourses)
	{
		this.registeredCourses = registeredCourses;
	}
	
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

	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("Student ID: [" + studentId + "]\n");
		sb.append(super.toString());

		return sb.toString();
	}

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
