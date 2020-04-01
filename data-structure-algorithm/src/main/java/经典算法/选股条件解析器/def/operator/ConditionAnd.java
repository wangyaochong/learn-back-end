package 经典算法.选股条件解析器.def.operator;

import lombok.Data;
import 经典算法.选股条件解析器.def.interfaces.ConditionBasic;
import 经典算法.选股条件解析器.def.enums.ConditionOperatorEnum;
import 经典算法.选股条件解析器.def.interfaces.ConditionOperator;
import 经典算法.选股条件解析器.util.ConditionHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyaochong
 * @date 2020/4/1 03:58
 */
@Data
public class ConditionAnd implements ConditionBasic, ConditionOperator {
    String operatorString = "&&";
    private List<ConditionBasic> conditionList;

    public ConditionAnd() {
        this.conditionList = new ArrayList<>();
    }

    @Override
    public String getOrderedExpression() {
        return ConditionHelper.concatSameCondition(conditionList, operatorString);
    }

    @Override
    public String match(String op) {
        if (op.equals(operatorString)) {
            return operatorString;
        }
        return null;
    }


    @Override
    public int getPriority() {
        return ConditionOperatorEnum.And.ordinal();
    }

    @Override
    public String getMatchString() {
        return operatorString;
    }


    @Override
    public void addConditionWithReduce(ConditionBasic condition) {
        ConditionHelper.reduceTypeAdd(this,condition);
    }

    @Override
    public void addSimple(ConditionBasic conditionBasic) {
        this.conditionList.add(conditionBasic);
    }

    @Override
    public List<ConditionBasic> getInnerConditionList() {
        return conditionList;
    }

}
