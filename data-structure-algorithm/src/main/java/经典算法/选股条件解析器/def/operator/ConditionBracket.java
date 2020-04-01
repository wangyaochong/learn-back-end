package 经典算法.选股条件解析器.def.operator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import 经典算法.选股条件解析器.def.interfaces.ConditionBasic;
import 经典算法.选股条件解析器.def.interfaces.ConditionMatchable;
import 经典算法.选股条件解析器.def.enums.ConditionOperatorEnum;
import 经典算法.选股条件解析器.def.interfaces.ConditionOperator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyaochong
 * @date 2020/4/1 03:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConditionBracket implements ConditionBasic, ConditionOperator {
    private ConditionBasic condition;

    @Override
    public String getOrderedExpression() {
        return "(" + condition.getOrderedExpression() + ")";
    }

    @Override
    public String match(String op) {
        if (op.equals("(")) {
            return op;
        }
        return null;
    }

    @Override
    public int getPriority() {
        return ConditionOperatorEnum.Bracket.ordinal();
    }

    @Override
    public String getMatchString() {
        return "(";
    }

    @Override
    public List<ConditionBasic> getInnerConditionList() {
        ArrayList<ConditionBasic> conditionBasics = new ArrayList<>();
        conditionBasics.add(condition);
        return conditionBasics;
    }

    @Override
    public void addConditionWithReduce(ConditionBasic conditionBasic) {
        this.condition=conditionBasic;
    }

    @Override
    public void addSimple(ConditionBasic conditionBasic) {
        this.condition=conditionBasic;
    }
}
