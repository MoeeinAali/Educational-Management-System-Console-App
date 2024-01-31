package org.example.models;

import java.util.ArrayList;

public class Teacher_db {
    public static final ArrayList<Teacher> teachers = new ArrayList<>();

    public final String username;
    public final String password;
    public final ArrayList<String> courses;

    public Teacher_db(Teacher teacher) {
        this.username = teacher.getUsername();
        this.password = teacher.getPassword();
        this.courses = new ArrayList<String>();
        for (Course i : teacher.getCourses()) {
            courses.add(i.getName());
        }
    }


}
