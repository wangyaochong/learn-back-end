package leetcode.byCategory.栈.计算器;

import org.junit.Test;

import java.util.Stack;
//
//enum EnumOperator {
//    //加号
//    ADD(1),
//    SUB(1),
//    MUL(2),
//    DIV(2);
//    int priority;
//
//    EnumOperator(int priority) {
//        this.priority = priority;
//    }
//
//    public int getPriority() {
//        return priority;
//    }
//polish
//    public static EnumOperator getByChar(char c) {
//        if (c == '-') return EnumOperator.SUB;
//        if (c == '+') return EnumOperator.ADD;
//        if (c == '*') return EnumOperator.MUL;
//        if (c == '/') return EnumOperator.DIV;
//        return null;
//    }
//
//    public int getResult(int op1, int op2) {
//        switch (this) {
//            case ADD:
//                return op1 + op2;
//            case DIV:
//                return op1 / op2;
//            case MUL:
//                return op1 * op2;
//            case SUB:
//                return op1 - op2;
//        }
//        return 0;
//    }
//
//    public double getResult(double op1, double op2) {
//        switch (this) {
//            case ADD:
//                return op1 + op2;
//            case DIV:
//                return op1 / op2;
//            case MUL:
//                return op1 * op2;
//            case SUB:
//                return op1 - op2;
//        }
//        return 0;
//    }
//}

//1+1+3*2+1+4*5
public class CalculatorInteger {
    public int calculate(String expression) {
        expression = expression.replaceAll(" ", "");
        Stack<Integer> numStack = new Stack<>();
        Stack<EnumOperator> opStack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            //如果是括号，就计算子表达式
            if (expression.charAt(i) == '(') {
                StringBuilder exp = new StringBuilder();
                i++;
                int bracketToPair = 1;
                while (i < expression.length() && bracketToPair != 0) {
                    if (expression.charAt(i) == '(') {
                        bracketToPair++;
                    }
                    exp.append(expression.charAt(i));
                    i++;
                    if (expression.charAt(i) == ')') {
                        bracketToPair--;
                    }
                }
                numStack.push(calculate(exp.toString()));
            } else if (Character.isDigit(expression.charAt(i))) {
                StringBuilder num = new StringBuilder();
                for (int j = i; j < expression.length() && Character.isDigit(expression.charAt(j)); j++) {
                    num.append(expression.charAt(j));
                }
                numStack.push(Integer.parseInt(num.toString()));
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
                        Integer pop = numStack.pop();
                        Integer pop1 = numStack.pop();
                        numStack.add(peek.getResult(pop1, pop));
                        opStack.pop();
                        opStack.add(op);
                    }
                }
            }
        }
        while (!opStack.empty()) {
            Integer pop = numStack.pop();
            Integer pop2 = numStack.pop();
            EnumOperator op = opStack.pop();
            numStack.push(op.getResult(pop2, pop));
        }
        return numStack.peek();
    }

    @Test
    public void test() {
        System.out.println(calculate("1*2+3*(5-4*2+6)"));
    }
}
