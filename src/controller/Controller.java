package controller;

import models.Course;
import models.Student;
import models.Teacher;
import view.LoginMenu;
import view.MainMenu;
import view.StudentMenu;
import view.TeacherMenu;

/**
 * The Controller class manages the interaction between the models and views in the university course registration system.
 */
public class Controller {
    private Student loggedInStudent;
    private Teacher loggedInTeacher;
    private final LoginMenu loginMenu;
    private final MainMenu mainMenu;
    private final TeacherMenu teacherMenu;
    private final StudentMenu studentMenu;

    /**
     * Constructs a Controller object, initializing the menus and other necessary components.
     */
    public Controller() {
        loginMenu = new LoginMenu(this);
        mainMenu = new MainMenu(this);
        teacherMenu = new TeacherMenu(this);
        studentMenu = new StudentMenu(this);
    }

    /**
     * Checks if the currently logged-in user is a student.
     *
     * @return True if a student is logged in, otherwise false.
     */
    public boolean isLoggedInUserStudent() {
        return loggedInStudent != null;
    }

    /**
     * Starts the execution of the controller, navigating through login, main, teacher, and student menus.
     */
    public void run() {
        // Works with the login menu
        if (loginMenu.run().equals("exit")) {
            return;
        } else {
            while (true) {
                // Fields of the main menu
                switch (mainMenu.run()) {
                    // Field 1: Teacher menu
                    case "teacher menu":
                        teacherMenu.run();
                        break;
                    // Field 2: Student menu
                    case "student menu":
                        studentMenu.run();
                        break;
                    // Field 3: Logout
                    case "logout":
                        if (loginMenu.run().equals("exit")) {
                            return;
                        }
                        break;
                }
            }
        }
    }

    /**
     * Handles user registration, checking for username existence, strong password, and valid role.
     *
     * @param username The username of the new user.
     * @param password The password of the new user.
     * @param role     The role of the new user (teacher or student).
     * @return A message indicating the success or failure of the registration attempt.
     */
    public String register(String username, String password, String role) {
        // Check if a username already exists
        if (Teacher.getTeacherByUsername(username) != null || Student.getStudentByUsername(username) != null) {
            return "register failed: username already exists";
        }
        // Check for a strong password (length > 5, contains A-Z, a-z, 0-9)
        if (password.length() < 5 || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*[0-9].*")) {
            return "register failed: password is weak";
        }

        // Submit the role of the new user
        if (role.equals("teacher")) {
            Teacher.addTeacher(username, password);
        } else if (role.equals("student")) {
            Student.addStudent(username, password);
        } else {
            return "register failed: invalid role!";
        }
        return "register successful";
    }

    /**
     * Handles user login, checking for correct credentials and updating the logged-in user accordingly.
     *
     * @param username The username of the user attempting to log in.
     * @param password The password of the user attempting to log in.
     * @return A message indicating the success or failure of the login attempt.
     */
    public String login(String username, String password) {
        // Check if the user is a teacher
        if ((loggedInTeacher = Teacher.getTeacherByUsername(username)) != null) {
            if (!loggedInTeacher.isPasswordCorrect(password)) {
                loggedInTeacher = null;
                return "login failed: incorrect password!";
            }
            return "login successful";
        }
        // Check if the user is a student
        else if ((loggedInStudent = Student.getStudentByUsername(username)) != null) {
            if (!loggedInStudent.isPasswordCorrect(password)) {
                loggedInStudent = null;
                return "login failed: incorrect password!";
            }
            return "login successful";
        } else {
            return "login failed: user not found!";
        }
    }

    /**
     * Logs out the currently logged-in user.
     *
     * @return A message indicating the success of the logout attempt.
     */
    public String logout() {
        loggedInStudent = null;
        loggedInTeacher = null;
        return "logout successful";
    }

    /**
     * Adds a new course with the specified name and capacity to the teacher's list of courses.
     *
     * @param name     The name of the new course.
     * @param capacity The capacity of the new course.
     * @return A message indicating the success of adding the course.
     */
    public String addCourse(String name, int capacity) {
        loggedInTeacher.addCourse(name, capacity);
        return "course added successfully";
    }

    /**
     * Displays a list of courses that the logged-in student is enrolled in.
     *
     * @return A string containing the information of the student's enrolled courses.
     */
    public String showMyCourses() {
        StringBuilder result = new StringBuilder();
        for (Course course : loggedInStudent.getCourses()) {
            result.append(course.toString());
            result.append("\n");
        }
        return result.toString();
    }

    /**
     * Displays a list of courses that the logged-in teacher is teaching.
     *
     * @return A string containing the information of the teacher's courses.
     */
    public String showTeacherCourses() {
        StringBuilder result = new StringBuilder();
        for (Course course : loggedInTeacher.getCourses()) {
            result.append(course.toString());
            result.append("\n");
        }
        return result.toString();
    }

    /**
     * Displays a list of all courses available in the system.
     *
     * @return A string containing the information of all courses.
     */
    public String showAllCourses() {
        StringBuilder result = new StringBuilder();
        for (Teacher teacher : Teacher.getTeachers()) {
            for (Course course : teacher.getCourses()) {
                result.append(course.toString());
                result.append("\n");
            }
        }
        return result.toString();
    }

    /**
     * Enrolls the logged-in student in the specified course.
     *
     * @param name The name of the course to be taken by the student.
     * @return A message indicating the success or failure of taking the course.
     */
    public String takeCourse(String name) {
        Course course = Course.getCourseByName(name);
        if (course == null) {
            return "take course failed. Course not found!";
        }
        if (course.isFull()) {
            return "take course failed: full!";
        }
        if (loggedInStudent.getCourses().contains(course)) {
            return "take course failed: you've already taken this course!";
        }
        loggedInStudent.takeCourse(course);
        return "Course taken successfully!";
    }
}
