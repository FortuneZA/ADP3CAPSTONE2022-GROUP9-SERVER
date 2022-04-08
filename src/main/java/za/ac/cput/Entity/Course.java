package za.ac.cput.Entity;

/* Course.java
 Class for the Course entity
 Author: Mathew Fortuin -219069514
 Date: 15/03/2022
*/
public class Course {

    private final String courseID;
    private final String courseName;
    private String courseDescription;
    private String facultyID;

    //Builder Constructor

    private Course(Builder builder) {
        this.courseID = builder.courseID;
        this.courseName = builder.courseName;
        this.courseDescription = builder.courseDescription;
        this.facultyID = builder.facultyID;
    }

    //Getters


    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public String getFacultyID() {
        return facultyID;
    }

    //Builder Class

    public static class Builder {
        private String courseID;
        private String courseName;
        private String courseDescription;
        private String facultyID;

        public Builder() {
            //Default constructor
        }

        public Builder courseID(String courseID) {
            this.courseID = courseID;
            return this;
        }

        public Builder courseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        public Builder courseDescription(String courseDescription) {
            this.courseDescription = courseDescription;
            return this;
        }

        public Builder facultyID(String facultyID) {
            this.facultyID = facultyID;
            return this;
        }

        public Course build() {
            return new Course(this);
        }

        public Course.Builder copy(Course course) {
            this.courseID = course.courseID;
            this.courseName = course.courseName;
            this.courseDescription = course.courseDescription;
            this.facultyID = course.facultyID;

            return this;
        }


    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", facultyID='" + facultyID + '\'' +
                '}';
    }
}