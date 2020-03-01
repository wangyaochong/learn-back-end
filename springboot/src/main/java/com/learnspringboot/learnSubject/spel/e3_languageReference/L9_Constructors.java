package com.learnspringboot.learnSubject.spel.e3_languageReference;

import com.learnspringboot.learnSubject.spel.basic.Inventor;
import com.learnspringboot.learnSubject.spel.basic.Society;
import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.HashMap;
import java.util.Map;

public class L9_Constructors {
    private ExpressionParser parser = new SpelExpressionParser();
    private SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

    @Test
    public void testConstructors() {
        Society societyContext = new Society();
        societyContext.setName("ieee");
        Map<String, String> simple = new HashMap<>();
        simple.put("BeiJing", "bj");
        simple.put("HangZhou", "hz");
        societyContext.setOfficers(simple);

        Inventor einstein = parser.parseExpression("new com.learnspringboot.learnSubject.spel.basic.Inventor('Albert Einstein', 'German')").getValue(Inventor.class);
        parser.parseExpression("members.add(new com.learnspringboot.learnSubject.spel.basic.Inventor( 'Albert Einstein', 'German'))").getValue(societyContext);
        System.out.println(einstein);
        System.out.println(societyContext);
    }
}
