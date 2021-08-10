package dev.patika.models;

import java.util.Objects;

public class Course {
    private String courseCode;
    private String courseName;
    private int creditScore;

    public Course(String courseCode, String courseName, int creditScore) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditScore = creditScore;
    }

    public Course() {
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }


    // only the Course Code is included to equals & hashCode because it is unique.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", creditScore=" + creditScore +
                '}';
    }
}
