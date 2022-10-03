
package za.ac.cput.repository;

/* IRepository.java
 Generic Repo for the entities
 Author: Mathew Fortuin -219069514
 Date: 15/03/2022
*/
@Deprecated
//No longer in use
public interface IRepository<T,ID> {
    //CRUD Functionality

    public T create(T t);
    public T read(ID id);
    public T update(T t);
    public boolean delete(ID id);
}


