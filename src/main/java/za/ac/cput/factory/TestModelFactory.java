package za.ac.cput.factory;
import za.ac.cput.entity.TestModel;
import za.ac.cput.util.GenericHelper;

/*Factory for Test
Author: Themba Kanyile 217238173
Date : 23 March 2022
 */

public class TestModelFactory
{

    public static TestModel createTest( String subjectId,String testName,String testDate,String duration,int resultInPercent){

        String testId = GenericHelper.generateID();

        TestModel test = new TestModel.Builder()
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
