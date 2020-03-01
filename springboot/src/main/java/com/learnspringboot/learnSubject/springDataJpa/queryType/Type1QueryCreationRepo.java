package com.learnspringboot.learnSubject.springDataJpa.queryType;

import entity.User;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface Type1QueryCreationRepo extends Repository<User, Long> {
    List<User> findByEmailAddressAndLastname(String emailAddress, String lastname);

    // Enables the distinct flag for the query
    List<User> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);

    List<User> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);

    // Enabling ignoring case for an individual property
    List<User> findByLastnameIgnoreCase(String lastname);

    // Enabling ignoring case for all suitable properties
    List<User> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);

    // Enabling static ORDER BY for a query
    List<User> findByLastnameOrderByFirstnameAsc(String lastname);

    List<User> findByLastnameOrderByFirstnameDesc(String lastname);


}
