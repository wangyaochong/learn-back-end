package 经典算法.选股条件解析器.def.interfaces;

import java.util.List;

/**
 * @author wangyaochong
 * @date 2020/4/1 03:59
 */
public interface ConditionMultiple {
    List<ConditionBasic> getInnerConditionList();

    //归并添加条件，对于同样类型的条件，归并到当前条件
    void addConditionWithReduce(ConditionBasic conditionBasic);

    //简单添加条件
    void addSimple(ConditionBasic conditionBasic);

}
