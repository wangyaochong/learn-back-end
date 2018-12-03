package com.learnspringboot.learnSubject.aop.interfaces;

public interface IBase {
    String methodAop(String param);

    void methodAopVoid(String param);
    String myTransaction();
}
