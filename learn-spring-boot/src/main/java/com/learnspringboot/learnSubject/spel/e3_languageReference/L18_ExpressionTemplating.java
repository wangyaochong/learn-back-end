package com.learnspringboot.learnSubject.spel.e3_languageReference;

import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class L18_ExpressionTemplating {
    ExpressionParser parser = new SpelExpressionParser();

    /**
     * ParserContext主要是用于自定义用于解析开始和结束符
     */
    @Test
    public void test() {
        String randomPhrase = parser.parseExpression(
                "random number is #{T(java.lang.Math).random()}",
                new TemplateParserContext()).getValue(String.class);
        System.out.println(randomPhrase);


        String randomPhrase2 = parser.parseExpression(
                "random number is $${T(java.lang.Math).random()}$$",
                new ParserContext() {
                    @Override
                    public boolean isTemplate() {
                        return true;
                    }

                    @Override
                    public String getExpressionPrefix() {
                        return "$${";
                    }

                    @Override
                    public String getExpressionSuffix() {
                        return "}$$";
                    }
                }).getValue(String.class);
        System.out.println(randomPhrase2);
    }
}
