package dev.patika.repository;

import dev.patika.models.Course;

import java.util.List;

public interface CrudRepository<T> {

    List<T> findAll();
    T findById(int id);
    void saveToDatabase(T object);
    void deleteFromDatabase(T object);
    void deleteFromDatabase(int id);
    void updateOnDatabase(T object, int id);

    List<Course> findCoursesOfStudent(int id);
}
