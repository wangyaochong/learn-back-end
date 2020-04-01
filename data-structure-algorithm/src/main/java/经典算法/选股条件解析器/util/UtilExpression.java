package 经典算法.选股条件解析器.util;

import java.util.List;

/**
 * @author wangyaochong
 * @date 2020/4/1 15:15
 */
public class UtilExpression {

    //    取出操作符
    public static String getOperator(String expression, int index, List<String> operator) {
        for (int j = 0 ; j < operator.size() ; j++) {
            int k;
            for (k = 0; k < operator.get(j).length() && operator.get(j).charAt(k) == expression.charAt(index + k) ; k++) ;
            if (k == operator.get(j).length()) {
                return operator.get(j);
            }
        }
        return null;
    }
        //    取出直到操作符的一个操作数
    public static String getNextOperand(String expression, int index, List<String> operator) {
        StringBuilder nextExpression = new StringBuilder();
        for (int i = index ; i < expression.length() ; i++) {
            if (getOperator(expression, i, operator) != null) {
                return nextExpression.toString();
            }
            nextExpression.append(expression.charAt(i));
        }
        return nextExpression.toString();
    }
     public static String getExpressionInBracket(String expression, int index) {
        //防止括号不成对，
        int bracketToPair = 0;
        if (expression.charAt(index) == '(') {
            StringBuilder exp = new StringBuilder();
            do {
                if (expression.charAt(index) == '(') {
                    if (bracketToPair != 0) {
                        exp.append(expression.charAt(index));
                    }
                    bracketToPair++;
                } else if (expression.charAt(index) == ')') {
                    bracketToPair--;
                    if (bracketToPair != 0) {
                        exp.append(expression.charAt(index));
                    }
                } else {
                    exp.append(expression.charAt(index));
                }
                index++;
            } while (index < expression.length() && bracketToPair != 0);
            if (bracketToPair == 0) {
                return exp.toString();
            } else {
                throw new RuntimeException("多余的'('");
            }
        }
        return null;
    }
}
