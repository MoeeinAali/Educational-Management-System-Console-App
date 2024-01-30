package models;

import java.util.ArrayList;

/**
 * The Student class represents a student in the university course registration system.
 * It includes information such as username, password, and the list of courses associated with the student.
 */
public class Student {
    // Collection of all students in the system
    private static final ArrayList<Student> students = new ArrayList<>();

    private final String username;
    private final String password;
    private final ArrayList<Course> courses;

    /**
     * Private constructor to create a new Student instance with the specified username and password.
     *
     * @param username The username of the student.
     * @param password The password of the student.
     */
    private Student(String username, String password) {
        this.username = username;
        this.password = password;
        this.courses = new ArrayList<>();
    }

    /**
     * Retrieves a Student instance based on the provided username.
     *
     * @param username The username of the student to retrieve.
     * @return The Student instance if found, otherwise null.
     */
    public static Student getStudentByUsername(String username) {
        for (Student student : students) {
            if (student.getUsername().equals(username)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Adds a new student to the collection with the specified username and password.
     *
     * @param username The username of the new student.
     * @param password The password of the new student.
     */
    public static void addStudent(String username, String password) {
        students.add(new Student(username, password));
    }

    /**
     * Enrolls the student in a given course by adding it to the student's list of courses.
     * Additionally, adds the student to the course's list of enrolled students.
     *
     * @param course The course to be taken by the student.
     */
    public void takeCourse(Course course) {
        this.getCourses().add(course);
        course.getStudents().add(this);
    }

    /**
     * Retrieves the username of the student.
     *
     * @return The username of the student.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieves the password of the student.
     *
     * @return The password of the student.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Retrieves the list of courses associated with the student.
     *
     * @return The ArrayList containing all courses associated with the student.
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * Checks if the provided password is correct for the student.
     *
     * @param password The password to be checked.
     * @return True if the password is correct, otherwise false.
     */
    public boolean isPasswordCorrect(String password) {
        return this.getPassword().equals(password);
    }

    public void deleteCourse(String name) {
        this.courses.remove(Course.getCourseByName(name));
    }

}
