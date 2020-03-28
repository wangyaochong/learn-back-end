package multiThread.三个特性;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

/**
 * 对于这个类，在maven clean install编译后，会有一个jar包，运行后就可以看到压测的结果
 * 这个类需要jdk9，才能运行，使用到了Thread.onSpinWait
 *
 * @author wangyaochong
 * @date 2020/3/27 21:41
 */
@JCStressTest
@Outcome(id = {"1", "4"}, expect = Expect.ACCEPTABLE, desc = "ok")
@Outcome(id = {"0"}, expect = Expect.ACCEPTABLE_INTERESTING, desc = "danger")
@State
public class Test3Ordering {

    int num = 0;
    boolean ready = false;

    @Actor
    public void actor1(I_Result r) {
        if (ready) {
            r.r1 = num + num;
        } else {
            r.r1 = 1;
        }
    }

    @Actor
    public void actor2(I_Result r) {
        num = 2;
        ready = true;
    }
}
