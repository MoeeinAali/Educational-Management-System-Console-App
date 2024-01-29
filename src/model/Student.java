package model;

import java.util.ArrayList;

public class Student {
    private static final ArrayList<Student> students = new ArrayList<>();
    private final String username;
    private final String password;
    private final ArrayList<Course> courses;

    private Student(String username, String password) {
        this.username = username;
        this.password = password;
        this.courses = new ArrayList<>();
    }

    public static Student getStudentByUsername(String username) {
        for (Student i : students) {
            if (i.getUsername().equals(username)) {
                return i;
            }
        }
        return null;
    }
}

