package org.example.lab5.services;

import java.util.List;

public interface Iservices<T,ID> {
    boolean save(T entity);
    boolean delete(ID id);
    boolean update(T entity);
    T findById(ID id);
    List<T> findAll();


}
