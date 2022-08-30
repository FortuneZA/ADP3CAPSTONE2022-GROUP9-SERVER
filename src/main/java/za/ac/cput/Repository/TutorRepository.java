package za.ac.cput.Repository;
/*
        TutorRepository.java
        Author: Devon Daniels 217299822
        Date :15 August 2022
        */
import za.ac.cput.Entity.Tutor;
import za.ac.cput.impl.ITutorRepository;

import java.util.HashSet;
import java.util.Set;

public class TutorRepository implements ITutorRepository {

    private static TutorRepository repository = null;
    private Set<Tutor> tutorDB= null;

    private TutorRepository() {
        tutorDB = new HashSet<Tutor>();
    }

    public static TutorRepository getRepository(){
        if(repository == null)
            repository = new TutorRepository();
        return repository;
    }

    @Override
    public Tutor create(Tutor tutor) {
        boolean success = this.tutorDB.add(tutor);
        if(!success)

            return null;
        return tutor;
    }

    @Override
    public Tutor read(String TutorID) {
        for(Tutor tutor: this.tutorDB){

            if(tutor.getTutorID().equalsIgnoreCase(TutorID))
                return tutor;
        }

        return null;
    }

    @Override
    public Tutor update(Tutor tutor) {
        Tutor updateSystem = read(tutor.getTutorID());

        if (updateSystem != null) {
            this.tutorDB.remove(updateSystem);
            this.tutorDB.add(tutor);
            return tutor;
        }


        return null;
    }

    @Override
    public boolean delete(String TutorID) {
        Tutor infoDelete = read(TutorID);

        if(infoDelete != null){

            this.tutorDB.remove(infoDelete);
            return true;
        }

        return false;
    }

    @Override
    public Set<Tutor> getAll() {
        return tutorDB;
    }
}