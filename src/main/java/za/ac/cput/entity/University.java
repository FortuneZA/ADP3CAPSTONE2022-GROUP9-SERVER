package za.ac.cput.entity;

/* University.java
Entity for the University
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import java.util.List;

public class University {
    private String universityId;
    private String universityName;
    private String email;

    private List<String> facultyList;

    public University(Builder builder) {
        this.universityId=builder.universityId;
        this.universityName= builder.universityName;
        this.email=builder.email;
        this.facultyList=builder.facultyList;
    }

    public static class Builder
    {

        private String universityName, email, universityId;

        private List<String> facultyList;

        public Builder setUniversityId(String universityId)
        {
            this.universityId=universityId;
            return this;
        }

        public Builder setUniversityName(String universityName)
        {
            this.universityName=universityName;
            return this;
        }
        public Builder setEmail(String email)
        {
            this.email=email;
            return this;
        }

        public Builder setFacultyList(List<String> facultyList) {
            this.facultyList = facultyList;
            return this;
        }

        public Builder copy(University university)
        {
            this.universityId=university.universityId;
            this.universityName=university.universityName;
            this.email=university.email;
            this.facultyList=university.facultyList;
            return this;
        }

        public University build()
        {
            return new University(this);
        }
    }

    public String getUniversityId() {
        return universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getFacultyList() {
        return facultyList;
    }

    @Override
    public String toString() {
        return "University{" +
                "universityId='" + universityId + '\'' +
                ", universityName='" + universityName + '\'' +
                ", email='" + email + '\'' +
                ", facultyList=" + facultyList +
                '}';
    }
}
