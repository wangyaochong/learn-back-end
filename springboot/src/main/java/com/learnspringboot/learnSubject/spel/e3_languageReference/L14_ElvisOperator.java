package com.learnspringboot.learnSubject.spel.e3_languageReference;

import com.learnspringboot.learnSubject.spel.basic.Inventor;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

public class L14_ElvisOperator {
    @Test
    public void test() {
        ExpressionParser parser = new SpelExpressionParser();
        String name = parser.parseExpression("name?:'Unknown'").getValue(new Inventor(), String.class);
        System.out.println(name);
    }


    @Test
    public void testComplex() {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        Inventor tesla = new Inventor("Nikola Tesla", "Serbian");
        String name = parser.parseExpression("Name?:'Elvis Presley'").getValue(context, tesla, String.class);
        System.out.println(name);
        tesla.setName(null);
        name = parser.parseExpression("Name?:'Elvis Presley'").getValue(context, tesla, String.class);
        System.out.println(name);
    }
}


