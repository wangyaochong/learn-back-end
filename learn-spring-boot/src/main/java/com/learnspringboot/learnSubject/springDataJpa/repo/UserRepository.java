package com.learnspringboot.learnSubject.springDataJpa.repo;


import com.learnspringboot.learnSubject.springDataJpa.repo.custom.UserRepoCustom;
import entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends MyBaseRepository<User,Long>,UserRepoCustom {
    User findByEmailAddress(String emailAddress);

    List<User> findByAddress_Country(String country);//可以根据嵌入的属性查询，强制指定嵌入的字段属性
    List<User> findByAddressCountry(String country);//可以根据嵌入的属性查询，让程序自动解析

    Page<User> findByName(String name, Pageable pageable);

    @Query("select u from User u where u.name =?1 ")
    List<User> findByName(String name);

//    原生sql的查询参数是从1开始的
    @Query(value = "SELECT * FROM USERS WHERE nick_name = ?1",
            countQuery = "SELECT count(*) FROM USERS WHERE nick_name= ?1",
            nativeQuery = true)
    Page<User> findByNickName(String nickName, Pageable pageable);


    @Query("select u from User u where u.name = :name or u.nickName = :nickName")
    User findByNameAndNickName(@Param("name") String name,
                                   @Param("nickName") String nickName);
}
