public class Staff extends Person
{
	private String staffId;
	private String designation;
	
	public Staff(String name, int age, char gender, String staffId, String designation)
	{
		super(name, age, gender);
		this.staffId = staffId;
		this.designation = designation;
	}

	public String getStaffId()
	{
		return staffId;
	}

	public void setStaffId(String staffId)
	{
		this.staffId = staffId;
	}

	public String getDesignation()
	{
		return designation;
	}

	public void setDesignation(String designation)
	{
		this.designation = designation;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
	
		sb.append("Staff ID: [" + staffId + "]\n");
		sb.append(super.toString());
		sb.append("Designation: [" + designation + "]\n");
		
		return sb.toString();
	}
}
