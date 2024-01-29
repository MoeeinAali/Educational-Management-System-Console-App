package view;

import controller.Controller;

import java.util.regex.Matcher;

public class TeacherMenu {
    private Controller controller;

    public TeacherMenu(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        RegexContainer regexContainer = new RegexContainer("../Regexes.properties");
        Matcher matcher;
        String command;
        while (true) {
            command = Menu.getScanner().nextLine();
            if (command.matches(regexContainer.getRegex("BACK"))) {
                return;
            }
            if ((matcher = Menu.getMatcher(command, regexContainer.getRegex("ADD_COURSE"))) != null) {
                System.out.println(controller.addCourse(matcher.group("name"), Integer.parseInt(matcher.group("capacity"))));
            } else if (command.matches(regexContainer.getRegex("ALL_COURSE"))) {
                System.out.println(controller.showAllCourses());
            }
            else {
                System.out.println("Invalid Command");
            }
        }
    }


}
