import java.util.ArrayList;

public class Course extends Module
{
	private String courseId;
	private String staffId; // PIC
	private int year;
	private int semester;

	private Weightage weightage;
	
	private boolean hasTutorial;
	private boolean hasLaboratory;

	private Group lecture;
	private ArrayList<Group> tutorials;
	private ArrayList<Group> laboratories;

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
	
	public String getCourseId()
	{
		return courseId;
	}

	public String getStaffId()
	{
		return staffId;
	}

	public void setStaffId(String staffId)
	{
		this.staffId = staffId;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public int getSemester()
	{
		return semester;
	}

	public void setSemester(int semester)
	{
		this.semester = semester;
	}

	public Weightage getWeightage()
	{
		return weightage;
	}

	public void setWeightage(Weightage weightage)
	{
		this.weightage = weightage;
	}

	public Group getLecture()
	{
		return lecture;
	}

	public void setLecture(Group lecture)
	{
		this.lecture = lecture;
	}

	public ArrayList<Group> getTutorials()
	{
		return tutorials;
	}

	public void setTutorials(ArrayList<Group> tutorials)
	{
		this.tutorials = tutorials;
	}

	public ArrayList<Group> getLaboratories()
	{
		return laboratories;
	}

	public void setLaboratories(ArrayList<Group> laboratories)
	{
		this.laboratories = laboratories;
	}

	public boolean isHasTutorial()
	{
		return hasTutorial;
	}

	public void setHasTutorial(boolean hasTutorial)
	{
		this.hasTutorial = hasTutorial;
	}

	public boolean isHasLaboratory()
	{
		return hasLaboratory;
	}

	public void setHasLaboratory(boolean hasLaboratory)
	{
		this.hasLaboratory = hasLaboratory;
	}
	
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
