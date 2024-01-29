package controller;

import model.Course;
import model.Student;
import model.Teacher;
import view.LoginMenu;
import view.MainMenu;
import view.StudentMenu;
import view.TeacherMenu;

import javax.print.attribute.standard.NumberUp;

public class Controller {
    private Student loggedInStudent;
    private Teacher loggedInTeacher;
    private final LoginMenu loginMenu;
    private final MainMenu mainMenu;
    private final TeacherMenu teacherMenu;
    private final StudentMenu studentMenu;

    public Controller() {
        loginMenu = new LoginMenu(this);
        mainMenu = new MainMenu(this);
        teacherMenu = new TeacherMenu(this);
        studentMenu = new StudentMenu(this);
    }

    public boolean isLoggedInUserStudent() {
        if (loggedInStudent == null) {
            return false;
        } else {
            return true;
        }
    }

    public void run() {
        if (loginMenu.run().equals("exit")) {
            return;
        } else {
            while (true) {
                switch (mainMenu.run()) {
                    case "teacher menu":
                        teacherMenu.run();
                        break;
                    case "student menu":
                        studentMenu.run();
                        break;
                    case "logout":
                        if (loginMenu.run().equals("exit")) {
                            return;
                        }
                        break;
                }
            }
        }

    }

    public String register(String username, String password, String role) {
        if (Teacher.getTeacherByUsername(username) != null || Student.getStudentByUsername(username) != null) {
            return "register failed: username already exists";
        }
        if (password.length() < 5 || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*[0-9].*")) {
            return "register failed: password is weak";
        }
        if (role.equals("teacher")) {
            Teacher.addTeacher(username, password);
        } else if (role.equals("student")) {
            Student.addStudent(username, password);
        } else {
            return "register failed: invalid role!";
        }
        return "register successful";
    }

    public String login(String username, String password) {
        if ((loggedInTeacher = Teacher.getTeacherByUsername(username)) != null) {
            if (loggedInTeacher.isPasswordCorrect(password) != true) {
                loggedInTeacher = null;
                return "login failed: incorrect password!";
            }
            return "login successful";
        } else if ((loggedInStudent = Student.getStudentByUsername(username)) != null) {
            if (loggedInStudent.isPasswordCorrect(password) != true) {
                loggedInStudent = null;
                return "login failed: incorrect password!";
            }
            return "login successful";
        } else {
            return "login failed: user not found!";
        }
    }

    public String logout() {
        loggedInStudent = null;
        loggedInTeacher = null;
        return "logout successful";
    }

    public String addCourse(String name, int capacity) {
        loggedInTeacher.addCourse(name, capacity);
        return "course added successfully";
    }
    public String showMyCourses(){
        StringBuilder result = new StringBuilder();
        for (Course i : this.loggedInStudent.getCourses()){
            result.append(i.toString());
            result.append("\n");
        }
        return result.toString();
    }



}

