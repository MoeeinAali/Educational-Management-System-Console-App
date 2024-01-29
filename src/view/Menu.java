package view;

import java.util.Scanner;
import java.util.regex.*;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static Matcher getMatcher(String command, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(command);
        if (matcher.matches() == true) {
            return matcher;
        } else {
            return null;
        }
    }

}
