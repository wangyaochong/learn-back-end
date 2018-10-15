import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import util.CoreUtil;
import util.LogUtil;

@Slf4j
public class TestDependency {
    @Test
    public void test(){
        CoreUtil.CoreUtilTest();
        log.info("test");
        log.error("test");
        log.info(LogUtil.prefixLog("test"));
    }
}
