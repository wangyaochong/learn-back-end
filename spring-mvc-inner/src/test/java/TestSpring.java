import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import src.bean.TestBean;

public class TestSpring {

    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");


        TestBean bean = context.getBean(TestBean.class);
        System.out.println(bean.getName());
    }


}
