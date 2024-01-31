package org.example.models;

import java.util.ArrayList;

public class Course_db {
    public final String name;
    public int capacity;
    public final String teacher;
    public final ArrayList<String> students;

    public Course_db(Course course) {
        this.name = course.getName();
        this.teacher = course.getTeacher().getUsername();
        this.capacity = course.getCapacity();
        this.students = new ArrayList<String>();
        for (Student i : course.getStudents()) {
            this.students.add(i.getUsername());
        }
    }
}
