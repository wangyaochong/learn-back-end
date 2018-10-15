package com.learnspring.springDataJpa.repo.custom;

import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaContext;
import util.LogUtil;

import javax.persistence.EntityManager;

@Slf4j
public class UserRepoCustomImpl implements UserRepoCustom{

    EntityManager em;
    public UserRepoCustomImpl(JpaContext context){
        this.em = context.getEntityManagerByManagedType(User.class);
        log.info(LogUtil.prefixLog("构造em"));
    }


    @Override
    public void saveCustom(User user) {
        log.info(LogUtil.prefixLog( "自定义保存User对象"));
    }
}
