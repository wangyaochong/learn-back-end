package com.example.learnmybatis.factory;

import com.example.learnmybatis.entity.User;
import lombok.Data;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;

@Data
public class MyObjectFactory extends DefaultObjectFactory {
    String specialName;



    @Override
public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
    T t = super.create(type, constructorArgTypes, constructorArgs);
    if(type.getSimpleName().equals("User")){
        User user =(User) t;
        user.setForObjectFactory("forObjectFactory");
    }
    return t;
}
}
