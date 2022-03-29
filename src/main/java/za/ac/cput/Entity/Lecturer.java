package za.ac.cput.Entity;

/* Lecturer.java
Entity for the Lecturer
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/


public class Lecturer {
    private String lecturerID;
    private String firstName;
    private String lastName;
    private String lecturerEmail;

    private Lecturer(Builder builder) {
        this.lecturerID = builder.lecturerID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.lecturerEmail = builder.lecturerEmail;
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLecturerEmail() {
        return lecturerEmail;
    }

    public static class Builder {
        private String lecturerID, firstName, lastName, lecturerEmail;

        public Builder setLecturerID(String lecturerID) {
            this.lecturerID = lecturerID;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
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

        public Builder copy(Lecturer lecturer) {
            this.lecturerID = lecturer.lecturerID;
            this.firstName = lecturer.firstName;
            this.lastName = lecturer.lastName;
            this.lecturerEmail = lecturer.lecturerEmail;
            return this;
        }

        public Lecturer build() {
            return new Lecturer(this);
        }
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "lecturerID='" + lecturerID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lecturerEmail='" + lecturerEmail + '\'' +
                '}';
    }
}
