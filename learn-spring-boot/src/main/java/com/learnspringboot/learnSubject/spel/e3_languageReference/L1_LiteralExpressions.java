package com.learnspringboot.learnSubject.spel.e3_languageReference;

import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class L1_LiteralExpressions {
    @Test
    public void test() {
        ExpressionParser parser = new SpelExpressionParser();
        String strValue = (String) parser.parseExpression(" 'hello world' ").getValue();
        System.out.println(strValue);
        Double doubleValue = (Double) parser.parseExpression("1.23").getValue();
        System.out.println(doubleValue);
        Boolean booleanValue = (Boolean) parser.parseExpression("true").getValue();
        System.out.println(booleanValue);
        Object nullValue = parser.parseExpression("null").getValue();
        System.out.println(nullValue);
    }
}
