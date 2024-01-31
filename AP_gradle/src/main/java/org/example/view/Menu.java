package org.example.view;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Menu class provides utility methods for handling user input and regex matching in the program menu.
 */
public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Retrieves a Matcher object for the specified command and regex.
     *
     * @param command The user command to be matched against the regex.
     * @param regex   The regular expression pattern to match the command.
     * @return A Matcher object if the command matches the regex, otherwise null.
     */
    public static Matcher getMatcher(String command, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(command);
        if (matcher.matches()) {
            return matcher;
        } else {
            return null;
        }
    }

    /**
     * Retrieves the Scanner object for reading user input.
     *
     * @return The Scanner object for reading user input.
     */
    public static Scanner getScanner() {
        return scanner;
    }
}
