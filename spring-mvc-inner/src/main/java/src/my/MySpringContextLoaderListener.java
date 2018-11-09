package src.my;

import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import src.constant.ConfigConstant;

import javax.servlet.ServletContext;

public class MySpringContextLoaderListener extends ContextLoaderListener {
    @Override
    protected void customizeContext(ServletContext servletContext, ConfigurableWebApplicationContext applicationContext) {
        super.customizeContext(servletContext, applicationContext);


        XmlWebApplicationContext context = (XmlWebApplicationContext) applicationContext;
        context.setAllowBeanDefinitionOverriding(ConfigConstant.allowBeanDefinitionOverriding); //在这里将XmlWebApplicationContext属性allowBeanDefinitionOverriding设置为false,这个属性的值最终
        context.setAllowCircularReferences(ConfigConstant.allowCircularReferences);
        //会传递给DefaultListableBeanFactory类的allowBeanDefinitionOverriding属性

    }
}
