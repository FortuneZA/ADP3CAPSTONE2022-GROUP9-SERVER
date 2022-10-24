package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.*;

/*
Entity for Test
Author: Themba Kanyile 217238173
Date : 23 March 2022
 */
@Entity
@Table(name="test")
public class TestModel

{
    @Id
    private String testId;

    private String subjectId;

    private String testName;

    private String testDate;

    private String duration;
    private int resultInPercent;
    public TestModel() {

    }

    public TestModel(TestModel.Builder builder) {
        this.testId = builder.testId;
        this.subjectId = builder.subjectId;
        this.testName = builder.testName;
        this.testDate = builder.testDate;
        this.duration = builder.duration;
        this.resultInPercent = builder.resultInPercent;

    }

    public TestModel(TestModel test) {
    }

    @Override
    public String toString() {
        return "Test{" +
                "testID='" + testId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", testName='" + testName+ '\'' +
                ", testDate='" + testDate + '\'' +
                ", duration='" + duration + '\'' +
                ", resultInPercent='" + resultInPercent + '\'' +
                '}';
    }

    public String getTestId() {
        return testId;
    }

    public String getSubjectId() {
        return subjectId;
    }
    public String getTestName() {
        return testName;
    }

    public String getTestDate() {
        return testDate;
    }
    public String getDuration() {
        return duration;
    }
    public int getResultInPercent() {
        return resultInPercent;
    }


    // Builder Class
    public static class Builder {
        private String testId;
        private String subjectId;
        private String testName;
        private String testDate;
        private String duration;
        private int resultInPercent;
        private int id;

        public Builder setTestId(String testId) {
            this.testId = testId;
            return this;
        }

        public Builder setSubjectId(String subjectId) {
            this.subjectId = subjectId;
            return this;
        }

        public Builder setTestName(String testName) {
            this.testName = testName;
            return this;
        }
        public Builder setResultInPercent(int resultInPercent) {
            this.resultInPercent= resultInPercent;
            return this;
        }
        public Builder setTestDate(String testDate) {
            this.testDate = testDate;
            return this;
        }

        public Builder setDuration(String duration) {
            this.duration = duration;
            return this;
        }



            public TestModel build ()
        {
                return new TestModel(this);

            }

            public TestModel.Builder copy (TestModel test){
                this.testId = test.testId;
                this.subjectId = test.subjectId;
                this.testName = test.testName;
                this.testDate = test.testDate;
                this.duration = test.duration;
                this.resultInPercent = test.resultInPercent;


                return this;
            }

            public TestModel.Builder id ( int id){
                this.id = id;
                return this;
            }
        }
    }
