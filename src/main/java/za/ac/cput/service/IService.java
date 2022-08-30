package za.ac.cput.service;
/*
Generic Interface for all Service classes
Author: Mathew Fortuin (219069514)
Date: 21/8/2022
 */
public interface IService <T,ID>{

    public T create(T t);

    public T read(ID id);

    public T update(T t);

    public boolean delete(ID id);
}
