package com.learnspringboot.learnSubject.spel.e3_languageReference;

import com.learnspringboot.learnSubject.spel.basic.Inventor;
import com.learnspringboot.learnSubject.spel.basic.PlaceOfBirth;
import com.learnspringboot.learnSubject.spel.basic.Society;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L16_CollectionSelection {
    ExpressionParser parser = new SpelExpressionParser();
    EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

    @Test
    public void test() {
        Society society = new Society();
        society.setName("ieee");
        Map<String, String> simple = new HashMap<>();
        simple.put("BeiJing", "bj");
        simple.put("HangZhou", "hz");
        society.setOfficers(simple);
        society.setMembers(Arrays.asList(
                new Inventor("wangyaochong", "china", null, null, new PlaceOfBirth("beijing", "china")),
                new Inventor("sss", "Serbian", null, null, new PlaceOfBirth("sss", "sss")),
                new Inventor("www", "Serbian", null, null, new PlaceOfBirth("www", "www"))));
        System.out.println(society.isMember("Nikola Tesla"));
        parser.parseExpression("Name").setValue(society, "IEEE");
        EvaluationContext societyContext = new StandardEvaluationContext(society);

        List<Inventor> list = (List<Inventor>) parser.parseExpression("Members.?[Nationality == 'Serbian']").getValue(societyContext);
        System.out.println(list);

        Map<Integer, Integer> integerMap = new HashMap<>();
        integerMap.put(1, 1);
        integerMap.put(2, 2);
        integerMap.put(3, 3);
        integerMap.put(10, 100);
        integerMap.put(20, 200);
        integerMap.put(30, 300);
        societyContext.setVariable("map", integerMap);
        System.out.println(parser.parseExpression("#map.?[value<27]").getValue(societyContext));
        System.out.println(parser.parseExpression("#map.?[key<27]").getValue(societyContext));//？所有满足条件的
        System.out.println(parser.parseExpression("#map.^[key<27]").getValue(societyContext));//^第一个满足条件的
        System.out.println(parser.parseExpression("#map.$[key<27]").getValue(societyContext));//$最后一个满足条件的

        System.out.println(parser.parseExpression("members.![placeOfBirth.city]").getValue(societyContext));//使用!进行映射
        System.out.println(parser.parseExpression("members.![placeOfBirth]").getValue(societyContext));//使用!进行映射
    }


}
