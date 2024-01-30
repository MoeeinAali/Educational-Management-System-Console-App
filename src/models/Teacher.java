package models;

import java.util.ArrayList;

/**
 * The Teacher class represents a teacher in the university course registration system.
 * It includes information such as username, password, and the list of courses associated with the teacher.
 */
public class Teacher {
    // Collection of all teachers in the system
    public static final ArrayList<Teacher> teachers = new ArrayList<>();

    private final String username;
    private final String password;
    private final ArrayList<Course> courses;

    /**
     * Private constructor to create a new Teacher instance with the specified username and password.
     *
     * @param username The username of the teacher.
     * @param password The password of the teacher.
     */
    private Teacher(String username, String password) {
        this.username = username;
        this.password = password;
        this.courses = new ArrayList<>();
    }

    /**
     * Retrieves a Teacher instance based on the provided username.
     *
     * @param username The username of the teacher to retrieve.
     * @return The Teacher instance if found, otherwise null.
     */
    public static Teacher getTeacherByUsername(String username) {
        for (Teacher teacher : teachers) {
            if (teacher.getUsername().equals(username)) {
                return teacher;
            }
        }
        return null;
    }

    /**
     * Adds a new teacher to the collection with the specified username and password.
     *
     * @param username The username of the new teacher.
     * @param password The password of the new teacher.
     */
    public static void addTeacher(String username, String password) {
        teachers.add(new Teacher(username, password));
    }

    /**
     * Adds a new course to the teacher's list of courses with the specified name and capacity.
     *
     * @param name     The name of the new course.
     * @param capacity The capacity of the new course.
     */
    public void addCourse(String name, int capacity) {
        this.courses.add(new Course(name, capacity, this));
    }

    /**
     * Retrieves the collection of all teachers in the system.
     *
     * @return The ArrayList containing all teachers.
     */
    public static ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Retrieves the username of the teacher.
     *
     * @return The username of the teacher.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieves the password of the teacher.
     *
     * @return The password of the teacher.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Retrieves the list of courses associated with the teacher.
     *
     * @return The ArrayList containing all courses associated with the teacher.
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * Checks if the provided password is correct for the teacher.
     *
     * @param password The password to be checked.
     * @return True if the password is correct, otherwise false.
     */
    public boolean isPasswordCorrect(String password) {
        return this.getPassword().equals(password);
    }
}
