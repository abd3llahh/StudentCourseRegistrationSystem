package model;

import java.util.Objects;

public class Course {
    private String id;
    private String name;
    private int capacity;
    private int enrolledCount = 0;

    public Course(String id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public int getEnrolledCount() { return enrolledCount; }

    public boolean isFull() {
        return enrolledCount >= capacity;
    }

    public void incrementEnrollment() {
        if (!isFull()) {
            enrolledCount++;
        }
    }

    public void decrementEnrollment() {
        if (enrolledCount > 0) {
            enrolledCount--;
        }
    }

    @Override
    public String toString() {
        return id + " - " + name + " (Capacity: " + enrolledCount + "/" + capacity + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
