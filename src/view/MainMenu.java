package view;
import controller.Controller;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class MainMenu {
    private Controller controller;

    public MainMenu(Controller controller) {
        this.controller = controller;
    }

    public String run() {
        RegexContainer regexContainer = new RegexContainer("../Regexes.properties");

        String command;
        while (true) {
            command = Menu.getScanner().nextLine();
            if (command.matches(regexContainer.getRegex("TEACHER_MENU"))){
                if (controller.isLoggedInUserStudent()){
                    System.out.println("Access Denied!");
                }
                else {
                    return "teacher menu";
                }
            } else if (command.matches(regexContainer.getRegex("STUDENT_MENU")))) {
                
            }


        }
    }
}