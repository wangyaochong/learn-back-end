package com.learnspringboot.learnSubject.spel.e3_languageReference;

import com.learnspringboot.learnSubject.spel.basic.Inventor;
import com.learnspringboot.learnSubject.spel.basic.PlaceOfBirth;
import com.learnspringboot.learnSubject.spel.basic.Society;
import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class L2_PropertiesArraysListsMapsandIndexers {
    private ExpressionParser parser = new SpelExpressionParser();
    GregorianCalendar c = new GregorianCalendar();
    Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");

    @Before
    public void before() {
        c.set(1856, Calendar.AUGUST, 9);
        tesla.setPlaceOfBirth(new PlaceOfBirth("beijing", "china"));
        tesla.setInventions(new String[]{"abc", "def", "hig", "123", "456"});
    }

    @Test
    public void test() {
        int year = (Integer) parser.parseExpression("Birthdate.Year + 1900").getValue(tesla);
        System.out.println(year);
        String city = (String) parser.parseExpression("placeOfBirth.city").getValue(tesla);
        System.out.println(city);

        Map<String, String> simple = new HashMap<>();
        simple.put("BeiJing", "bj");
        simple.put("HangZhou", "hz");

    }

    @Test
    public void testWithContext() {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        System.out.println(parser.parseExpression("inventions[3]").getValue(context, tesla, String.class));

        Society society = new Society();
        society.setName("ieee");
        Map<String, String> simple = new HashMap<>();
        simple.put("BeiJing", "bj");
        simple.put("HangZhou", "hz");
        society.setOfficers(simple);
        //map可以使用[]获取值
        System.out.println(parser.parseExpression("officers['BeiJing']").getValue(context, society, String.class));
    }
}
