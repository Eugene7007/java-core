package Lesson5;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private Teacher teacher;
    private List< Student > students = new ArrayList<>();

    public Course( String courseId, String courseName, Teacher teacher ) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacher = teacher;
    }

    public void addStudent( Student student ) {
        students.add( student );
    }

    public void markAttendance( String studentId, String date, boolean present ) {
        for ( Student student : students ) {
            if ( student.getId().equals( studentId ) ) {
                student.markAttendance( date, present );
                break;
            }
        }
    }

    public void assignScore( String studentId, double score ) {
        for ( Student student : students ) {
            if ( student.getId().equals( studentId ) ) {
                student.setScore( score );
                break;
            }
        }
    }

    public void displayCourseDetails() {
        System.out.println( "\nCourse: " + courseName + " (ID: " + courseId + ")" );
        teacher.displayInfo();
        for ( Student s : students ) {
            s.displayInfo();
        }
    }
}
