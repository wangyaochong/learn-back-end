package com.learnspringboot.learnSubject.spel.e3_languageReference;

import com.learnspringboot.learnSubject.spel.basic.Inventor;
import com.learnspringboot.learnSubject.spel.basic.Society;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.HashMap;
import java.util.Map;

public class L7_Operators {
    private ExpressionParser parser = new SpelExpressionParser();
    private SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

    @Test
    public void testRelationalOperators() {
        System.out.println(parser.parseExpression("2 == 2").getValue(Boolean.class));
        System.out.println(parser.parseExpression("2 < -5.0").getValue(Boolean.class));
        System.out.println(parser.parseExpression("'black' < 'block'").getValue(Boolean.class));
        System.out.println(parser.parseExpression("'xyz' instanceof T(Integer)").getValue(Boolean.class));

        System.out.println(parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class));
        System.out.println(parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class));
        System.out.println(parser.parseExpression("'5.0067' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class));
    }

    @Test
    public void testLogicalOperators() {
        Society societyContext = new Society();
        societyContext.setName("ieee");
        Map<String, String> simple = new HashMap<>();
        simple.put("BeiJing", "bj");
        simple.put("HangZhou", "hz");
        societyContext.setOfficers(simple);
        System.out.println(parser.parseExpression("true and false").getValue(Boolean.class));
        String expression = "isMember('Nikola Tesla') and isMember('Mihajlo Pupin')";
        System.out.println(parser.parseExpression(expression).getValue(societyContext, Boolean.class));
        System.out.println(parser.parseExpression("true or false").getValue(Boolean.class));
        String expression2 = "isMember('Nikola Tesla') or isMember('Albert Einstein')";
        System.out.println(parser.parseExpression(expression2).getValue(societyContext, Boolean.class));
        System.out.println(parser.parseExpression("!true").getValue(Boolean.class));
        String expression3 = "isMember('Nikola Tesla') and !isMember('Mihajlo Pupin')";
        System.out.println(parser.parseExpression(expression3).getValue(societyContext, Boolean.class));

    }

    @Test
    public void testMathematicalOperators() {
        System.out.println(parser.parseExpression("1 + 1").getValue(Integer.class));
        System.out.println(parser.parseExpression("'test' + ' ' + 'string'").getValue(String.class));
        System.out.println(parser.parseExpression("1 - -3").getValue(Integer.class));
        System.out.println(parser.parseExpression("1000.00 - 1e4").getValue(Double.class));
        System.out.println(parser.parseExpression("-2 * -3").getValue(Integer.class));
        System.out.println(parser.parseExpression("2.0 * 3e0 * 4").getValue(Double.class));
        System.out.println(parser.parseExpression("6 / -3").getValue(Integer.class));
        System.out.println(parser.parseExpression("8.0 / 4e0 / 2").getValue(Double.class));
        System.out.println(parser.parseExpression("7 % 4").getValue(Integer.class));
        System.out.println(parser.parseExpression("8 / 5 % 2").getValue(Integer.class));
        System.out.println(parser.parseExpression("1+2-3*8").getValue(Integer.class));
        System.out.println(parser.parseExpression("1+2-3*8").getValue(Integer.class));
    }

    @Test
    public void testAssignmentOperator() {
        Inventor inventor = new Inventor();
        EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
        parser.parseExpression("Name").setValue(context, inventor, "Aleksandar Seovic");
        System.out.println(inventor.getName());
        String aleks = parser.parseExpression("Name = 'Aleksandar Seovic 第二种方式'").getValue(context, inventor, String.class);
        System.out.println(aleks);

    }


}
