package za.ac.cput.service;
/*      TutorService.java

        Author: Devon Daniels (217299822)

 */


import org.springframework.stereotype.Service;
import za.ac.cput.entity.Tutor;
import za.ac.cput.service.impl.ITutorService;

import java.util.Set;

@Service
public class TutorService implements ITutorService {
    private static TutorService tutorService;
    private TutorRepository tutorRepository;

    private TutorService() {
        this.tutorRepository = TutorRepository.getRepository();
    }

    public static TutorService getTutorService() {
        if (tutorService == null) {
            tutorService = new TutorService();
        }
        return tutorService;
    }




    public Tutor create(Tutor tutor) {

        return this.tutorRepository.create(tutor);
    }


    public Tutor read(String tutorName) {
        return this.tutorRepository.read(tutorName);

    }

    public Tutor update(Tutor tutor)
    {return this.tutorRepository.update(tutor);
    }

    public boolean delete(String tutor) {
        return this.tutorRepository.delete(tutor);

    }

    public Set<Tutor> getAll() {
        return this.tutorRepository.getAll();

    }


}



