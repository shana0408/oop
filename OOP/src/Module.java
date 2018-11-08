public class Module
{
	private String moduleId;
	private String description;
	
	public Module(String moduleId, String description)
	{
		this.moduleId = moduleId;
		this.description = description;
	}
	
	public String getModuleId()
	{
		return moduleId;
	}

	public void setModuleId(String moduleId)
	{
		this.moduleId = moduleId;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Module ID: [" + moduleId + "]\n");
		sb.append("Description: [" + description + "]\n");
		
		return sb.toString();
	}
}

