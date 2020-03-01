package com.learnspringboot.learnSubject.spel.e3_languageReference;

import com.learnspringboot.learnSubject.spel.basic.Inventor;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.Arrays;
import java.util.List;

public class L10_Variables {
    private ExpressionParser parser = new SpelExpressionParser();


    @Test
    public void test() {
        Inventor tesla = new Inventor("Nikola Tesla", "Serbian");
        EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
        context.setVariable("newName", "Mike Tesla");//可以设置变量
        context.setVariable("nameList", Arrays.asList("wangyaochong", "123", "hello"));
        System.out.println(parser.parseExpression("#this.name").getValue(tesla));
        parser.parseExpression("Name = #nameList[0]").getValue(context, tesla);
        System.out.println(tesla.getName());
    }

    @Test
    public void testThisRoot() {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17);
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
        context.setVariable("primes", primes);
        List<Integer> primesGreaterThanTen = (List<Integer>) parser.parseExpression("#primes.?[#this>10]").getValue(context);
        System.out.println(primesGreaterThanTen);
    }

}
