/*
 * Faculty.java
 * Entity for the Faculty
 * Author: Mawande Langa(219074054)
 * Date: 30 March 2022
 * */

package za.ac.cput.Entity;

public class Faculty {

    private String facultyID;
    private  String facultyName;
    private String facultyEmail;

    //private constr
    private Faculty(Builder builder){
        this.facultyID = builder.facultyID;
        this.facultyName = builder.facultyName;
        this.facultyEmail = builder.facultyEmail;

    }


    public String getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(String facultyID) {
        this.facultyID = facultyID;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyEmail() {
        return facultyEmail;
    }

    public void setFacultyEmail(String facultyEmail) {
        this.facultyEmail = facultyEmail;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyID='" + facultyID + '\'' +
                ", facultyName='" + facultyName + '\'' +
                ", facultyEmail='" + facultyEmail + '\'' +
                '}';
    }

    public static class Builder{
        private String facultyID;
        private  String facultyName;
        private String facultyEmail;

        public Builder setFacultyID(String facultyID) {
            this.facultyID = facultyID;
            return this;
        }

        public Builder setFacultyName(String facultyName) {
            this.facultyName = facultyName;
            return this;
        }

        public Builder setFacultyEmail(String facultyEmail) {
            this.facultyEmail = facultyEmail;
            return this;
        }

        public Builder copy(Faculty faculty){
            this.facultyID = faculty.facultyID;
            this.facultyName = faculty.facultyName;
            this.facultyEmail = faculty.facultyEmail;
            return this;
        }

        public Faculty build(){
            return new Faculty(this);
        }


    }
}
