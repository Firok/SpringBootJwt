package com.firok.app.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BaseService<T, K extends Serializable> {
	
	/**
	 * find all
	 * @return all records
	 */
	List<T> findAll();
	
	
	/**
	 * find All with pagination
	 * @param pageable
	 * @return all records with pagination
	 */
	Page<T> findAllWithPagination(Pageable pageable);

	/**
	 * find by id
	 * @param k id value 
	 * @return
	 */
	T find(K k);

	/**
	 * save or update a record
	 * @param t entity value
	 * @return
	 */
	T save(T t);
	
	/**
	 * delete a record
	 * @param t entity value
	 */
	void delete(T t);

	/**
	 * delete a record
	 * @param k id value
	 */
	void delete(K k);

}
