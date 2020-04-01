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

    @Test
    public void testBracketToPair() {
        System.out.println(getExpressionInBracket("((1)+2)", 0));
    }

    //    取出括号里面的表达式
    public String getExpressionInBracket(String expression, int index) {
        int bracketToPair = 0;//防止括号不成对，
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
            return exp.toString();
        }
        return null;
    }

    @Test
    public void testgetNextOperand() {
        System.out.println(getNextOperand("as&&bc||", 4, new String[]{"||", "&&"}));
    }

    //    取出下一个操作数
    public String getNextOperand(String expression, int index, String[] operator) {
        StringBuilder nextExpression = new StringBuilder();
        for (int i = index ; i < expression.length() ; i++) {
            if (getOperator(expression, i, operator) != null) {
                return nextExpression.toString();
            }
            nextExpression.append(expression.charAt(i));
        }
        return nextExpression.toString();
    }

    public String getOperator(String expression, int index, String[] operator) {
        for (int j = 0 ; j < operator.length ; j++) {
            int k;
            for (k = 0; k < operator[j].length() && operator[j].charAt(k) == expression.charAt(index + k) ; k++) ;
            if (k == operator[j].length()) {
                return operator[j];
            }
        }
        return null;
    }
    public int calculate(String expression) {
        String[] operator = {"+", "-", "*", "(", ")"};
        expression = expression.replaceAll(" ", "");
        Stack<Integer> numStack = new Stack<>();
        Stack<EnumOperator> opStack = new Stack<>();
        for (int i = 0 ; i < expression.length() ; i++) {
            //如果是括号，就计算子表达式
            if (expression.charAt(i) == '(') {
                String exp = getExpressionInBracket(expression, i);
                numStack.push(calculate(exp));
                i += (exp.length() + 1);
            } else {
                String nextOperand = getNextOperand(expression, i, operator);
                if (!nextOperand.isEmpty()) {
                    numStack.push(Integer.parseInt(nextOperand));
                    i += nextOperand.length() - 1;
                } else {
                    String operator1 = getOperator(expression, i, operator);
                    EnumOperator op = EnumOperator.getByChar(operator1.charAt(0));
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
        System.out.println(calculate("1+2*(3+1)"));
    }
}
