package com.dealhunter.dealhunter.repository;

import java.util.List;

public interface GenericRepository<T, ID> {

    List<T> findAll();

    T findById(ID id);

    void save(T entity);
}