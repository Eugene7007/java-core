package Lesson5;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
    private Map<String, Boolean> attendanceLog = new HashMap<>();
    @Getter
    @Setter
    private double score;

    public Student(String name, String id) {
        super(name, id);
    }

    public void markAttendance(String date, boolean present) {
        attendanceLog.put(date, present);
    }

    public void displayAttend() {
        System.out.printf("Attendance for %s:", getName());
        for (Map.Entry<String, Boolean> entry : attendanceLog.entrySet()) {
            String status = entry.getValue() ? "Present" : "Absent";
            System.out.printf("  %s -> %s%n", entry.getKey(), status);
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Student: " + getName() + " (ID: " + getId() + "), Score: " + score);
    }
}
