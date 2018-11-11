import java.util.ArrayList;
/**
 Group is a number of people or things that are located, gathered, or classed together.
 a course can have 1 lecture group and multiplier tutorials and labs
 @author 4 Friends and Yoong Wei
 @version 2.1
 @since 2018-10-1
 */



public class Group
{
	/**
	 * group id
	 */
	private String groupId;
	/**
	 * lecturer id
	 */
	private String staffId; // Lecturer
	/**
	 * location
	 */
	private String venue;
	/**
	 * vacancy
	 */
	private int vacancy;

	/**
	 * student list
	 */
	private ArrayList<String> studentsId;

	/**
	 * To create a group we the following information:
	 * 1.group id
	 * 2.lecturer id - who gonna teach
	 * 3.location - at where
	 * 4.vacancy - how many students
	 * 5.student list - who are those students
	 * @param groupId unique id for a group.
	 * @param staffId lecturer id.
	 * @param venue location.
	 * @param vacancy how many slots.
	 */
	public Group(String groupId, String staffId, String venue, int vacancy)
	{
		this.groupId = groupId;
		this.staffId = staffId;
		this.venue = venue;
		this.vacancy = vacancy;

		studentsId = new ArrayList<String>();
	}

	/**
	 * Gets the group id.
	 * @return group id.
	 */
	public String getGroupId()
	{
		return groupId;
	}

	/**
	 * Changes group id
	 * @param groupId group id.
	 */
	public void setGroupId(String groupId)
	{
		this.groupId = groupId;
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
	 * Changes staff id
	 * @param staffId staff id.
	 */
	public void setStaffId(String staffId)
	{
		this.staffId = staffId;
	}

	/**
	 * Gets the venue.
	 * @return venue.
	 */
	public String getVenue()
	{
		return venue;
	}

	/**
	 * Changes venue
	 * @param venue venue.
	 */
	public void setVenue(String venue)
	{
		this.venue = venue;
	}

	/**
	 * Gets the vacancy.
	 * @return vacancy.
	 */
	public int getVacancy()
	{
		return vacancy;
	}

	/**
	 * Changes vacancy
	 * @param vacancy vacancy.
	 */
	public void setVacancy(int vacancy)
	{
		this.vacancy = vacancy;
	}

	/**
	 * Gets the student ids.
	 * @return student ids.
	 */
	public ArrayList<String> getStudentsId()
	{
		return studentsId;
	}

	/**
	 * Changes student ids
	 * @param studentsId student ids.
	 */
	public void setStudentsId(ArrayList<String> studentsId)
	{
		this.studentsId = studentsId;
	}

	/**
	 * Gets how many slot left.
	 * @return how many slot left.
	 */
	public int getAvailableVacancy()
	{
		return vacancy - studentsId.size();
	}

	/**
	 * Output group's detail e.g its id, at where, who teach, how many slots left
	 */
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
