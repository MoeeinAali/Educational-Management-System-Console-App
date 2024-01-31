package org.example.models;

import java.util.ArrayList;

public class Student_db {

    public static final ArrayList<Student> students = new ArrayList<>();

    public final String username;
    public final String password;
    public final ArrayList<String> courses;


    public Student_db(Student student) {
        this.username = student.getUsername();
        this.password = student.getPassword();
        this.courses = new ArrayList<String>();
        for (Course i : student.getCourses()) {
            courses.add(i.getName());
        }
    }
}
