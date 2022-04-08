package za.ac.cput.Repository;
/*
        MarkRepository.java
        Author: Lefu Kumeke 218147856
        Date :03 April 2022
        */
import za.ac.cput.impl.IMarkRepository;
import za.ac.cput.Entity.Mark;
import java.util.HashSet;
import java.util.Set;

public class MarkRepository implements IMarkRepository {

    private static MarkRepository repository = null;
    private Set<Mark> markDB= null;

    private MarkRepository() {
        markDB = new HashSet<Mark>();
    }

    public static MarkRepository getRepository(){
        if(repository == null)
            repository = new MarkRepository();
        return repository;
    }

    @Override
    public Mark create(Mark mark) {
        boolean success = this.markDB.add(mark);
        if(!success)
            return null;

        return mark;
    }

    @Override
    public Mark read(String MarkId) {

        for (Mark mark: this.markDB) {
            //String   markID;
            if (mark.getMarkID().equalsIgnoreCase(MarkId))
                return mark;
        }

        return null;
    }

    @Override
    public Mark update(Mark mark) {
        Mark oldMark = read(mark.getMarkID());

        if (oldMark != null) {
            this.markDB.remove(oldMark);
            this.markDB.add(mark);
            return mark;
        }

        return null;
    }

   @Override
    public boolean delete(String markID) {
        Mark deleteMark = read(markID);

        if (deleteMark != null) {
            this.markDB.remove(deleteMark);
            return true;
        }
        return false;
    }

    @Override
    public Set<Mark> getAll() {
        return markDB;
    }

}
