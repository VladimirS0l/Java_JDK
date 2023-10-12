package ru.solarev.homeWork.repository;

import java.util.List;

public interface Repository <T, TId> {
    List<T> findAll();
    T findById(TId id);
    void save(T t);
    void update(T t);
    void deleteById(TId id);
}
