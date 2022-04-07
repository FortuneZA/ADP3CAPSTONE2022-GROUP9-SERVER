package za.ac.cput.Entity;

public class Builder
{
    public static void main(String[] args) {


        //student and test method

        Student student = new Student.Builder().setStudentId("27238173")
                .setFirstName("Themba")
                .setLastName("Khanyile")
                .setStudentEmail("tkhanyile@gmail.com")
                .setCourseID("362S")
                .build();




    }
}
