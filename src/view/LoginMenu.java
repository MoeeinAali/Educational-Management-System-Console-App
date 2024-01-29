package view;

import controller.Controller;

import java.util.regex.Matcher;

public class LoginMenu {
    private Controller controller;

    public LoginMenu(Controller controller) {
        this.controller = controller;
    }

    public String run() {
        RegexContainer regexContainer = new RegexContainer("../Regexes.properties");
        Matcher matcher;
        String command, result;
        while (true) {
            command = Menu.getScanner().nextLine();
            if (command.matches(regexContainer.getRegex("EXIT"))) {
                return "exit";
            }
            if ((matcher = Menu.getMatcher(command, regexContainer.getRegex("REGISTER"))) != null) {
                System.out.println(controller.register(matcher.group("username"), matcher.group("password"), matcher.group("role")));
            } else if ((matcher = Menu.getMatcher(command, regexContainer.getRegex("LOGIN"))) != null) {
                result = controller.login(matcher.group("username"), matcher.group("password"));
                System.out.println(result);
                if (result.equals("login successful")) {
                    return "Logged in";
                }
            } else {
                System.out.println("Invalid Command!");
            }
        }
    }
}
