import java.util.ArrayList;

public class Group
{
	private String groupId;
	private String staffId; // Lecturer
	private String venue;
	private int vacancy;

	private ArrayList<String> studentsId;

	public Group(String groupId, String staffId, String venue, int vacancy)
	{
		this.groupId = groupId;
		this.staffId = staffId;
		this.venue = venue;
		this.vacancy = vacancy;

		studentsId = new ArrayList<String>();
	}

	public String getGroupId()
	{
		return groupId;
	}

	public void setGroupId(String groupId)
	{
		this.groupId = groupId;
	}

	public String getStaffId()
	{
		return staffId;
	}

	public void setStaffId(String staffId)
	{
		this.staffId = staffId;
	}

	public String getVenue()
	{
		return venue;
	}

	public void setVenue(String venue)
	{
		this.venue = venue;
	}

	public int getVacancy()
	{
		return vacancy;
	}

	public void setVacancy(int vacancy)
	{
		this.vacancy = vacancy;
	}

	public ArrayList<String> getStudentsId()
	{
		return studentsId;
	}

	public void setStudentsId(ArrayList<String> studentsId)
	{
		this.studentsId = studentsId;
	}

	public int getAvailableVacancy()
	{
		return vacancy - studentsId.size();
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("Session: [" + groupId + "]\n");
		sb.append("Venue: [" + venue + "]\n");
		sb.append("Staff: [" + staffId + "]\n");
		sb.append("Vacancy: [" + getAvailableVacancy() + "/" + vacancy + "]\n");

		return sb.toString();
	}

}
