package ems.bibek.ems.dao;

import java.util.List;

public interface GenericDao<T,E> {
	
	/**
	 * This method is used to create a record in database
	 * @param t
	 * @return
	 */
	T create(T t);
	
	/**
	 * This method is use to update the record in  database 
	 * @param t
	 * @param e
	 * @return
	 */
	T update(T t,E e);
	
	/**
	 * This method is use to delete a record from database
	 * @param e
	 * @return
	 */
	T delete(E e);
	
	/**
	 * This method is use to get all the record from database
	 * @return
	 */
	List<T> getAll();
	
	/**
	 * This method is used to search specific record from database
	 * @param e
	 * @return
	 */
	T Search(E e);

}
