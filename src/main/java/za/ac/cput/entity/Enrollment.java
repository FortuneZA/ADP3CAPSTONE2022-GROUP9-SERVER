/*
package za.ac.cput.entity;
*/
/*
        Enrollment.java
        Author: Devon Daniels 217299822
        Date :15 August 2022
        *//*



public class Enrollment {

    private String enrollmentID;
    private String enrollmentDetails;
    private String enrollmentDates;


    private Enrollment(Builder builder) {
        this.enrollmentID = builder.enrollmentID;
        this.enrollmentDetails = builder.enrollmentDetails;
        this.enrollmentDates = builder.enrollmentDates;


    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "Enrollment ID='" + enrollmentID + '\'' +
                ", EnrollmentDetails='" + enrollmentDetails + '\'' +
                ", EnrollmentDates='" + enrollmentDates + '\'' +

                '}';
    }

    public String getEnrollmentID() {
        return enrollmentID;
    }

    public String getEnrollmentDetails() {
        return enrollmentDetails;
    }

    public String getEnrollmentDates() {
        return enrollmentDates;
    }



    // Builder Class
    public static class Builder {
        private String enrollmentID;
        private String enrollmentDetails;
        private String enrollmentDates;


        public Builder setEnrollmentID(String enrollmentID) {
            this.enrollmentID = enrollmentID;
            return this;
        }

        public Builder setEnrollmentDetails(String enrollmentDetails) {
            this.enrollmentDetails = enrollmentDetails;
            return this;
        }

        public Builder setEnrollmentDates(String enrollmentDates) {
            this.enrollmentDates = enrollmentDates;
            return this;

        }



        public Enrollment build() {
            return new Enrollment(this);


        }

        public Builder copy(Enrollment enrollment){
            this.enrollmentID = enrollment.enrollmentID;
            this.enrollmentDetails = enrollment.enrollmentDetails;
            this.enrollmentDates = enrollment.enrollmentDates;

            return this;

        }
    }
}
*/
