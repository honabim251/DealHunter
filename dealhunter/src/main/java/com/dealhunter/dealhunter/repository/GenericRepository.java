package com.dealhunter.dealhunter.repository;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T, ID> {

    List<T> findAll();

    Optional<T> findById(ID id);

    void save(T entity);
}