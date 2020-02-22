package src.my;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import src.constant.ConfigConstant;


//自定义的context初始化方法
public class MyApplicationInitializer implements ApplicationContextInitializer<XmlWebApplicationContext> {
    @Override
    public void initialize(XmlWebApplicationContext applicationContext) {
        applicationContext.setAllowBeanDefinitionOverriding(ConfigConstant.allowBeanDefinitionOverriding);//禁止定义两个相同名称或相同id的bean存在
        applicationContext.setAllowCircularReferences(ConfigConstant.allowCircularReferences);
    }
}
