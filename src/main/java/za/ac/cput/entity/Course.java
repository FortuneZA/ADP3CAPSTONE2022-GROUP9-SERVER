package za.ac.cput.entity;

import javax.persistence.*;
import java.util.List;

/* Course.java
 Class for the Course entity
 Author: Mathew Fortuin -219069514
 Date: 15/03/2022
*/

@Entity
@Table(name="course")
public class Course {


    @Id
    private String courseId;
    private  String courseName;
    private String courseDescription;
    @ElementCollection
    private List<String> subjectList;
    private String departmentId;

    //Default constructor

    protected Course() {

    }

    //Builder Constructor

    public Course(Builder builder) {
        this.courseId = builder.courseId;
        this.courseName = builder.courseName;
        this.courseDescription = builder.courseDescription;
        this.subjectList=builder.subjectList;
        this.departmentId = builder.departmentId;
    }



    //Getters


    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public List getSubjectList(){return subjectList;}

    public String getDepartmentId() {
        return departmentId;
    }

    //Builder Class

    public static class Builder {
        private String courseId;
        private String courseName;
        private String courseDescription;
        private List subjectList;
        private String departmentId;



        public Builder setCourseId(String courseId) {
            this.courseId = courseId;
            return this;
        }

        public Builder setCourseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        public Builder setCourseDescription(String courseDescription) {
            this.courseDescription = courseDescription;
            return this;
        }

        public Builder setSubjectList(List subjectList) {
            this.subjectList = subjectList;
            return this;
        }

        public Builder setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Course build() {
            return new Course(this);
        }

        public Course.Builder copy(Course course) {
            this.courseId = course.courseId;
            this.courseName = course.courseName;
            this.courseDescription = course.courseDescription;
            this.subjectList = course.subjectList;
            this.departmentId = course.departmentId;

            return this;
        }


    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", subjectList=" + subjectList +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}