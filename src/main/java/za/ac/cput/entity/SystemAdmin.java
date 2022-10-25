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
    private String adminId;
    private String adminName;
    private String adminEmail;


    public SystemAdmin(Builder builder) {
        this.adminId = builder.adminId;
        this.adminName = builder.adminName;
        this.adminEmail = builder.adminEmail;
    }

    protected SystemAdmin() {}

    public static class Builder {
        private String adminId;
        private String adminName;
        private String adminEmail;


        public Builder setAdminId(String adminId) {
            this.adminId = adminId;
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
            this.adminId = systemAdmin.adminId;
            this.adminName = systemAdmin.adminName;
            this.adminEmail = systemAdmin.adminEmail;
            return this;

        }


        public SystemAdmin build(){
            return new SystemAdmin(this);
        }


    }

    public String getAdminId() {
        return adminId;
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
                "adminID='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                '}';
    }
}
