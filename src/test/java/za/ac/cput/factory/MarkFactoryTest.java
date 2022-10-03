package za.ac.cput.factory;
/*
        MarkFactoryTest.java
        Author: Lefu Kumeke 218147856
        Date :03 April 2022
        */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class MarkFactoryTest {


    //object creation
    @Test
    public void test()
    {
        Mark mark = MarkFactory.createMark("555" , "Maths101", "10 July 2022");
        assertNotNull(mark.toString());
        System.out.println(mark);

    }



}