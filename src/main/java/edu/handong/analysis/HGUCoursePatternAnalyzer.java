package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students;
	private Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		
		Student[] stdnt = new Student[numOfStudents];
		String[] templines = new String[lines.length];
		
		for(int i = 0; i < lines.length; i++) {
			templines[i] = lines[i].split(",")[1];
			templines[i] = templines[i].trim();
        }
		
		for(int i = 0, j = 0; j < numOfStudents; i++) {
			stdnt[j] = new Student(templines[i]);
			if(studentExist(stdnt, stdnt[j])) {
				continue;
			}
			j++;
		}
		
		return stdnt;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		
		int cnt = 0;
		
		String s1 = student.getName();
		
		for(Student stnt: students) {
			if(stnt != null) {
				if(stnt.getName().equals(s1))
					cnt++;
			}
		}
		
		if(cnt > 1) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		Course[] crs = new Course[numOfCourses];
		String[] templines = new String[lines.length];
		
		for(int i = 0; i < lines.length; i++) {
			templines[i] = lines[i].split(",")[2];
			templines[i] = templines[i].trim();
        }
		
		for(int i = 0, j = 0; j < numOfCourses; i++) {
			crs[j] = new Course(templines[i]);
			if(courseExist(crs, crs[j])) {
				continue;
			}
			j++;
		}
		
		return crs;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		int cnt = 0;
		
		String s1 = course.getCourseName();
		
		for(Course crs: courses) {
			if(crs != null) {
				if(crs.getCourseName().equals(s1))
					cnt++;
			}
			
		}
		if(cnt > 1) {
			return true;
		}else {
			return false;
		}
	}

}
