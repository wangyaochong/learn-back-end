package com.learnspringboot.learnSubject.aop.interfaces;

public interface IBase {
    String methodAop(String param);

    void methodAopVoid(String param);

    String myTransaction();


    String outerMethod(String param);

    String innerMethod(String param);

    String methodAopForNoExecute(String param);
}
