package org.example.view;

import org.example.controller.Controller;

/**
 * The MainMenu class represents the main menu of the university course registration system.
 * It allows users to navigate to the teacher or student menu or logout from the system.
 */
public class MainMenu {
    private Controller controller;

    /**
     * Constructs a MainMenu object with the specified controller.
     *
     * @param controller The controller responsible for handling the business logic.
     */
    public MainMenu(Controller controller) {
        this.controller = controller;
    }

    /**
     * Runs the main menu, allowing users to choose between teacher menu, student menu, or logout.
     *
     * @return The chosen menu option ("teacher menu", "student menu", or "logout").
     */
    public String run() {
        String command;

        while (true) {
            command = Menu.getScanner().nextLine();

            // Check if the command is to navigate to the teacher menu
            if (command.matches("^\\s*teacher\\s+menu\\s*$")) {
                if (controller.isLoggedInUserStudent()) {
                    System.out.println("Access denied!");
                } else {
                    return "teacher menu";
                }
            }
            // Check if the command is to navigate to the student menu
            else if (command.matches("^\\s*student\\s+menu\\s*$")) {
                if (!controller.isLoggedInUserStudent()) {
                    System.out.println("Access denied!");
                } else {
                    return "student menu";
                }
            }
            // Check if the command is to logout
            else if (command.matches("^\\s*logout\\s*$")) {
                System.out.println(controller.logout());
                return "logout";
            }
            // Handle invalid commands
            else {
                System.out.println("Invalid command!");
            }
        }
    }
}
