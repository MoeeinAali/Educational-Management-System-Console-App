package view;

import controller.Controller;
import model.Student;

import java.util.regex.Matcher;

public class StudentMenu {
    private Controller controller;

    public StudentMenu(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        Matcher matcher;
        String command;
        RegexContainer regexContainer = new RegexContainer("../Regexes.properties");
        while (true) {
            command = Menu.getScanner().nextLine();
            if (command.matches(regexContainer.getRegex("BACK"))) {
                return;
            }
            if ((matcher = Menu.getMatcher(command,regexContainer.getRegex("TAKE_COURSE")))!=null){
                System.out.println(controller.takeCourse(matcher.group("name")));
            } else if (command.matches(regexContainer.getRegex("SHOW_MY_COURSES"))) {
                System.out.println(controller.showMyCourses());
            } else if (command.matches(regexContainer.getRegex("ALL_COURS"))) {
                System.out.println(controller.showAllCourses);
            }else {
                System.out.println("Invalid Command!");
            }
        }
    }
}
