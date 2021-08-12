package dev.patika.controller;

import dev.patika.models.Course;
import dev.patika.models.Student;
import dev.patika.service.StudentService;

import java.util.*;

public class StudentController {
    private StudentService studentService = new StudentService();

    public Student findStudent(int studId){
        return studentService.findById(studId);
    }

    public List<Student> findAllStudents(){
        return studentService.findAll();
    }

    public void saveStudent(Student student){
        studentService.saveToDatabase(student);
    }

    public void deleteStudent(int id){
        studentService.deleteFromDatabase(id);
    }

    public List<Course> findCoursesOfStudent(int id){
        return studentService.findCoursesOfStudent(id);
    }
}
