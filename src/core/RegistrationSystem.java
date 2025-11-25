package core;

import model.Course;
import model.Student;

import java.util.*;

public class RegistrationSystem {

    private Map<String, Course> courses = new HashMap<>();
    private Map<String, Student> students = new HashMap<>();

    // ------------------------------
    // ADD FUNCTIONS
    // ------------------------------

    public boolean addCourse(String id, String name, int capacity) {
        if (courses.containsKey(id)) {
            System.out.println("❌ Course with this ID already exists.");
            return false;
        }

        courses.put(id, new Course(id, name, capacity));
        System.out.println("✔ Course added successfully.");
        return true;
    }

    public boolean addStudent(String id, String name) {
        if (students.containsKey(id)) {
            System.out.println("❌ Student with this ID already exists.");
            return false;
        }

        students.put(id, new Student(id, name));
        System.out.println("✔ Student added successfully.");
        return true;
    }

    // ------------------------------
    // ENROLL / DROP
    // ------------------------------

    public boolean enrollStudent(String studentId, String courseId) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);

        if (student == null || course == null) {
            System.out.println("❌ Invalid student or course ID.");
            return false;
        }

        if (student.getEnrolledCourses().contains(courseId)) {
            System.out.println("❌ Student is already enrolled in this course.");
            return false;
        }

        if (course.isFull()) {
            System.out.println("❌ Course is full.");
            return false;
        }

        student.enroll(courseId);
        course.incrementEnrollment();

        System.out.println("✔ Student enrolled successfully.");
        return true;
    }

    public boolean dropStudent(String studentId, String courseId) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);

        if (student == null || course == null) {
            System.out.println("❌ Invalid student or course ID.");
            return false;
        }

        if (!student.getEnrolledCourses().contains(courseId)) {
            System.out.println("❌ Student is not enrolled in this course.");
            return false;
        }

        student.drop(courseId);
        course.decrementEnrollment();

        System.out.println("✔ Course dropped successfully.");
        return true;
    }

    // ------------------------------
    // LISTS
    // ------------------------------

    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        courses.values().forEach(System.out::println);
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        students.values().forEach(System.out::println);
    }

    // ------------------------------
    // SEARCH
    // ------------------------------

    public void searchCourse(String keyword) {
        System.out.println("\n🔍 Search results:");

        courses.values().stream()
                .filter(course -> course.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                        course.getId().toLowerCase().contains(keyword.toLowerCase()))
                .forEach(System.out::println);
    }

    public void searchStudent(String keyword) {
        System.out.println("\n🔍 Search results:");

        students.values().stream()
                .filter(student -> student.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                        student.getId().toLowerCase().contains(keyword.toLowerCase()))
                .forEach(System.out::println);
    }

    // ------------------------------
    // GETTERS
    // ------------------------------

    public Map<String, Course> getCourses() { return courses; }
    public Map<String, Student> getStudents() { return students; }

    public void displayAllStudents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayAllStudents'");
    }
}

