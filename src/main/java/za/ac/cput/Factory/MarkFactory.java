package za.ac.cput.Factory;
import za.ac.cput.Entity.Mark;
import za.ac.cput.Util.GenericHelper;
/*
        MarkFactory.java
        Entity for Student
        Author: Lefu Kumeke 218147856
        Date :03 April 2022
        */


public class MarkFactory {

    public static Mark createMark(String lectureID, String testID, String markDate){
        String markID = GenericHelper.generateID();

        Mark mark = new Mark.Builder()
                .setMarkID(markID)
                .setLectureID(lectureID)
                .setTestID(testID)
                .setMarkDate(markDate)
                .build();

        return mark;


    }

}
