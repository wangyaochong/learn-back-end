package com.example.learnmybatisspringboot.service;

import com.example.learnmybatisspringboot.mapper.TDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class TService implements ApplicationContextAware {
    @Autowired
    TDao tDao;
    public void list(){
        System.out.println(tDao.list());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        TService service= applicationContext.getBean(TService.class);
        service.list();
    }
}
