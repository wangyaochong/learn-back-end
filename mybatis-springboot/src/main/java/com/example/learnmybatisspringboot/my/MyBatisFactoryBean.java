package com.example.learnmybatisspringboot.my;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MyBatisFactoryBean implements FactoryBean {

    public Class getMapperInterface() {
        return mapperInterface;
    }

    public void setMapperInterface(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    Class mapperInterface;

    @Override
    public Object getObject() throws Exception {
        return MySession.queryMapper(mapperInterface);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }
}
