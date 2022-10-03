package za.ac.cput.entity;

/* Lecturer.java
Entity for the Lecturer
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/


public class Lecturer {
    private String lecturerId;
    private String firstName;

    private String middleName;
    private String lastName;
    private String lecturerEmail;

    private String departmentId;

    private Lecturer(Builder builder) {
        this.lecturerId = builder.lecturerId;
        this.firstName = builder.firstName;
        this.middleName= builder.middleName;
        this.lastName = builder.lastName;
        this.lecturerEmail = builder.lecturerEmail;
        this.departmentId= builder.departmentId;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLecturerEmail() {
        return lecturerEmail;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public static class Builder {
        private String lecturerId, firstName, middleName, lastName, lecturerEmail, departmentId;

        public Builder setLecturerId(String lecturerId) {
            this.lecturerId = lecturerId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setLecturerEmail(String lecturerEmail) {
            this.lecturerEmail = lecturerEmail;
            return this;
        }

        public Builder setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Builder copy(Lecturer lecturer) {
            this.lecturerId = lecturer.lecturerId;
            this.firstName = lecturer.firstName;
            this.middleName=lecturer.middleName;
            this.lastName = lecturer.lastName;
            this.lecturerEmail = lecturer.lecturerEmail;
            this.departmentId=lecturer.departmentId;
            return this;
        }

        public Lecturer build() {
            return new Lecturer(this);
        }
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "lecturerId='" + lecturerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lecturerEmail='" + lecturerEmail + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}
