package com.learnspringboot.learnSubject.spel.e3_languageReference;

import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

public class L6_Methods {
    private ExpressionParser parser = new SpelExpressionParser();
    private SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

    @Test
    public void test() {
        String bc = parser.parseExpression("'abc'.substring(1, 3)").getValue(String.class);
        System.out.println(bc);
    }
}
