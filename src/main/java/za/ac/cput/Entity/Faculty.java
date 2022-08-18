/*
 * Faculty.java
 * Entity for the Faculty
 * Author: Mawande Langa(219074054)
 * Date: 30 March 2022
 * */

package za.ac.cput.Entity;

import java.util.List;

public class Faculty {

    private String facultyID;
    private  String facultyName;
    private List<String> departmentList;

    //private constr
    private Faculty(Builder builder){
        this.facultyID = builder.facultyID;
        this.facultyName = builder.facultyName;
        this.departmentList = builder.departmentList;

    }


    public String getFacultyID() {
        return facultyID;
    }
    public String getFacultyName() {
        return facultyName;
    }
    public List<String> getDepartmentList(){
        return departmentList;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyID='" + facultyID + '\'' +
                ", facultyName='" + facultyName + '\'' +
                ", departmentList=" + departmentList +
                '}';
    }
    public static class Builder{
        private String facultyID;
        private  String facultyName;
        private List<String> departmentList;

        public Builder setFacultyID(String facultyID) {
            this.facultyID = facultyID;
            return this;
        }

        public Builder setFacultyName(String facultyName) {
            this.facultyName = facultyName;
            return this;
        }

        public Builder setDepartmentList(List<String> departmentList){
            this.departmentList = departmentList;
            return this;
        }

        public Builder copy(Faculty faculty){
            this.facultyID = faculty.facultyID;
            this.facultyName = faculty.facultyName;
            this.departmentList = faculty.departmentList;
            return this;
        }

        public Faculty build(){
            return new Faculty(this);
        }


    }
}
