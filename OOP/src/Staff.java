/**
 Staff, a person employed by organization .
 Staff is an extended identity from a person as
 we can be whoever we wanted to be.
 @author 4 Friends and Yoong Wei
 @version 2.1
 @since 2018-10-1
 */

public class Staff extends Person
{
	/**
	 * unique ID for staff
	 */
	private String staffId;
	/**
	 * staff's designation
	 */
	private String designation;

	/**
	 * Create new staff with name , age and gender
	 * @param name This staff's name.
	 * @param age This staff's age.
	 * @param gender This staff's gender.
     * @param staffId This staff's staff Id.
     * @param designation This staff's designation.
	 */
	public Staff(String name, int age, char gender, String staffId, String designation)
	{
		super(name, age, gender);
		this.staffId = staffId;
		this.designation = designation;
	}

	/**
	 * Gets the staff ID.
	 * @return staff ID.
	 */
	public String getStaffId()
	{
		return staffId;
	}

	/**
	 * Changes staff's id
	 * @param staffId This staff's new id.
	 */
	public void setStaffId(String staffId)
	{
		this.staffId = staffId;
	}

	/**
	 * Gets the designation of Person.
	 * @return this Person's destination.
	 */
	public String getDesignation()
	{
		return designation;
	}

	/**
	 * Changes staff's destination
	 * @param designation This staff's new designation.
	 */
	public void setDesignation(String designation)
	{
		this.designation = designation;
	}

	/**
	 * Output staff's detail e.g staff id and its designation.
	 * Take note staff is inheritance from person.
	 * Hence, staff's detail will be printed out.
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
	
		sb.append("Staff ID: [" + staffId + "]\n");
		sb.append(super.toString());
		sb.append("Designation: [" + designation + "]\n");
		
		return sb.toString();
	}
}
