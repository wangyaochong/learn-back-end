package 经典算法.选股条件解析器.def;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import 经典算法.选股条件解析器.def.enums.ConditionOperatorEnum;
import 经典算法.选股条件解析器.def.interfaces.ConditionBasic;

/**
 * @author wangyaochong
 * @date 2020/4/1 03:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConditionOne implements ConditionBasic {
    String expression;

    @Override
    public String getOrderedExpression() {
        return expression;
    }

    @Override
    public int getPriority() {
        return ConditionOperatorEnum.One.ordinal();
    }
}
