package com.learnspringboot.learnSubject.spel.e1_evaluation;

import com.learnspringboot.learnSubject.spel.basic.Simple;
import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class S2_UnderstandingEvaluationContext {

    private ExpressionParser parser = new SpelExpressionParser();

    /**
     * 主要有两种context：
     * StandardEvaluationContext
     * SimpleEvaluationContext
     */
    @Test
    public void test() {
        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();
        Simple simple = new Simple();
        simple.booleanList.add(true);
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        parser.parseExpression("booleanList[0]").setValue(context, simple, "false");
        System.out.println(simple.booleanList.get(0));
    }
}
