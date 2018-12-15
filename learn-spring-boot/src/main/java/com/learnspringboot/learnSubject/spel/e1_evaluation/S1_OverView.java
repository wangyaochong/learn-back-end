package com.learnspringboot.learnSubject.spel.e1_evaluation;

import com.learnspringboot.learnSubject.spel.basic.Inventor;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class S1_OverView {
    private ExpressionParser parser = new SpelExpressionParser();

    @Test
    public void test() {
        Expression expression = parser.parseExpression(" 'hello world' ");
        String strValue = (String) expression.getValue();
        System.out.println(strValue);
        System.out.println(parser.parseExpression(" 'hello world'.concat('!') ").getValue());//可以调用对应的方法
        System.out.println(parser.parseExpression(" 'hello'.length() ").getValue());
        System.out.println(parser.parseExpression(" new String('hello world').toUpperCase() ").getValue());
    }

    @Test
    public void testContext() {
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, Calendar.AUGUST, 9);
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
        System.out.println(parser.parseExpression("name").getValue(tesla));
        System.out.println(parser.parseExpression("name== 'Nikola Tesla' ").getValue(tesla));
    }

    @Test
    public void testExpression() {
        System.out.println(parser.parseExpression("1==2?true:false").getValue());
        System.out.println(parser.parseExpression("true||false").getValue());
        System.out.println(parser.parseExpression("true&&false").getValue());
    }
}
