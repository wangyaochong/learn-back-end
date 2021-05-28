import myjava.ForCoverage;
import org.junit.Assert;
import org.junit.Test;

public class TestCoverage {

    @Test
    public void test(){
        ForCoverage forCoverage = new ForCoverage();
        int i = forCoverage.testCoverage(1);
        Assert.assertEquals(1,i);
    }
}
