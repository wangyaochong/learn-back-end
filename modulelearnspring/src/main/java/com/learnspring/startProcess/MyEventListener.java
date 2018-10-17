package com.learnspring.startProcess;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;
import util.UtilLog;

@Slf4j
@Component
public class MyEventListener implements ApplicationListener<ApplicationStartingEvent>{

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        log.info(UtilLog.prefixLog("程序正在启动"+event.toString()));
    }
}
