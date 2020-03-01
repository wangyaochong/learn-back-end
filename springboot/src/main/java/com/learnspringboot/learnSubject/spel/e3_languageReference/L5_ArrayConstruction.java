package com.learnspringboot.learnSubject.spel.e3_languageReference;

import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

public class L5_ArrayConstruction {
    private ExpressionParser parser = new SpelExpressionParser();
    private SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

    @Test
    public void test() {
        int[] numbers1 = (int[]) parser.parseExpression("new int[4]").getValue(context);
        int[] numbers2 = (int[]) parser.parseExpression("new int[]{1,2,3}").getValue(context);
        int[][] numbers3 = (int[][]) parser.parseExpression("new int[4][5]").getValue(context);
    }
}


