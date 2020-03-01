package com.learnspringboot.learnSubject.spel.e3_languageReference;

import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.List;

public class L3_InlineLists {
    private ExpressionParser parser = new SpelExpressionParser();
    private SimpleEvaluationContext build = SimpleEvaluationContext.forReadOnlyDataBinding().build();

    @Test
    public void test() {
        List numbers = (List) parser.parseExpression("{1,2,3,4}").getValue(build);
        List listOfLists = (List) parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(build);
        System.out.println(numbers);
        System.out.println(listOfLists);
    }
}
