/*
 * Department.java
 * Entity for the Department
 * Author: Mawande Langa (219074054)
 * Date: 30 March 2022
 * */

package za.ac.cput.Entity;

public class Department {

    private String departmentID;
    private String departmentName;
    private String departmentEmail;

    //private const
    private Department(Builder builder){
        this.departmentID = builder.departmentID;
        this.departmentName = builder.departmentName;
        this.departmentEmail = builder.departmentEmail;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentEmail() {
        return departmentEmail;
    }

    public void setDepartmentEmail(String departmentEmail) {
        this.departmentEmail = departmentEmail;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID='" + departmentID + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentEmail='" + departmentEmail + '\'' +
                '}';
    }

    public static class Builder{
        private String departmentID;
        private String departmentName;
        private String departmentEmail;

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


        public Builder copy(Department department){
            this.departmentID = department.departmentID;
            this.departmentName = department.departmentName;
            this.departmentEmail = department.departmentEmail;
            return this;
        }

        public Department build(){
            return new Department(this);
        }
    }
}
