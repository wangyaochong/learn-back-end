package 经典算法.选股条件解析器.def;

import lombok.Data;
import 经典算法.选股条件解析器.def.interfaces.ConditionBasic;
import 经典算法.选股条件解析器.def.interfaces.ConditionMatchable;
import 经典算法.选股条件解析器.def.interfaces.ConditionMultiple;
import 经典算法.选股条件解析器.def.interfaces.ConditionOperator;
import 经典算法.选股条件解析器.def.operator.ConditionAnd;
import 经典算法.选股条件解析器.def.operator.ConditionBracket;
import 经典算法.选股条件解析器.def.operator.ConditionOr;
import 经典算法.选股条件解析器.util.UtilExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * condition解析器
 *
 * @author wangyaochong
 * @date 2020/4/1 05:05
 */

@Data
public class ConditionParser {
    static List<ConditionOperator> conditionPrototype;
    static List<String> operatorList;

    static {
        conditionPrototype = new ArrayList<>();
        conditionPrototype.add(new ConditionAnd());
        conditionPrototype.add(new ConditionBracket());
        conditionPrototype.add(new ConditionOr());

        operatorList = new ArrayList<>();
        for (ConditionOperator conditionMatchable : conditionPrototype) {
            operatorList.add(conditionMatchable.getMatchString());
        }
        operatorList.add(")");
    }
    private static ConditionOperator getConditionOperatorByString(String op) {
        for (ConditionOperator condition : conditionPrototype) {
            String match = condition.match(op);
            if (match != null) {
                try {
                    return condition.getClass().newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    public static ConditionBasic parse(String expression) {
        expression = expression.replaceAll(" ", "");
        Stack<ConditionBasic> numStack = new Stack<>();
        Stack<ConditionOperator> opStack = new Stack<>();
        int i = 0;
        while (i < expression.length()) {
            if (expression.charAt(i) == ')') {
                throw new RuntimeException("多余的')'");
            }
//            如果是括号，就计算子表达式
            if (expression.charAt(i) == '(') {
                String exp = UtilExpression.getExpressionInBracket(expression, i);
                ConditionBasic calculate = parse(exp);
                numStack.push(new ConditionBracket(calculate));
                i += (exp.length() + 2);
            } else {
                String nextOperand = UtilExpression.getNextOperand(expression, i, operatorList);
                if (!nextOperand.isEmpty()) {
                    numStack.push(new ConditionOne(nextOperand));
                    i += nextOperand.length();
                } else {
                    String operator = UtilExpression.getOperator(expression, i, operatorList);
//                    获取操作符
                    ConditionOperator op = getConditionOperatorByString(operator);
                    i += operator.length();
                    if (opStack.isEmpty()) {//如果是空的，直接压入
                        opStack.push(op);
                    } else {
//                        否则需要比较优先级
                        ConditionOperator peek = opStack.peek();
//                        优先级更高，则压入
                        if (op.getPriority() > peek.getPriority()) {
                            opStack.add(op);
                        } else {
                            ConditionBasic pop1 = numStack.pop();
                            ConditionBasic pop2 = numStack.pop();
                            peek.addConditionWithReduce(pop1);
                            peek.addConditionWithReduce(pop2);
                            numStack.add((ConditionBasic) peek);
                            opStack.pop();
                            opStack.add(op);
                        }
                    }
                }
            }
        }
        while (!opStack.empty()) {
            ConditionBasic pop1 = numStack.pop();
            ConditionBasic pop2 = numStack.pop();
            ConditionMultiple op = opStack.pop();
            op.addConditionWithReduce(pop1);
            op.addConditionWithReduce(pop2);
            numStack.push((ConditionBasic) op);
        }
        return numStack.peek();
    }

    public static void main(String[] args) {
        ConditionBasic condition = ConditionParser.parse("6||20&&((7||5)&&9)&&8&&((9||3)&&7)||0||10&&3||2&&4||3&&7||5&&8");
        ConditionBasic condition2 = ConditionParser.parse("6||20&&((7||5)&&9)&&8&&(9||7)||10&&3||0");
        String expression = condition.getOrderedExpression();
        String expression2 = condition2.getOrderedExpression();
        System.out.println(expression);
        System.out.println(expression2);
    }
}
