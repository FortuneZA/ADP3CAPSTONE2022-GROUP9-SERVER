package za.ac.cput.entity;
/*
        SystemAdmin.java
        Author: Lefu Kumeke 218147856
        Date :03 April 2022
        */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("ALL")
@Entity
@Table(name="systemAdmin")
public class SystemAdmin {

    @Id
    private String adminID;
    private String adminName;
    private String adminEmail;


    public SystemAdmin(Builder builder) {
        this.adminID = builder.adminID;
        this.adminName = builder.adminName;
        this.adminEmail = builder.adminEmail;
    }

    protected SystemAdmin() {}

    public static class Builder {
        private String adminID;
        private String adminName;
        private String adminEmail;


        public Builder setAdminID(String adminID) {
            this.adminID = adminID;
            return this;
        }

        public Builder setAdminName(String adminName) {
            this.adminName = adminName;
            return this;
        }

        public Builder setAdminEmail(String adminEmail) {
            this.adminEmail = adminEmail;
            return this;

        }
        public Builder copy(SystemAdmin systemAdmin){
            this.adminID = systemAdmin.adminID;
            this.adminName = systemAdmin.adminName;
            this.adminEmail = systemAdmin.adminEmail;
            return this;

        }


        public SystemAdmin build(){
            return new SystemAdmin(this);
        }


    }

    public String getAdminID() {
        return adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }




    @Override
    public String toString() {
        return "SystemAdmin{" +
                "adminID='" + adminID + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                '}';
    }
}
