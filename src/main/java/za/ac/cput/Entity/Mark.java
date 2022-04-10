package za.ac.cput.Entity;
/*
        Mark.java
        Entity for Student
        Author: Lefu Kumeke 218147856
        Date :03 April 2022
        */

public class  Mark {


    private String markID;
    private String lectureID;
    private String testID;
    private String markDate;

    private Mark(Builder builder){
        this.markID = builder.markID;
        this.lectureID = builder.lectureID;
        this.testID = builder.testID;
        this.markDate = builder.markDate;

    }

    @Override
    public String toString() {
        return "Mark{" +
                "markID='" + markID + '\'' +
                ", lectureID='" + lectureID + '\'' +
                ", testID='" + testID + '\'' +
                ", markDate='" + markDate + '\'' +
                '}';
    }

    public String getMarkID() {  return markID; }

    public String getLectureID() { return lectureID; }

    public String getTestID() { return testID; }

    public String getMarkDate() { return markDate; }

    // Builder Class
    public static class Builder {
        private String markID;
        private String lectureID;
        private String testID;
        private String markDate;

        public Builder setMarkID(String markID) {
            this.markID = markID;
            return this;
        }

        public Builder setLectureID(String lectureID) {
            this.lectureID = lectureID;
            return this;
        }

        public Builder setTestID(String testID) {
            this.testID = testID;
            return this;
        }

        public Builder setMarkDate(String markDate) {
            this.markDate = markDate;
            return this;
        }
        public Mark build(){
            return new Mark(this);


        }

        public Builder copy(Mark mark){
            this.markID = mark.markID;
            this.lectureID = mark.lectureID;
            this.testID = mark.testID;
            this.markDate = mark.markDate;
            return this;

        }


    }
}
