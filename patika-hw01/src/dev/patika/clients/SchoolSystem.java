package dev.patika.clients;

import dev.patika.controller.StudentController;
import dev.patika.models.*;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class SchoolSystem {

    public static void main(String[] args) {
        // Save newly created data to the database
        // saveTestData();

        StudentController sController = new StudentController();
        /*Student student4 = new Student("Travis Scott", LocalDate.of(1988, Month.JUNE, 20), "Los Angeles", "Male");
        sController.saveStudent(student4);*/

       /* sController.deleteStudent(4); */

        List<Student> returnedList = new StudentController().findAllStudents();

        for (Student student : returnedList) {
            System.out.println(student);
        }

        // Test for finding courses of a student
        System.out.println("Course of student " + returnedList.get(0).getName());
        List<Course> courseList = sController.findCoursesOfStudent(1);
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println((i+1) + " -> " + courseList.get(i).getCourseName());
        }

    }

    private static void saveTestData() {


        // Objects of models are created
        Student student1 = new Student("Cigir Temelkuran", LocalDate.of(1997, Month.JUNE, 27), "Izmir", "Male");
        Student student2 = new Student("Jake Peralta", LocalDate.of(1988, Month.JANUARY, 2), "New York", "Male");
        Student student3 = new Student("Fatma Abaci", LocalDate.of(1996, Month.APRIL, 10), "Izmir", "Female");

        Instructor instructor1 = new PermenantInstructor("Koray Guney", "Istanbul", "+905551234567", 5000);
        Instructor instructor2 = new PermenantInstructor("Severus Snape", "London", "+445551234568", 6000);
        Instructor instructor3 = new VisitingResearcher("Bill Gates", "Washington", "+15551234569", 1000);

        Course course1 = new Course("CS50", "Introduction to CS", 6);
        Course course2 = new Course("UBI501", "District Math", 6);
        Course course3 = new Course("UBI503", "DSA", 8);
        Course course4 = new Course("UBI505", "Computer Vision", 8);

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor1);
        course3.setInstructor(instructor2);
        course4.setInstructor(instructor3);

        course1.getStudents().add(student1);
        course1.getStudents().add(student2);
        course1.getStudents().add(student3);
        course2.getStudents().add(student1);
        course2.getStudents().add(student2);
        course3.getStudents().add(student3);
        course4.getStudents().add(student2);

        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        student2.getCourses().add(course1);
        student2.getCourses().add(course3);
        student3.getCourses().add(course4);

        instructor1.getInstructorCourses().add(course1);
        instructor1.getInstructorCourses().add(course2);
        instructor2.getInstructorCourses().add(course3);
        instructor3.getInstructorCourses().add(course4);



        // persistence.xml'de tanımlanan persistenceUnitName'i çağırdık
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        // Code block can be surrounded with Ctrl+Alt+T
        try {
            // Start the transaction
            em.getTransaction().begin();

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);
            em.persist(course4);

            em.persist(student1);
            em.persist(student2);
            em.persist(student3);

            em.persist(instructor1);
            em.persist(instructor2);
            em.persist(instructor3);
            // commit edilene kadar persist ile kayıt yapılmaz, commit ile toplu şekilde kayıt yapar
            em.getTransaction().commit();

            System.out.println("All data persisted!");
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em); // EM is closed in any condition
        }

    }
}
