package com.example.learnmybatis.entity;


import com.example.learnmybatis.enums.EnumSex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    Long id;
    String name;
    Integer age;
    String emailAddress;

    EnumSex sex;

    transient String forObjectFactory;
}
