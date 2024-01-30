package models;

import java.util.ArrayList;

/**
 * The {@code Course} class represents a course in the university.
 * It includes information such as the course name, capacity, instructor
 * (teacher),
 * and a list of students enrolled in the course.
 */
public class Course {
    private final String name;
    private final int capacity;
    private final Teacher teacher;
    private final ArrayList<Student> students;

    /**
     * Constructs a new course with the specified name, capacity, and instructor.
     *
     * @param name     The name of the course.
     * @param capacity The maximum capacity of the course.
     * @param teacher  The instructor (teacher) of the course.
     */
    public Course(String name, int capacity, Teacher teacher) {
        this.name = name;
        this.capacity = capacity;
        this.teacher = teacher;
        students = new ArrayList<>();
    }

    /**
     * Retrieves a course by its name.
     *
     * @param name The name of the course to retrieve.
     * @return The {@code Course} object if found, or {@code null} if not found.
     */
    public static Course getCourseByName(String name) {
        for (Teacher i : Teacher.getTeachers()) {
            for (Course j : i.getCourses()) {
                if (j.getName().equals(name)) {
                    return j;
                }
            }
        }
        return null;
    }

    /**
     * Checks if the course is full, i.e., the number of enrolled students
     * equals the maximum capacity of the course.
     *
     * @return {@code true} if the course is full, {@code false} otherwise.
     */
    public boolean isFull() {
        return students.size() == capacity;
    }

    /**
     * Gets the current number of enrolled students in the course.
     *
     * @return The number of enrolled students.
     */
    public int getSize() {
        return students.size();
    }

    /**
     * Gets the maximum capacity of the course.
     *
     * @return The maximum capacity of the course.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the name of the course.
     *
     * @return The name of the course.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of students enrolled in the course.
     *
     * @return The list of enrolled students.
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Overrides the default {@code toString()} method to provide a customized
     * string representation of the course.
     *
     * @return A string representation of the course.
     */
    @Override
    public String toString() {
        return name + " | Instructor: " + teacher.getUsername() + " | Capacity: " + students.size() + "/" + capacity;
    }
}
