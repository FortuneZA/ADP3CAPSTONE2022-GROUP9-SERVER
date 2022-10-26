/*
package za.ac.cput.entity;
*/
/*
        Tutor.java
        Author: Devon Daniels 217299822
        Date :15 August 2022
        *//*


public class Tutor {

    private String tutorID;
    private String firstName;
    private String middleName;
    private String lastName;
    private String tutorEmail;
    private String tutorPhoneNumber;



    public Tutor(Builder builder) {
        this.tutorID = builder.tutorID;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.tutorEmail = builder.tutorEmail;
        this.tutorPhoneNumber = builder.tutorPhoneNumber;


    }

    @Override
    public String toString() {
        return "Tutor{" +
                "Tutor ID='" + tutorID + '\'' +
                ",  First Name='" + firstName + '\'' +
                ",  Middle Name='" + middleName + '\'' +
                ",  Last Name ='" + lastName + '\'' +
                ", Tutor Email='" + tutorEmail + '\'' +
                ", Tutor Phone Number='" + tutorPhoneNumber + '\'' +

                '}';
    }

    public String getTutorID() {
        return tutorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }

    public String getTutorEmail() {
        return tutorEmail;
    }

    public String getTutorPhoneNumber() {
        return tutorPhoneNumber;
    }



    // Builder Class
    public static class Builder {
        private String tutorID;
        private String firstName;
        private String middleName;
        private String lastName;
        private String tutorEmail;
        private String tutorPhoneNumber;


        public Builder setTutorID(String tutorID) {
            this.tutorID = tutorID;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;

        }
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setTutorEmail(String tutorEmail) {
            this.tutorEmail = tutorEmail;
            return this;
        }

        public Builder setTutorPhoneNumber(String tutorPhoneNumber) {
            this.tutorPhoneNumber = tutorPhoneNumber;
            return this;

        }




        public Tutor build() {
            return new Tutor(this);


        }

        public Builder copy(Tutor tutor){
            this.tutorID = tutor.tutorID;
            this.firstName = tutor.firstName;
            this.middleName = tutor.middleName;
            this.lastName = tutor.lastName;
            this.tutorEmail = tutor.tutorEmail;
            this.tutorPhoneNumber = tutor.tutorPhoneNumber;

            return this;

        }
    }
}

*/
