package subLearn;

import org.junit.Test;

import java.util.Properties;

public class TestSystemProperties {

    @Test
    public void test(){
        Properties properties=System.getProperties();
        properties.forEach((k,v) -> System.out.println(k+":"+v));
    }
}
