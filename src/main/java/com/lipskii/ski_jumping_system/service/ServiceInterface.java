package com.lipskii.ski_jumping_system.service;

import java.util.List;

public interface ServiceInterface {

    List<?> findAll();

    Object findById(int id);

    void save(Object obj);

    void deleteById(int id);

}
