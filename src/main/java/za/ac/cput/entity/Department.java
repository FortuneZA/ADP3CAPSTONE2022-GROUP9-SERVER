/*
 * Department.java
 * Entity for the Department
 * Author: Mawande Langa (219074054)
 * Date: 30 March 2022
 * */

package za.ac.cput.entity;

import java.util.List;

public class Department {

    private String departmentID;
    private String departmentName;
    private String departmentEmail;
    private String departmentTelephone;
    private List<String> courseList;

    //private const
    private Department(Builder builder){
        this.departmentID = builder.departmentID;
        this.departmentName = builder.departmentName;
        this.departmentEmail = builder.departmentEmail;
        this.departmentTelephone = builder.departmentTelephone;
        this.courseList = builder.courseList;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentEmail() {
        return departmentEmail;
    }

    public String getDepartmentTelephone(){
        return departmentTelephone;
    }
    public List<String> getCourseList(){
        return courseList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID='" + departmentID + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentEmail='" + departmentEmail + '\'' +
                ", departmentTelephone='" + departmentTelephone + '\'' +
                ", courseList=" + courseList +
                '}';
    }

    public static class Builder{
        private String departmentID;
        private String departmentName;
        private String departmentEmail;
        private String departmentTelephone;
        private List<String> courseList;

        public Builder setDepartmentID(String departmentID) {
            this.departmentID = departmentID;
            return this;
        }

        public Builder setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Builder setDepartmentEmail(String departmentEmail) {
            this.departmentEmail = departmentEmail;
            return this;
        }
        public Builder setDepartmentTelephone(String departmentTelephone){
            this.departmentTelephone = departmentTelephone;
            return this;
        }
        public Builder setCourseList(List<String> courseList){
            this.courseList =courseList;
            return this;
        }


        public Builder copy(Department department){
            this.departmentID = department.departmentID;
            this.departmentName = department.departmentName;
            this.departmentEmail = department.departmentEmail;
            this.departmentTelephone = department.departmentTelephone;
            this.courseList = department.courseList;
            return this;
        }

        public Department build(){
            return new Department(this);
        }
    }
}
