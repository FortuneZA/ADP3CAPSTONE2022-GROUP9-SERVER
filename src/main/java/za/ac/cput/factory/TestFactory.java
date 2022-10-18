package za.ac.cput.factory;
import za.ac.cput.entity.Test;
import za.ac.cput.util.GenericHelper;
/*
Factory for Test
Author: Themba Kanyile 217238173
Date : 23 March 2022
 */
public class TestFactory
{

    public static Test createTest( String subjectId,String testName,String testDate,String duration,int resultInPercent){

        String testId = GenericHelper.generateID();

        Test test = new Test.Builder()
                .setTestId(testId)
                .setSubjectId(subjectId)
                .setTestName(testName)
                .setTestDate(testDate)
                .setDuration(duration)
                .setResultInPercent(resultInPercent)
                .build();

        return test;
    }
}
