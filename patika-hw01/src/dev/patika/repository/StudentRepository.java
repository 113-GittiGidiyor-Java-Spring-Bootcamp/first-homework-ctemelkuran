package dev.patika.repository;

import dev.patika.models.Course;
import dev.patika.models.Student;
import java.util.List;

public interface StudentRepository {
    List<Course> findCoursesOfStudent(int id);
}
