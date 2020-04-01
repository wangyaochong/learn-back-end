package leetcode.byCategory.栈;

import leetcode.byCategory.栈.计算器.EnumOperator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 将中缀表达式转换成逆波兰表达式（后缀表达式）
 */
public class ToReversePolish {
    public String toReversePolish(String midExpression) {
        List<String> result = new ArrayList<>();
        Stack<EnumOperator> opStack = new Stack<>();
        for (int i = 0; i < midExpression.length(); i++) {
            char c = midExpression.charAt(i);
            if (Character.isDigit(c)) {
                result.add(c + "");
            } else {
                EnumOperator opOut = EnumOperator.getByChar(c);
                if (opStack.isEmpty()) {
                    opStack.push(opOut);
                } else {
                    //如果是右括号，就弹出运算符栈，直到碰到左括号
                    if (EnumOperator.RIGHT_PARE.equals(opOut)) {
                        while (!opStack.peek().equals(EnumOperator.LEFT_PARE)) {
                            result.add(opStack.pop().toString());
                        }
                        opStack.pop();
                    } else {
                        //否则，比较优先级
                        EnumOperator peek = opStack.peek();
                        if (peek.getPriority() < opOut.getPriority()) {
                            opStack.push(opOut);
                        } else {
                            while (!opStack.isEmpty() && !peek.equals(EnumOperator.LEFT_PARE) && peek.getPriority() >= opOut.getPriority()) {
                                result.add(opStack.pop().toString());
                            }
                            opStack.push(opOut);
                        }
                    }

                }
            }
        }
        while (!opStack.isEmpty()) {
            result.add(opStack.pop().toString());
        }
        return result.toString();
    }

    @Test
    public void test() {
        System.out.println(toReversePolish("5+2+1"));
        System.out.println(toReversePolish("1+(2-5)+3*(3+4)"));
        System.out.println(toReversePolish("1*2+(5+3)*4"));
        System.out.println(toReversePolish("1+((2+3)*4)-5"));
    }
}
