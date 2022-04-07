package za.ac.cput.Entity;
/*
Entity for Test
Author: Themba Kanyile 217238173
Date : 23 March 2022
 */
public class Test

{
    private String testId;
    private String testDate;
    private String lecturerId;
    private String testInfo;


    private Test(Test.Builder builder) {
        this.testId = builder.testId;
        this.testDate = builder.testDate;
        this.lecturerId = builder.lecturerId;
        this.testInfo = builder.testInfo;

    }

    @Override
    public String toString() {
        return "Test{" +
                "testID='" + testId + '\'' +
                ", testDate='" + testDate + '\'' +
                ", lecturerId='" + lecturerId + '\'' +
                ", testInfo='" + testInfo + '\'' +
                '}';
    }

    public String getTestId() {
        return testId;
    }

    public String getTestDate() {
        return testDate;
    }
    public String getLecturerId() {
        return lecturerId;
    }

    public String getTestInfo() {
        return testInfo;
    }

    // Builder Class
    public static class Builder {
        private String testId;
        private String testDate;
        private String lecturerId;
        private String testInfo;
        private int id;

        public Builder setTestId(String testId) {
            this.testId = testId;
            return this;
        }

        public Builder setTestDate(String testDate) {
            this.testDate = testDate;
            return this;
        }

        public Builder setLecturerId(String lecturerId) {
            this.lecturerId = lecturerId;
            return this;
        }

        public Builder setTestInfo(String testInfo) {
            this.testInfo = testInfo;
            return this;
        }

        public Test build() {
            return new Test(this);

        }

        public Test.Builder copy(Test test) {
            this.testId = test.testId;
            this.testDate = test.testDate;
            this.lecturerId = test.lecturerId;
            this.testInfo = test.testInfo;


            return this;
        }

        public Test.Builder id(int id) {
            this.id = id;
            return this;
        }
    }
}