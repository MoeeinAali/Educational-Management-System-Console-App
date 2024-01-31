package org.example.models;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Database {
    public ArrayList<Teacher_db> teacher_dbs = new ArrayList<Teacher_db>();
    public ArrayList<Student_db> student_dbs = new ArrayList<Student_db>();
    public ArrayList<Course_db> course_dbs = new ArrayList<Course_db>();


    public static void save() {
        Database db = new Database();
        for (Teacher i : Teacher.getTeachers()) {
            db.teacher_dbs.add(new Teacher_db(i));
        }
        for (Teacher i : Teacher.getTeachers()) {
            for (Course j : i.getCourses()) {
                db.course_dbs.add(new Course_db(j));
            }
        }
        for (Student i : Student.getStudents()) {
            db.student_dbs.add(new Student_db(i));
        }

        Gson gson = new Gson();
        gson.toJson(db);
        String folderPath = new File("").getAbsolutePath() + "/database.json";
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(folderPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gson.toJson(db, fileWriter);
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void load() {
        Gson gson = new Gson();
        String folderPath = new File("").getAbsolutePath() + "./database.json";
        FileReader fileReader;
        try {
            fileReader = new FileReader(folderPath);
        } catch (IOException e) {
            return;
        }
        Database db = gson.fromJson(fileReader, Database.class);
        try {
            fileReader.close();
        } catch (IOException e) {
            return;
        }

        for (Teacher_db i : db.teacher_dbs){
            Teacher.addTeacher(i.username,i.password);
        }
        for (Student_db i : db.student_dbs){
            Student.addStudent(i.username , i.password);
        }
        for (Course_db i : db.course_dbs){
            Course crs = Teacher.getTeacherByUsername(i.teacher).addCourse(i.name , i.capacity);
            for (String user : i.students){
                Student st = Student.getStudentByUsername(user);
                st.takeCourse(crs);
            }
        }
    }

}
