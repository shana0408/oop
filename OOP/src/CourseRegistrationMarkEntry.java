import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 Brain of this application. All logic is here.
 @author 4 Friends and Yoong Wei
 @version 2.1
 @since 2018-10-1
 */
public class CourseRegistrationMarkEntry
{
	/**
	 * students
	 */
	private ArrayList<Student> students;
	/**
	 * staffs
	 */
	private ArrayList<Staff> staffs;
	/**
	 * modules
	 */
	private ArrayList<Module> modules;
	/**
	 * courses
	 */
	private ArrayList<Course> courses;
	/**
	 * just a scanner. what did u expect?
	 */
	private Scanner sc;

	/**
	 * Create a course registration app by initialize all data from cvs first.
	 * After that, admin is able to enter whatever they wanted to do.
	 */
	public CourseRegistrationMarkEntry()
	{
		initiate();
		sc = new Scanner(System.in);
	}

	/**
	 * initialize all data from cvs
	 */
	private void initiate()
	{
		FileReader fileReader;
		BufferedReader br;

		students = new ArrayList<Student>();
		staffs = new ArrayList<Staff>();
		modules = new ArrayList<Module>();
		courses = new ArrayList<Course>();

		String line = "";
		try
		{
			fileReader = new FileReader("data/staff.csv");
			br = new BufferedReader(fileReader);

			while ((line = br.readLine()) != null)
			{
				String[] splitLine = line.split(",");
				staffs.add(new Staff(splitLine[0], Integer.parseInt(splitLine[1]), splitLine[2].charAt(0), splitLine[3], splitLine[4]));
			}

			fileReader = new FileReader("data/student.csv");
			br = new BufferedReader(fileReader);

			while ((line = br.readLine()) != null)
			{
				String[] splitLine = line.split(",");
				students.add(new Student(splitLine[0], Integer.parseInt(splitLine[1]), splitLine[2].charAt(0), splitLine[3]));
			}

			fileReader = new FileReader("data/module.csv");
			br = new BufferedReader(fileReader);

			while ((line = br.readLine()) != null)
			{
				String[] splitLine = line.split(",");
				modules.add(new Module(splitLine[0], splitLine[1]));
			}
			
			fileReader = new FileReader("data/course.csv");
			br = new BufferedReader(fileReader);
			
			while ((line = br.readLine()) != null)
			{
				String[] splitLine = line.split(",");
				Course course = new Course(splitLine[0], splitLine[1], splitLine[2], Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]));
				
			}
			
			br.close();
			fileReader.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * add staff
	 */
	protected void addStaff()
	{
		String staffId;
		String name;
		int age;
		char gender;
		String designation;

		System.out.println("Enter Staff ID: ");
		staffId = sc.nextLine();

		if (searchForStaffById(staffId) != null)
		{
			System.out.println("Staff ID [" + staffId + "] exist in system");
			return;
		}

		System.out.println("Enter Staff Name: ");
		name = sc.nextLine();

		System.out.println("Enter Staff Age: ");
		age = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter Staff Gender (M/F): ");
		gender = sc.nextLine().charAt(0);

		System.out.println("Enter Designation: ");
		designation = sc.nextLine();

		Staff staff = new Staff(name, age, gender, staffId, designation);
		System.out.println(staff.toString());
		staffs.add(staff);
		System.out.println("Staff addded successful");
	}

	/**
	 * add student
	 */
	protected void addStudent()
	{
		String studentId;
		String name;
		int age;
		char gender;

		System.out.println("Enter Student ID: ");
		studentId = sc.nextLine();

		if (searchForStudentById(studentId) != null)
		{
			System.out.println("Student ID [" + studentId + "] exist in system");
			return;
		}

		System.out.println("Enter Student Name: ");
		name = sc.nextLine();

		System.out.println("Enter Student Age: ");
		age = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter Student Gender (M/F): ");
		gender = sc.nextLine().charAt(0);

		Student student = new Student(name, age, gender, studentId);
		System.out.println(student.toString());
		students.add(student);
		System.out.println("Student addded successful");
	}

	/**
	 * add module
	 */
	protected void addModule()
	{
		String moduleId;
		String description;

		System.out.println("Enter Module ID: ");
		moduleId = sc.nextLine();

		if (searchForModuleById(moduleId) != null)
		{
			System.out.println("Module ID [" + moduleId + "] exist in system");
			return;
		}

		System.out.println("Enter Module Description: ");
		description = sc.nextLine();

		Module module = new Module(moduleId, description);
		System.out.println(module.toString());
		modules.add(module);
		System.out.println("Module added successful");
	}

	/**
	 * add course
	 */
	protected void addCourse()
	{
		Module module;
		String moduleId;
		int year;
		int semester;
		String staffId;
		String venue;
		int vacancy;

		System.out.println("Enter Coordinator/ Staff ID: ");
		staffId = sc.nextLine();

		if (searchForStaffById(staffId) == null)
		{
			System.out.println("Staff ID [" + staffId + "] not exist in system");
			return;
		}

		System.out.println("Enter Module ID: ");
		moduleId = sc.nextLine();

		module = searchForModuleById(moduleId);
		if (module == null)
		{
			System.out.println("Module ID [" + moduleId + "] not exist in system");
			return;
		}

		System.out.println("Enter year: ");
		year = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter semester: ");
		semester = sc.nextInt();
		sc.nextLine();

		if (searchForCourseByIdYearSem(moduleId, year, semester) != null)
		{
			System.out.println("Course [" + moduleId + "-" + year + "-" + semester + "] already exist in system");
			return;
		}

		Course course = new Course(module.getModuleId(), module.getDescription(), staffId, year, semester);

		System.out.println("Enter information for Lecture");

		System.out.println("Enter Lecturer/ Staff ID: ");
		staffId = sc.nextLine();

		if (searchForStaffById(staffId) == null)
		{
			System.out.println("Staff ID [" + staffId + "] not exists in system");
			return;
		}

		System.out.println("Enter Lecture Venue: ");
		venue = sc.nextLine();

		System.out.println("Enter Available Vacancy: ");
		vacancy = sc.nextInt();
		sc.nextLine();

		course.setLecture(new Group(moduleId + "-" + year + "-" + semester + "-LT", staffId, venue, vacancy));

		int count = 1;
		String addTutorial = "N";
		String addLaboratory = "N";

		System.out.println("Add tutorial session?(Y/N): ");
		addTutorial = sc.nextLine();

		while (addTutorial.equalsIgnoreCase("Y"))
		{
			System.out.println("Enter Tutor/ Staff ID: ");
			staffId = sc.nextLine();

			if (searchForStaffById(staffId) == null)
			{
				System.out.println("Staff ID [" + staffId + "] not exists in system");
				return;
			}

			System.out.println("Enter Tutorial Venue: ");
			venue = sc.nextLine();

			System.out.println("Enter Available Vacancy: ");
			vacancy = sc.nextInt();
			sc.nextLine();

			course.getTutorials().add(new Group(moduleId + "-" + year + "-" + semester + "-TUT" + count, staffId, venue, vacancy));
			course.setHasTutorial(true);
			count++;

			System.out.println("Add tutorial session?(Y/N): ");
			addTutorial = sc.nextLine();
		}

		if (course.isHasTutorial())
		{
			System.out.println("Add laboratory session?(Y/N): ");
			addLaboratory = sc.nextLine();

			count = 1;

			while (addLaboratory.equalsIgnoreCase("Y"))
			{
				System.out.println("Enter Lab Instructor/ Staff ID: ");
				staffId = sc.nextLine();

				if (searchForStaffById(staffId) == null)
				{
					System.out.println("Staff ID [" + staffId + "] not exists in system");
					return;
				}

				System.out.println("Enter Laboratory Venue: ");
				venue = sc.nextLine();

				System.out.println("Enter Available Vacancy: ");
				vacancy = sc.nextInt();
				sc.nextLine();

				course.getLaboratories().add(new Group(moduleId + "-" + year + "-" + semester + "-LAB" + count, staffId, venue, vacancy));
				course.setHasLaboratory(true);
				count++;

				System.out.println("Add laboratory session?(Y/N): ");
				addLaboratory = sc.nextLine();
			}
		}
		System.out.println(course.toString());
		courses.add(course);
		System.out.println("Course added successful");
	}

	/**
	 * register student to a course
	 */
	protected void registerStudentToCourse()
	{
		String studentId;
		String moduleId;
		String groupId;
		int year;
		int semester;

		Course course;
		Group selectedLecture = null;
		Group selectedTutorial = null;
		Group selectedLaboratory = null;

		System.out.println("Enter Student Id: ");
		studentId = sc.nextLine();

		if (searchForStudentById(studentId) == null)
		{
			System.out.println("Student Id [" + studentId + "] not exist in system");
			return;
		}

		System.out.println("Enter Module Id: ");
		moduleId = sc.nextLine();

		System.out.println("Enter Year: ");
		year = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter Semester: ");
		semester = sc.nextInt();
		sc.nextLine();

		if ((course = searchForCourseByIdYearSem(moduleId, year, semester)) == null)
		{
			System.out.println("Course [" + moduleId + "-" + year + "-" + semester + "] not exist in system");
			return;
		}

		if (course.checkRegisteredStudent(studentId))
		{
			System.out.println("Student ID [" + studentId + "] already registered in this course [" + course.getCourseId() + "]");
			return;
		}

		System.out.println(course.toString());

		if ((selectedLecture = course.getLecture()).getAvailableVacancy() <= 0)
		{
			System.out.println("Lecture [" + course.getLecture().getGroupId() + "] not available");
			return;
		}

		if (course.isHasTutorial())
		{
			for (Group tutorial : course.getTutorials())
			{
				System.out.println("Tutorial ID [" + tutorial.getGroupId() + "] [" + tutorial.getAvailableVacancy() + "/" + tutorial.getVacancy() + "]");
			}
			
			System.out.println("Which tutorial group would like to register?");
			groupId = sc.nextLine();

			if ((selectedTutorial = searchForGroupById(groupId, course.getTutorials())) == null || selectedTutorial.getAvailableVacancy() <= 0)
			{
				System.out.println("Tutorial [" + groupId + "] not available");
				return;
			}
		}

		if (course.isHasLaboratory())
		{
			System.out.println("Which laboratory group would like to register?");
			for (Group lab : course.getLaboratories())
			{
				System.out.println("Lab ID [" + lab.getGroupId() + "] [" + lab.getAvailableVacancy() + "/" + lab.getVacancy() + "]");
			}

			groupId = sc.nextLine();

			if ((selectedLaboratory = searchForGroupById(groupId, course.getLaboratories())) == null || selectedLaboratory.getAvailableVacancy() <= 0)
			{
				System.out.println("Lab [" + groupId + "] not available");
				return;
			}
		}

		if (selectedLecture != null)
		{
			selectedLecture.getStudentsId().add(studentId);
			System.out.println("Student ID: [" + studentId + "] registered in [" + selectedLecture.getGroupId() + "]");
		}
		if (selectedTutorial != null)
		{
			selectedTutorial.getStudentsId().add(studentId);
			System.out.println("Student ID: [" + studentId + "] registered in [" + selectedTutorial.getGroupId() + "]");
		}
		if (selectedLaboratory != null)
		{
			selectedLaboratory.getStudentsId().add(studentId);
			System.out.println("Student ID: [" + studentId + "] registered in [" + selectedLaboratory.getGroupId() + "]");
		}

		searchForStudentById(studentId).getRegisteredCourses().add(new StudentCourse(course.getCourseId()));
		System.out.println("Registered Successful");
	}

	/**
	 * check available slot in class
	 */
	protected void checkAvailableSlotInClass()
	{
		String moduleId;
		int year;
		int semester;

		Course course = null;

		System.out.println("Enter Module Id: ");
		moduleId = sc.nextLine();

		System.out.println("Enter Year: ");
		year = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter Semester: ");
		semester = sc.nextInt();
		sc.nextLine();

		if ((course = searchForCourseByIdYearSem(moduleId, year, semester)) == null)
		{
			System.out.println("Course [" + moduleId + "-" + year + "-" + semester + "] not exist in system");
			return;
		}

		System.out.println(course.getLecture().toString());
		for (Group tutorial : course.getTutorials())
		{
			System.out.println(tutorial.toString());
		}
		for (Group lab : course.getLaboratories())
		{
			System.out.println(lab.toString());
		}
	}

	/**
	 * print student list from current session
	 */
	protected void printStudentListFromSession()
	{
		String moduleId;
		String groupId;
		int year;
		int semester;

		Course course = null;
		Group group = null;

		System.out.println("Enter Module Id: ");
		moduleId = sc.nextLine();

		System.out.println("Enter Year: ");
		year = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter Semester: ");
		semester = sc.nextInt();
		sc.nextLine();

		if ((course = searchForCourseByIdYearSem(moduleId, year, semester)) == null)
		{
			System.out.println("Course [" + moduleId + "-" + year + "-" + semester + "] not exist in system");
			return;
		}

		System.out.println("Session [" + course.getLecture().getGroupId() + "]");
		for (Group tutorial : course.getTutorials())
		{
			System.out.println("Session [" + tutorial.getGroupId() + "]");
		}
		for (Group laboratory : course.getLaboratories())
		{
			System.out.println("Session [" + laboratory.getGroupId() + "]");
		}
		System.out.println("Enter session id: ");

		groupId = sc.nextLine();

		ArrayList<Group> allSession = new ArrayList<Group>();
		allSession.add(course.getLecture());
		allSession.addAll(course.getTutorials());
		allSession.addAll(course.getLaboratories());

		if ((group = searchForGroupById(groupId, allSession)) == null)
		{
			System.out.println("Session [" + groupId + "] not exist in system");
			return;
		}
		
		System.out.println("Total number of students: " + group.getStudentsId().size());
		for (String studentId : group.getStudentsId())
		{
			System.out.println("Student Id: [" + studentId + "]");
		}
	}

	/**
	 * enter course assessment weightage
	 */
	protected void enterCourseAssessmentWeightage()
	{
		String moduleId;
		int year;
		int semester;
		float examWeightage;
		float courseworkWeightage;

		Course course = null;

		System.out.println("Enter Module Id: ");
		moduleId = sc.nextLine();

		System.out.println("Enter Year: ");
		year = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter Semester: ");
		semester = sc.nextInt();
		sc.nextLine();

		if ((course = searchForCourseByIdYearSem(moduleId, year, semester)) == null)
		{
			System.out.println("Course [" + moduleId + "-" + year + "-" + semester + "] not exist in system");
			return;
		}

		System.out.println("Enter Weightage of Exam(%): ");
		examWeightage = sc.nextFloat();

		System.out.println("Enter Weightage of coursework(%): ");
		courseworkWeightage = sc.nextFloat();

		if ((examWeightage + courseworkWeightage) != 100)
		{
			System.out.println("Weightage of exam and coursework must be equal to 100%");
			return;
		}

		course.setWeightage(new Weightage(examWeightage, courseworkWeightage));
		System.out.println("Course grading weightage saved");
	}

	/**
	 * enter student coursework mark
	 */
	protected void enterStudentCourseworkMark()
	{
		String studentId;
		String courseId;
		float courseworkMarks;
		
		Student student;
		StudentCourse studentCourse;
		
		System.out.println("Enter Student Id: ");
		studentId = sc.nextLine();
		
		if ((student = searchForStudentById(studentId)) == null)
		{
			System.out.println("Student Id [" + studentId + "] not exist in system");
			return;
		}
		
		System.out.println(student.coursesToString());
		System.out.println("Which course to enter coursemark: ");
		courseId = sc.nextLine();
		
		if ((studentCourse = student.getRegisteredCourseById(courseId)) == null)
		{
			System.out.println("Student Id [" + studentId + "] not registered [" + courseId + "]");
			return;
		}
		
		System.out.println("Enter coursework marks (Max 100): ");
		courseworkMarks = sc.nextFloat();
		
		if (courseworkMarks > 100)
		{
			System.out.println("Marks cannot be more than 100");
			return;
		}
		
		studentCourse.setCourseworkMarks(courseworkMarks);
		System.out.println(studentCourse.toString());
		System.out.println("Saved Successful");
	}

	/**
	 * enter student exam mark
	 */
	protected void enterStudentExamMark()
	{
		String studentId;
		String courseId;
		float courseworkMarks;
		
		Student student;
		StudentCourse studentCourse;
		
		System.out.println("Enter Student Id: ");
		studentId = sc.nextLine();
		
		if ((student = searchForStudentById(studentId)) == null)
		{
			System.out.println("Student Id [" + studentId + "] not exist in system");
			return;
		}
		
		System.out.println(student.coursesToString());
		System.out.println("Which course to enter exam marks: ");
		courseId = sc.nextLine();
		
		if ((studentCourse = student.getRegisteredCourseById(courseId)) == null)
		{
			System.out.println("Student Id [" + studentId + "] not registered [" + courseId + "]");
			return;
		}
		
		System.out.println("Enter exam marks (Max 100): ");
		courseworkMarks = sc.nextFloat();
		
		if (courseworkMarks > 100)
		{
			System.out.println("Marks cannot be more than 100");
			return;
		}
		
		studentCourse.setExamMarks(courseworkMarks);
		System.out.println(studentCourse.toString());
		System.out.println("Saved Successful");
	}

	/**
	 * print course statistics
	 */
	protected void printCourseStatistics()
	{
		String moduleId;
		int year;
		int semester;
		
		float totalExam = 0;
		float totalCoursework = 0;
		
		Course course = null;
		
		System.out.println("Enter Module Id: ");
		moduleId = sc.nextLine();

		System.out.println("Enter Year: ");
		year = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter Semester: ");
		semester = sc.nextInt();
		sc.nextLine();

		if ((course = searchForCourseByIdYearSem(moduleId, year, semester)) == null)
		{
			System.out.println("Course [" + moduleId + "-" + year + "-" + semester + "] not exist in system");
			return;
		}
		
		for (String studentId : course.getLecture().getStudentsId())
		{
			StudentCourse studentCourse = searchForStudentById(studentId).getRegisteredCourseById(course.getCourseId());
			
			totalExam += studentCourse.getExamMarks();
			totalCoursework += studentCourse.getCourseworkMarks();
		}
		
		System.out.println("Course [" + course.getCourseId() + "]");
		System.out.println("Overall (Exam + Coursework) [" + (totalExam + totalCoursework) / course.getLecture().getStudentsId().size() + "]");
		System.out.println("Overall (Exam Only) [" + totalExam / course.getLecture().getStudentsId().size() + "]");
		System.out.println("Overall (Coursework Only) [" + totalCoursework / course.getLecture().getStudentsId().size() + "]");
	}

	/**
	 * print student transcript
	 */
	protected void printStudentTranscript()
	{
		float cgpa = 0;
		String studentId;
		Student student;
		ArrayList<StudentCourse> registeredCourse;
		
		String format = "| %-28s | %-6.2f (%6.2f) | %-6.2f (%6.2f) | %-11.2f | %-2.1f |";
		
		System.out.println("Enter Student Id: ");
		studentId = sc.nextLine();

		if ((student = searchForStudentById(studentId)) == null)
		{
			System.out.println("Student Id [" + studentId + "] not exist in system");
			return;
		}
		
		registeredCourse = student.getRegisteredCourses();
		
		System.out.println("+------------------------------+-----------------+-----------------+-------------+-----+");
		System.out.println("| Course ID                    | Exam   (Weight) | Course (Weight) | Total Marks | GPA |");
		System.out.println("+------------------------------+-----------------+-----------------+-------------+-----+");
		for (StudentCourse studentCourse : registeredCourse)
		{
			float totalMarks;
			float gpa;
			
			Course course = searchForCourseById(studentCourse.getCourseId());
			
			if (course.getWeightage().getExam() == 0 && course.getWeightage().getCoursework() == 0)
			{
				continue;
			}
			
			totalMarks = studentCourse.getExamMarks() * (course.getWeightage().getExam()/100.0f) + studentCourse.getCourseworkMarks() * (course.getWeightage().getCoursework()/100.0f);
			gpa = marksToGPA(totalMarks);
			cgpa += gpa;
			
			System.out.println(String.format(format, studentCourse.getCourseId(), studentCourse.getExamMarks(), course.getWeightage().getExam(), studentCourse.getCourseworkMarks(), course.getWeightage().getCoursework(), totalMarks, gpa));
		}
		System.out.println("+------------------------------+-----------------+-----------------+-------------+-----+");
		System.out.println("Student CGPA [" + cgpa/registeredCourse.size() + "]");
		
	}

	/**
	 * search student by its id
	 * @param studentId student's id.
	 * @return the student u want .
	 */
	private Student searchForStudentById(String studentId)
	{
		for (Student student : students)
		{
			if (student.getStudentId().equals(studentId))
			{
				return student;
			}
		}

		return null;
	}

	/**
	 * search module by its id
	 * @param moduleId module id
	 * @return the module u want.
	 */
	private Module searchForModuleById(String moduleId)
	{
		for (Module module : modules)
		{
			if (module.getModuleId().equals(moduleId))
			{
				return module;
			}
		}

		return null;
	}

	/**
	 * search staff by its id
	 * @param staffId staff's id.
	 * @return the staff u want.
	 */
	private Staff searchForStaffById(String staffId)
	{
		for (Staff staff : staffs)
		{
			if (staff.getStaffId().equals(staffId))
			{
				return staff;
			}
		}

		return null;
	}

	/**
	 * search course by id , year and sem
	 * @param moduleId module id.
	 * @param year which year.
	 * @param semester which sem.
	 * @return the course you want.
	 */
	private Course searchForCourseByIdYearSem(String moduleId, int year, int semester)
	{
		for (Course course : courses)
		{
			if (course.getModuleId().equals(moduleId) && course.getYear() == year && course.getSemester() == semester)
			{
				return course;
			}
		}

		return null;
	}

	/**
	 * search course by its id
	 * @param courseId course Id.
	 * @return the course you want.
	 */
	private Course searchForCourseById(String courseId)
	{
		for (Course course : courses)
		{
			if (course.getCourseId().equals(courseId))
			{
				return course;
			}
		}
		
		return null;
	}

	/**
	 * search group from group list by its id
	 * @param groupId group id.
	 * @param groupList group list
	 * @return the group you want.
	 */
	private Group searchForGroupById(String groupId, ArrayList<Group> groupList)
	{
		for (Group group : groupList)
		{
			if (group.getGroupId().equals(groupId))
			{
				return group;
			}
		}

		return null;
	}

	/**
	 * convert mark to gpa
	 * @param marks marks after calculate its coursework's weightage and exam's weightage.
	 * @return the student's GPA.
	 */
	private float marksToGPA(float marks)
	{
		if (marks >= 80)
		{
			return 4.0f;
		}
		else if (marks >= 70)
		{
			return 3.5f;
		}
		else if (marks >= 60)
		{
			return 3.0f;
		}
		else if (marks >= 50)
		{
			return 2.5f;
		}
		else if (marks >= 40)
		{
			return 2.0f;
		}
		else if (marks >= 30)
		{
			return 1.0f;
		}
		else
		{
			return 0.0f;
		}
	}

}
