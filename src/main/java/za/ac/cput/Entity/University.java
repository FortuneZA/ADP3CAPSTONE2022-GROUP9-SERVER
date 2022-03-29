package za.ac.cput.Entity;

/* University.java
Entity for the University
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

public class University {
    private String universityID;
    private String universityName;
    private String city;
    private String address;
    private String phoneNumber;

    public University(Builder builder) {
        this.universityID= builder.universityID;
        this.universityName= builder.universityName;
        this.city= builder.city;
        this.address= builder.address;
        this.phoneNumber=builder.phoneNumber;
    }

    public static class Builder
    {
        private String universityID, universityName, city, address, phoneNumber;

        public Builder setUniversityID(String universityID)
        {
            this.universityID=universityID;
            return this;
        }
        public Builder setUniversityName(String universityName)
        {
            this.universityName=universityName;
            return this;
        }
        public Builder setCity(String city)
        {
            this.city=city;
            return this;
        }
        public Builder setAddress(String address)
        {
            this.address=address;
            return this;
        }
        public Builder setPhoneNumber(String phoneNumber)
        {
            this.phoneNumber=phoneNumber;
            return this;
        }

        public Builder copy(University university)
        {
            this.universityID=university.universityID;
            this.universityName=university.universityName;
            this.city=university.city;
            this.address=university.address;
            this.phoneNumber=university.phoneNumber;
            return this;
        }

        public University build()
        {
            return new University(this);
        }
    }

    public String getUniversityID() {
        return universityID;
    }

    public String getUniversityName() {
        return universityName;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "University{" +
                "universityID='" + universityID + '\'' +
                ", universityName='" + universityName + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
