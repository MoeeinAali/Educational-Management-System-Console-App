package view;

import controller.Controller;

import java.util.regex.Matcher;

/**
 * The StudentMenu class represents the menu interface for a student in the educational system.
 * It allows the student to perform various actions, such as taking courses or viewing course information.
 */
public class StudentMenu {
    private Controller controller;

    /**
     * Constructs a StudentMenu object with the specified controller.
     *
     * @param controller The controller responsible for handling the business logic.
     */
    public StudentMenu(Controller controller) {
        this.controller = controller;
    }

    /**
     * Runs the student menu, allowing the student to interact with the system.
     */
    public void run() {
        Matcher matcher;
        String command;

        while (true) {
            command = Menu.getScanner().nextLine();

            // Check if the command is to go back
            if (command.matches("^\\s*back\\s*")) {
                return;
            }

            // Check if the command is to take a course
            if ((matcher = Menu.getMatcher(command, "^\\s*take\\s+course\\s+(?<name>\\S+)\\s*$")) != null) {
                System.out.println(controller.takeCourse(matcher.group("name")));
            }
            // Check if the command is to delete a course
            if ((matcher = Menu.getMatcher(command, "^\\s*delete\\s+course\\s+(?<name>\\S+)\\s*$")) != null) {
                System.out.println(controller.deleteCourse(matcher.group("name")));
            }

            // Check if the command is to show student's courses
            else if (command.matches("^\\s*show\\s+my\\s+courses\\s*$")) {
                System.out.println(controller.showMyCourses());
            }
            // Check if the command is to show all courses
            else if (command.matches("^\\s*show\\s+all\\s+courses\\s*$")) {
                System.out.println(controller.showAllCourses());
            }

        }
    }
}
