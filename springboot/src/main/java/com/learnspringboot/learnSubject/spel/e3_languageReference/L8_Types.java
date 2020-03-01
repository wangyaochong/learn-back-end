package com.learnspringboot.learnSubject.spel.e3_languageReference;

import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

public class L8_Types {
    private ExpressionParser parser = new SpelExpressionParser();
    private SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();


    @Test
    public void test() {
        Class dateClass = parser.parseExpression("T(java.util.Date)").getValue(Class.class);
        Class stringClass = parser.parseExpression("T(String)").getValue(Class.class);
        boolean trueValue = parser.parseExpression("T(java.math.RoundingMode).CEILING < T(java.math.RoundingMode).FLOOR").getValue(Boolean.class);
        System.out.println(dateClass);
        System.out.println(stringClass);
        System.out.println(trueValue);
    }
}

