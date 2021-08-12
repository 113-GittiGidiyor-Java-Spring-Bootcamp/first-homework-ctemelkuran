package dev.patika.service;

import dev.patika.models.Course;
import dev.patika.models.Student;
import dev.patika.repository.CrudRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student> {

    // Entity manager object is needed for methods
    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");


    @Override
    public List<Student> findAll() {
        // Query is needed for multiple data
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        // find method only returns one data
        return em.find(Student.class,id);
    }

    @Override
    public void saveToDatabase(Student student) {
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDatabase(Student object) {

    }

    @Override
    public void deleteFromDatabase(int id) {
        try {
            em.getTransaction().begin();

            Student foundStudent = em.find(Student.class, id);
            em.remove(foundStudent);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }

    }

    @Override
    public void updateOnDatabase(Student student, int id) {
        try {
            em.getTransaction().begin();

            Student foundStudent = em.find(Student.class, id);
            foundStudent.setAddress(student.getAddress());
            foundStudent.setName(student.getName());
            foundStudent.setBirthDate(student.getBirthDate());
            foundStudent.setGender(student.getGender());
            em.merge(foundStudent);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        } 
    }

    @Override
    public List<Course> findCoursesOfStudent(int id) {
        return findById(id).getCourses();
    }


}
