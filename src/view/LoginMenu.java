package view;

import controller.Controller;

import java.util.regex.Matcher;

public class LoginMenu {
    private Controller controller;

    public LoginMenu(Controller controller) {
        this.controller = controller;
    }

    public String run() {
        Matcher matcher;
        String command, result;
        while (true) {
            command = Menu.getScanner().nextLine();
            if (command.matches(regexContainer.getRegex("EXIT"))) {
                return "exit";
            }


        }
    }


}
