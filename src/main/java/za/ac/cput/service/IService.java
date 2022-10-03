package za.ac.cput.service;
/*
Generic Interface for all Service classes
Author: Mathew Fortuin (219069514)
Date: 21/8/2022
 */
public interface IService <T,ID>{

   T create(T t);

   T read(ID id);

   T update(T t);

   boolean delete(ID id);
}
