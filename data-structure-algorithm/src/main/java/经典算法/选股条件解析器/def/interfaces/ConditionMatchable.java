package 经典算法.选股条件解析器.def.interfaces;

/**
 * @author wangyaochong
 * @date 2020/4/1 03:59
 */
public interface ConditionMatchable {
    public String match(String op);
    int getPriority();
    String getMatchString();
}
