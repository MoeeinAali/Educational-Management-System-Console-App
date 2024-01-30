import controller.Controller;

/**
 * The Main class serves as the entry point for the simple university course registration software.
 * It initializes a Controller and starts the program execution by invoking the run method.
 */
public class Main {
    /**
     * Main method: Program starts with the creation of a Controller instance and calling its run method.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Program Starts with a Controller
        Controller controller = new Controller();
        controller.run();
    }
}
