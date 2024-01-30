package models;

import java.util.ArrayList;

public class Course {
    private final String name;
    private final int capacity;
    private final Teacher teacher;
    private final ArrayList<Student> students;

    public Course(String name, int capacity, Teacher teacher) {
        this.name = name;
        this.capacity = capacity;
        this.teacher = teacher;
        students = new ArrayList<>();
    }

    public static Course getCourseByName(String name) {
        for (Teacher i : Teacher.getTeachers()) {
            for (Course j : i.getCourses()) {
                if (j.getName().equals(name)) {
                    return j;
                }
            }
        }
        return null;
    }

    public boolean isFull() {
        if (students.size() == capacity) {
            return true;
        } else {
            return false;
        }
    }

    public int getSize() {
        return students.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return name + " | Instructor: " + teacher.getUsername() + " | Capacity: " + students.size() + "/" + capacity;
    }
}
