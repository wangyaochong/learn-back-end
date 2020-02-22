package src.my;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import src.bean.FactoryBeanObject;
@Component
public class MyFactoryBean implements FactoryBean<FactoryBeanObject> {
    @Override
    public FactoryBeanObject getObject() throws Exception {
        return new FactoryBeanObject();
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryBeanObject.class;
    }
}
