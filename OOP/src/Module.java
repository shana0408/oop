/**
 Module refers to an instructional unit that focuses on a particular topic.
 Although the details and activities vary according to the specific context,
 such as course and student level, most educational modules include information about the topic,
 focus on student-centered learning activities and culminate in a project for students to demonstrate understanding.
 @author 4 Friends and Yoong Wei
 @version 2.1
 @since 2018-10-1
 */
public class Module
{
	/**
	 * module id
	 */
	private String moduleId;
	/**
	 * module's description
	 */
	private String description;

	/**
	 * Create new Module with its unique id and description
	 * @param moduleId module id.
	 * @param description description.
	 */
	public Module(String moduleId, String description)
	{
		this.moduleId = moduleId;
		this.description = description;
	}

	/**
	 * Gets the module id.
	 * @return module id.
	 */
	public String getModuleId()
	{
		return moduleId;
	}

	/**
	 * Changes module id
	 * @param moduleId module id.
	 */
	public void setModuleId(String moduleId)
	{
		this.moduleId = moduleId;
	}

	/**
	 * Gets the description.
	 * @return description.
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Changes module description
	 * @param description module description.
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * Output module's detail e.g module id and description
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Module ID: [" + moduleId + "]\n");
		sb.append("Description: [" + description + "]\n");
		
		return sb.toString();
	}
}

