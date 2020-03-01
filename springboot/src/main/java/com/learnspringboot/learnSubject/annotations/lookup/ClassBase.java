package com.learnspringboot.learnSubject.annotations.lookup;

public class ClassBase {
    long generateTime;

    public ClassBase(long generateTime) {
        this.generateTime = generateTime;
    }

    public void display() {
        System.out.println("generateTime=" + generateTime);
    }

}

