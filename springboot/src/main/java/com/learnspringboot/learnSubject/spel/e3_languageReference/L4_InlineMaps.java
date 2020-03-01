package com.learnspringboot.learnSubject.spel.e3_languageReference;

import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.Map;

public class L4_InlineMaps {
    private ExpressionParser parser = new SpelExpressionParser();
    private SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

    @Test
    public void test() {
        Map inventorInfo = (Map) parser.parseExpression("{name:'Nikola',dob:'10-July-1856'}").getValue(context);
        Map mapOfMaps = (Map) parser.parseExpression("{name:{first:'Nikola',last:'Tesla'},dob:{day:10,month:'July',year:1856}}").getValue(context);
        System.out.println(inventorInfo);
        System.out.println(mapOfMaps);
    }
}
