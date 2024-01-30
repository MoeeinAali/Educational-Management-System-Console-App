package view;

import org.jetbrains.annotations.Nullable;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static @Nullable Matcher getMatcher(String command, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(command);
        if (matcher.matches()) {
            return matcher;
        } else {
            return null;
        }
    }

    public static Scanner getScanner() {
        return scanner;
    }

}