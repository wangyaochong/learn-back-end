package com.learnspringboot.learnSubject.spel.e3_languageReference;

import com.learnspringboot.learnSubject.spel.basic.Society;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.Map;

public class L13_TernaryOperator {
    private ExpressionParser parser = new SpelExpressionParser();

    @Test
    public void test() {
        System.out.println(parser.parseExpression("false ? 'trueExp' : 'falseExp'").getValue(String.class));


        Society society = new Society();
        society.setName("ieee");
        Map<String, String> simple = new HashMap<>();
        simple.put("BeiJing", "bj");
        simple.put("HangZhou", "hz");
        society.setOfficers(simple);
        System.out.println(society.isMember("Nikola Tesla"));
        parser.parseExpression("Name").setValue(society, "IEEE");
        EvaluationContext societyContext = new StandardEvaluationContext(society);
        societyContext.setVariable("queryName", "Nikola Tesla");
        String expression = "isMember(#queryName)? #queryName + ' is a member of the ' + Name + ' Society' : #queryName + ' is not a member of the ' + Name + ' Society'";
        String queryResultString = parser.parseExpression(expression).getValue(societyContext, String.class);
        System.out.println(queryResultString);

    }
}
