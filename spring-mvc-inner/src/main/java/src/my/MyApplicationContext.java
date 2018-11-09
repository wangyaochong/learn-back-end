package src.my;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;

public class MyApplicationContext extends AbstractApplicationContext {
    @Override
    protected void refreshBeanFactory() throws BeansException, IllegalStateException {

    }

    @Override
    protected void closeBeanFactory() {

    }

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
        return null;
    }
}
