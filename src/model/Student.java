package model;

import java.util.*;

public class Student {
    private String id;
    private String name;
    private List<String> enrolledCourses = new ArrayList<>();

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enroll(String courseId) {
        enrolledCourses.add(courseId);
    }

    public void drop(String courseId) {
        enrolledCourses.remove(courseId);
    }

    @Override
    public String toString() {
        return id + " - " + name + " | Courses: " + enrolledCourses;
    }
}
