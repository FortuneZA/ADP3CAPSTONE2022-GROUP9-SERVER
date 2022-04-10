package za.ac.cput.Entity;
/*
        SystemAdmin.java
        Author: Lefu Kumeke 218147856
        Date :03 April 2022
        */

public class SystemAdmin {

    private String adminID;
    private String adminName;
    private String adminEmail;
    private String universityID;

    private SystemAdmin(Builder builder) {
        this.adminID = builder.adminID;
        this.adminName = builder.adminName;
        this.adminEmail = builder.adminEmail;
        this.universityID = builder.universityID;

    }

    @Override
    public String toString() {
        return "SystemAdmin{" +
                "adminID='" + adminID + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", universityID='" + universityID + '\'' +
                '}';
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

    public String getUniversityID() {
        return universityID;
    }

    // Builder Class
    public static class Builder {
        private String adminID;
        private String adminName;
        private String adminEmail;
        private String universityID;

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

        public Builder setUniversityID(String universityID) {
            this.universityID = universityID;
            return this;
        }

        public SystemAdmin build() {
            return new SystemAdmin(this);


        }

        public Builder copy(SystemAdmin systemAdmin){
            this.adminID = systemAdmin.adminID;
            this.adminName = systemAdmin.adminName;
            this.adminEmail = systemAdmin.adminEmail;
            this.universityID = systemAdmin.universityID;
            return this;

        }
    }
}
