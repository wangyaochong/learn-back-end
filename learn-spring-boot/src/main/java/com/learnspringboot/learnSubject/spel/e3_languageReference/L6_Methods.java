package com.learnspringboot.learnSubject.spel.e3_languageReference;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class L6_Methods {
    private ExpressionParser parser = new SpelExpressionParser();
    private EvaluationContext context = new StandardEvaluationContext();

    @Test
    public void test() {
        String bc = parser.parseExpression("'abc'.substring(1, 3)").getValue(String.class);
        System.out.println(bc);
    }

    @Test
    public void testMethod() throws NoSuchMethodException {
//        context.setVariable("max", Math.class.getDeclaredMethod("max", int.class, int.class));
//        context.setVariable("max", Math.class.getDeclaredMethod("max", long.class, long.class));
//        context.setVariable("max", Math.class.getDeclaredMethod("max", float.class, float.class));
        context.setVariable("max", Math.class.getDeclaredMethod("max", double.class, double.class));
        System.out.println(parser.parseExpression("#max(1,2)").getValue(context));
        System.out.println(parser.parseExpression("#max(1L,2L)").getValue(context));
        System.out.println(parser.parseExpression("#max(1.2,0)").getValue(context));

    }

    @Test
    public void testJava8Function() {
        Consumer<Object> consumer = System.out::println;
        consumer.accept("123");
        context.setVariable("print", consumer);
        System.out.println(parser.parseExpression("#print").getValue(context));
        parser.parseExpression("#print.accept('456')").getValue(context);


        BiFunction<Double, Double, Double> max = Math::max;

        context.setVariable("max", (BiFunction<Double, Double, Double>) (Math::max));
        System.out.println(parser.parseExpression("#max.apply(1.2,3.4)").getValue(context));
    }
}
