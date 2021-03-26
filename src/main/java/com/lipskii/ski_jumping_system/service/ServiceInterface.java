package com.lipskii.ski_jumping_system.service;

import java.util.List;

//TODO change it to include get()
public interface ServiceInterface {

    List<?> findAll();

    Object findById(int id);

    <T> T save(T obj);

    void deleteById(int id);

}
