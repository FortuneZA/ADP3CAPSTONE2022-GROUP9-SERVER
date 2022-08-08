package za.ac.cput.Repository;

/* LecturerRepository.java
Repository for the Lecturer
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import za.ac.cput.Entity.Lecturer;
import za.ac.cput.impl.ILecturerRepository;

import java.util.HashSet;
import java.util.Set;

public class LecturerRepository implements ILecturerRepository {

    private static LecturerRepository lecturerRepository=null;
    private Set<Lecturer> lecturerDB;

    LecturerRepository() {
        lecturerDB=new HashSet<>();
    }

    public static LecturerRepository getRepository(){
        if(lecturerRepository==null)
            lecturerRepository=new LecturerRepository();
        return lecturerRepository;
    }

    @Override
    public Lecturer create(Lecturer lecturer) {
        boolean success=lecturerDB.add(lecturer);
        if(!success)
            return null;
        return lecturer;
    }

    @Override
    public Lecturer read(String lecturerId) {
        for(Lecturer l: lecturerDB)
            if(l.getLecturerId().equals(lecturerId))
                return l;
        return null;
    }

    @Override
    public Lecturer update(Lecturer lecturer) {
        Lecturer oldLecturer=read(lecturer.getLecturerId());
        if(oldLecturer!=null) {
            this.lecturerDB.remove(oldLecturer);
            this.lecturerDB.add(lecturer);
        }
        return lecturer;
    }

    @Override
    public boolean delete(String lecturerId) {
        Lecturer lecturer=read(lecturerId);
        if(lecturer!=null) {
            this.lecturerDB.remove(lecturer);
            return true;
        }
        return false;
    }

    @Override
    public Set<Lecturer> getAll() {
        return this.lecturerDB;
    }
}
