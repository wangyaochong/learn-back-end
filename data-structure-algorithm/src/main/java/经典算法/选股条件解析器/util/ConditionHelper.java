package 经典算法.选股条件解析器.util;

import 经典算法.选股条件解析器.def.interfaces.ConditionBasic;
import 经典算法.选股条件解析器.def.interfaces.ConditionMultiple;

import java.util.Comparator;
import java.util.List;

/**
 * @author wangyaochong
 * @date 2020/4/1 04:03
 */
public class ConditionHelper {

    public static void reduceTypeAdd(ConditionMultiple container, ConditionBasic target) {
        if (container.getClass() == target.getClass()) {
            for (ConditionBasic conditionBasic : ((ConditionMultiple) target).getInnerConditionList()) {
                container.addSimple(conditionBasic);
            }
        } else {
            container.addSimple(target);
        }
    }

    public static String concatSameCondition(List<ConditionBasic> conditionList, String op) {
        conditionList.sort(Comparator.comparing(ConditionBasic::getOrderedExpression));
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < conditionList.size() ; i++) {
            result.append(conditionList.get(i).getOrderedExpression());
            if (i != conditionList.size() - 1) {
                result.append(op);
            }
        }
        return result.toString();
    }

}
