/**
 What is a person? Person is made in the image of God and are unrelated to animals.
 A person nature reflects some of God's attributes but in a limited way. A person can be
 anything they wanted to be as long as God is allowed to do so. A staff in NTU? A politician?
 Child of god, be whatever you wanted to be.
 @author 4 Friends and Yoong Wei
 @version 2.1
 @since 2018-10-1
 */


public abstract class Person
{
	/**
	 * Full name of this person.
	 */
	private String name;
	/**
	 * Age of this person.
	 */
	private int age;
	/**
	 * Female or Male of this person.
	 */
	private char gender;

	/**
	 * God creates us and as a person we supposed to have a name, age and gender.
	 * @param name This Person's name.
	 * @param age This Person's age.
	 * @param gender This Person's age.
	 */
	public Person(String name, int age, char gender)
	{
		this.name = name;
		this.age = age;
		this.gender = gender;

	}

	/**
	 * Gets the name of Person.
	 * @return this Person's name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Changes the name of this Person
	 * @param name This Person's new name.
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Gets the age of Person.
	 * @return this Person's age.
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * Changes the age of this Person
	 * @param age This Person's new age.
	 */
	public void setAge(int age)
	{
		this.age = age;
	}

	/**
	 * Gets the gender of Person.
	 * @return this Person's gender.
	 */
	public char getGender()
	{
		return gender;
	}

	/**
	 * Changes the gender of this Person
	 * @param gender This Person's new gender.
	 */
	public void setGender(char gender)
	{
		this.gender = gender;
	}

	/**
	 * Output person's detail e.g name, age and gender
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Name: [" + name + "]\n");
		sb.append("Age: [" + age + "]\n");
		sb.append("Gender: [" + gender + "]\n");
		
		return sb.toString();
	}

}

