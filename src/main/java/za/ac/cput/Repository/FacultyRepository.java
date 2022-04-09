/*
 * FacultyRepository.java
 * Repository for the Faculty
 * Author: Mawande Langa(219074054)
 * Date: 30 March 2022
 * */

package za.ac.cput.Repository;
import za.ac.cput.Entity.Faculty;
import za.ac.cput.impl.IFacultyRepository;

import java.util.HashSet;
import java.util.Set;

public class FacultyRepository implements IFacultyRepository {
    public static FacultyRepository repository = null;
    private Set<Faculty> facultyDB =null;

    private FacultyRepository(){
        facultyDB = new HashSet<Faculty>();
    }

    public static FacultyRepository getRepository(){
        if(repository == null)
            repository = new FacultyRepository();
        return repository;
    }

    @Override
    public Faculty create(Faculty faculty) {
        boolean success = facultyDB.add(faculty);
        if(!success)
            return null;

        return faculty;
    }

    @Override
    public Faculty read(String facultyID) {
        for(Faculty faculty : this.facultyDB){
            if(faculty.getFacultyID().equals(facultyID));
            return faculty;
        }
        return null;
    }

    @Override
    public Faculty update(Faculty faculty) {
        Faculty oldFaculty =read(faculty.getFacultyID());
        if(oldFaculty!=null) {
            this.facultyDB.remove(oldFaculty);
            this.facultyDB.add(faculty);
        }
        return faculty;
    }

    @Override
    public boolean delete(String facultyID) {
        Faculty faculty =read(facultyID);
        if(faculty!=null) {
            this.facultyDB.remove(faculty);
            return true;
        }
        return false;
    }

    @Override
    public Set<Faculty> getAll() {
        return this.facultyDB;
    }
}
