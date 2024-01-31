package org.example.view;

import org.example.controller.Controller;

import java.util.regex.Matcher;

/**
 * The LoginMenu class represents the menu for user authentication and registration in the university course registration system.
 */
public class LoginMenu {
    private Controller controller;

    /**
     * Constructs a LoginMenu object with the specified controller.
     *
     * @param controller The controller responsible for handling the business logic.
     */
    public LoginMenu(Controller controller) {
        this.controller = controller;
    }

    /**
     * Runs the login menu, allowing users to register, login, or exit the system.
     *
     * @return The result of the login or registration attempt ("Logged in", "exit", or other relevant messages).
     */
    public String run() {
        Matcher matcher;
        String command, result;

        while (true) {
            command = Menu.getScanner().nextLine();

            // Check if the command is to exit
            if (command.matches("^\\s*exit\\s*$")) {
                return "exit";
            }

            // Check if the command is to register a new user
            if ((matcher = Menu.getMatcher(command, "^\\s*register\\s+(?<role>\\S+)\\s+(?<username>\\S+)\\s+(?<password>\\S+)\\s*$")) != null) {
                System.out.println(controller.register(matcher.group("username"), matcher.group("password"), matcher.group("role")));
            }
            // Check if the command is to login
            else if ((matcher = Menu.getMatcher(command, "^\\s*login\\s+(?<username>\\S+)\\s+(?<password>\\S+)\\s*$")) != null) {
                result = controller.login(matcher.group("username"), matcher.group("password"));
                System.out.println(result);
                // Return "Logged in" if login is successful
                if (result.equals("login successful")) {
                    return "Logged in";
                }
            }
            // Handle invalid commands
            else {
                System.out.println("Invalid command!");
            }
        }
    }
}
