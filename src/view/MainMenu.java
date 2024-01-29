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
            if (command.matches(regexContainer.getRegex("TEACHER_MENU")){

            }

        }
    }
}