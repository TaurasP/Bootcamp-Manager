package com.bootcamp.bootcampmanager.bootcamp;

import org.springframework.stereotype.Repository;

import java.util.List;


public interface BootcampService {

    List<Bootcamp> getAllBootcamps();

    void saveBootcamp(Bootcamp bootcamp);

    Bootcamp getBootcampById(long id);

    void deleteBootcampById(long id);

    Bootcamp updateBootcampInfoById(long idToUpdate, Bootcamp bootcampNewInf);

}
