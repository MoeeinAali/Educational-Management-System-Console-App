package model;

import java.util.ArrayList;

public class Teacher {
    public static final ArrayList<Teacher> teachers = new ArrayList<>();
    private final String username;
    private final String password;
    private final ArrayList<Course> courses;

    private Teacher(String username, String password) {
        this.username = username;
        this.password = password;
        this.courses = new ArrayList<>();
    }

    public static Teacher getTeacherByUsername(String username) {
        for (Teacher i : teachers) {
            if (i.getUsername().equals(username)) {
                return i;
            }
        }
        return null;
    }

    public static ArrayList<Teacher> getTeachers() {
//        return this.teachers;
        return teachers;
    }
    public String getUsername(){
//        return this.username;
        return username;
    }
    public String getPassword(){
//        return this.password;
        return password;
    }
    public ArrayList<Course> getCourses(){
        return courses;
//        return this.courses;
    }
    public boolean isPasswordCorrect(String password){
        return this.getPassword().equals(password);
    }
}
