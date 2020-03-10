package leetcode.byCategory.栈.计算器;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.util.Stack;

//1+1+3*2+1+4*5
public class CalculatorDouble {
    public double calculate(String expression) {
        expression = expression.replaceAll(" ", "");

        Stack<Double> numStack = new Stack<>();
        Stack<EnumOperator> opStack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            //如果是括号，就计算子表达式
            if (expression.charAt(i) == '(') {
                String exp = "";
                i++;
                int bracketToPair = 1;
                while (i < expression.length() && bracketToPair != 0) {
                    if (expression.charAt(i) == '(') {
                        bracketToPair++;
                    }
                    exp += expression.charAt(i);
                    i++;
                    if (expression.charAt(i) == ')') {
                        bracketToPair--;
                    }
                }
                numStack.push(calculate(exp));
            } else if (NumberUtils.isDigits(expression.charAt(i) + "")) {
                String num = "";
                for (int j = i; j < expression.length() && NumberUtils.isDigits("" + expression.charAt(j)); j++) {
                    num += expression.charAt(j);
                }
                numStack.push(Double.parseDouble(num));
                System.out.println(numStack + "," + opStack);
                i += num.length() - 1;
            } else {
                EnumOperator op = EnumOperator.getByChar(expression.charAt(i));
                if (opStack.isEmpty()) {
                    opStack.push(op);
                } else {
                    EnumOperator peek = opStack.peek();
                    if (op.getPriority() > peek.getPriority()) {
                        opStack.add(op);
                    } else {
                        Double pop = numStack.pop();
                        Double pop1 = numStack.pop();
                        numStack.add(peek.getResult(pop1, pop));
                        opStack.pop();
                        opStack.add(op);
                    }
                }
                System.out.println(numStack + "," + opStack);
            }
        }

        while (!opStack.empty()) {
            double pop = numStack.pop();
            double pop2 = numStack.pop();
            EnumOperator op = opStack.pop();
            numStack.push(op.getResult(pop2, pop));
        }
        return numStack.peek();
    }

    @Test
    public void test() {
        System.out.println(calculate("11 +( (3-4)*2+1)"));
    }
}
