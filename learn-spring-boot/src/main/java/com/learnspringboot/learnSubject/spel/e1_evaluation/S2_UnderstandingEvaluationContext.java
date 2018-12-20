package com.learnspringboot.learnSubject.spel.e1_evaluation;

import com.learnspringboot.learnSubject.spel.basic.Simple;
import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void testMap() {
        Simple simple = new Simple();
        simple.booleanList.add(true);
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        Map<String, Map<String, Integer>> mapMap = new HashMap<>();
        mapMap.put("1", new HashMap<String, Integer>() {{
            put("1", 1);
        }});
        context.setVariable("map", mapMap);

        parser.parseExpression("booleanList[0]").setValue(context, simple, "false");
        System.out.println(simple.booleanList.get(0));
        System.out.println(parser.parseExpression("#map['1']['1']").getValue(context));


        System.out.println(parser.parseExpression("1>2||2<3&&2>3").getValue());//这个表达式说明&&优先级大于||
    }
}
