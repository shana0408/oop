/**
 A weighted is a more accurate measurement of scores or
 investments that are of relative importance to each other.
 One Course can have only one weightage
 @author 4 Friends and Yoong Wei
 @version 2.1
 @since 2018-10-1
 */
public class Weightage
{
	/**
	 * exam's weightage
	 */
	private float exam;
	/**
	 * coursework's weightage
	 */
	private float coursework;

	/**
	 * Create new Weightage with exam's weightage and coursework's weightage
	 * @param exam exam's weightage.
	 * @param coursework coursework's weightage.
	 */
	public Weightage(float exam, float coursework)
	{
		this.exam = exam;
		this.coursework = coursework;
	}

	/**
	 * Gets the exam's weightage.
	 * @return exam's weightage.
	 */
	public float getExam()
	{
		return exam;
	}

	/**
	 * Changes course's exam's weightage
	 * @param exam exam's weightage.
	 */
	public void setExam(float exam)
	{
		this.exam = exam;
	}


	/**
	 * Gets the coursework's weightage.
	 * @return coursework's weightage.
	 */
	public float getCoursework()
	{
		return coursework;
	}

	/**
	 * Changes course's coursework's weightage
	 * @param coursework coursework's weightage.
	 */
	public void setCoursework(float coursework)
	{
		this.coursework = coursework;
	}

}
