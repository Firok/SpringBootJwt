package com.firok.app.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.firok.app.service.BaseService;

public abstract class BaseServiceImpl<T, K extends Serializable> implements BaseService<T, K> {

	protected abstract JpaRepository<T, K> getRepository();

	@Override
	public List<T> findAll() {
		return getRepository().findAll();
	}

	@Override
	public T find(K k) {
		return getRepository().findOne(k);
	}

	@Override
	public T save(T t) {
		return getRepository().save(t);
	}

	@Override
	public void delete(T t) {
		getRepository().delete(t);
	}

	@Override
	public void delete(K k) {
		getRepository().delete(k);
	}

	@Override
	public Page<T> findAllWithPagination(Pageable pageable) {
		return getRepository().findAll(pageable);
	}

}
