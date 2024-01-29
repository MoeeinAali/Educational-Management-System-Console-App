package controller;

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
    public void run(){

    }


}

