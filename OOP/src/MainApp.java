import java.util.Scanner;

public class MainApp
{
	public static void main(String[] args)
	{
		CourseRegistrationMarkEntry app = new CourseRegistrationMarkEntry();
		
		int choice;
		Scanner sc = new Scanner(System.in);

		do
		{
			printMenu();

			choice = sc.nextInt();
			sc.nextLine();

			switch (choice)
			{
				case 1:
					app.addStaff();
					break;
				case 2:
					app.addStudent();
					break;
				case 3:
					app.addModule();
					break;
				case 4:
					app.addCourse();
					break;
				case 5:
					app.registerStudentToCourse();
					break;
				case 6:
					app.checkAvailableSlotInClass();
					break;
				case 7:
					app.printStudentListFromSession();
					break;
				case 8:
					app.enterCourseAssessmentWeightage();
					break;
				case 9:
					app.enterStudentCourseworkMark();
					break;
				case 10:
					app.enterStudentExamMark();
					break;
				case 11:
					app.printCourseStatistics();
					break;
				case 12:
					app.printStudentTranscript();
					break;
			}
		}
		while (choice > 0 && choice < 13);
		
		System.out.println("Exit");
	}
	
	private static void printMenu()
	{
		System.out.println("");
		System.out.println("1.  Add a staff.");
		System.out.println("2.  Add a student.");
		System.out.println("3.  Add a module.");
		System.out.println("4.  Add a course.");
		System.out.println("5.  Register student for a course (this include registering for Tutorial/Lab classes).");
		System.out.println("6.  Check available slot in a class (vacancy in a class).");
		System.out.println("7.  Print student list by lecture, tutorial or laboratory session for a course.");
		System.out.println("8.  Enter course assessment components weightage.");
		System.out.println("9.  Enter coursework mark – inclusive of its components.");
		System.out.println("10. Enter exam mark.");
		System.out.println("11. Print course statistics.");
		System.out.println("12. Print student transcript.");
		System.out.println("13. Exit");
		System.out.println("");
		System.out.println("Enter your choice: ");
	}
}
