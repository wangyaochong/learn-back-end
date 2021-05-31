package com.wangyaochong;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import org.junit.Test;

import java.util.Locale;

public class TestJavaFaker {

    @Test
    public void test() {
        Faker faker = new Faker(Locale.CHINA);
        Address address = faker.address();
        System.out.println(address.fullAddress());
    }
}
