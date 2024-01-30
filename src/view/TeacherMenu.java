package view;

import controller.Controller;

import java.util.regex.Matcher;

/**
 * The TeacherMenu class represents the menu interface for a teacher in the educational system.
 * It allows the teacher to perform various actions, such as adding courses or viewing course information.
 */
public class TeacherMenu {
    private Controller controller;

    /**
     * Constructs a TeacherMenu object with the specified controller.
     *
     * @param controller The controller responsible for handling the business logic.
     */
    public TeacherMenu(Controller controller) {
        this.controller = controller;
    }

    /**
     * Runs the teacher menu, allowing the teacher to interact with the system.
     */
    public void run() {
        Matcher matcher;
        String command;

        while (true) {
            command = Menu.getScanner().nextLine();

            // Check if the command is to go back
            if (command.matches("^\\s*back\\s*"))
                return;

            // Check if the command is to add a course
            if ((matcher = Menu.getMatcher(command, "^\\s*add\\s+course\\s+(?<name>\\S+)\\s+(?<capacity>\\d+)\\s*$")) != null)
                System.out.println(controller.addCourse(matcher.group("name"), Integer.parseInt(matcher.group("capacity"))));
                // Check if the command is to show all courses
            else if (command.matches("^\\s*show\\s+all\\s+courses\\s*$"))
                System.out.println(controller.showAllCourses());
                // Check if the command is to show teacher's courses
            else if (command.matches("^\\s*show\\s+my\\s+courses\\s*$"))
                System.out.println(controller.showTeacherCourses());
                // Handle invalid commands
            else
                System.out.println("invalid command!");
        }
    }
}
