package za.ac.cput.entity;

import javax.persistence.*;

/* Subject.java
 Class for the subject entity
 Author: Mathew Fortuin -219069514
 Date: 15/03/2022
*/
@Entity
@Table(name="subject")
public class Subject {


    @Id
    @GeneratedValue
    private Long subjectID;
    private String subjectName;
    private Integer subjectCredit;
    private String lecturerID;

    protected Subject() {

    }

//Builder Constructor

    public Subject(Builder builder) {
        this.subjectName = builder.subjectName;
        this.subjectCredit = builder.subjectCredit;
        this.subjectID = builder.subjectID;
        this.lecturerID = builder.lecturerID;
    }



    //Getters


    public Long getSubjectID() {
        return subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Integer getSubjectCredit() {
        return subjectCredit;
    }

    public String getLecturerID() {
        return lecturerID;
    }


    //Setters

    public void setSubjectID(Long subjectID) {
        this.subjectID = subjectID;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setSubjectCredit(Integer subjectCredit) {
        this.subjectCredit = subjectCredit;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }


    //Builder Class

    public static class Builder {
        private Long subjectID;
        private String subjectName;
        private Integer subjectCredit;
        private String lecturerID;

        //Setters

        public Builder setSubjectName(String subjectName) {
            this.subjectName = subjectName;
            return this;
        }

        public Builder setSubjectCredit(Integer subjectCredit) {
            this.subjectCredit = subjectCredit;
            return this;
        }

        public Builder setSubjectID(Long subjectID) {
            this.subjectID = subjectID;
            return this;
        }

        public Builder setLecturerID(String lecturerID) {
            this.lecturerID = lecturerID;
            return this;
        }

        public Subject build() {
            return new Subject(this);
        }

        public Builder copy(Subject subject) {
            this.subjectID = subject.subjectID;
            this.subjectName = subject.subjectName;
            this.subjectCredit = subject.subjectCredit;
            this.lecturerID = subject.lecturerID;

            return this;
        }
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectID='" + subjectID + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", subjectCredit=" + subjectCredit +
                ", lecturerID='" + lecturerID + '\'' +
                '}';
    }
}