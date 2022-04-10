/*
 * Faculty.java
 * Entity for the Faculty
 * Author: Mawande Langa(219074054)
 * Date: 30 March 2022
 * */
package za.ac.cput.impl;
import za.ac.cput.Entity.Faculty;
import za.ac.cput.Repository.IRepository;

import java.util.Set;

public interface IFacultyRepository extends IRepository<Faculty, String> {
    public Set<Faculty> getAll();

}
