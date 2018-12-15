package com.learnspringboot.learnSubject.spel.e3_languageReference;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

public class L11_Functions {

    @Test
    public void test() throws NoSuchMethodException {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        context.setVariable("upperCase", StringUtils.class.getDeclaredMethod("upperCase", String.class));
        String helloWorldReversed = parser.parseExpression("#upperCase('hello')").getValue(context, String.class);
        System.out.println(helloWorldReversed);
    }
}

