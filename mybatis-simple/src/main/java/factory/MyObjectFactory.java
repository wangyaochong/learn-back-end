package factory;

import entity.UserM;
import lombok.Data;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;

@Data
public class MyObjectFactory extends DefaultObjectFactory {
    String specialName;


    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        T t = super.create(type, constructorArgTypes, constructorArgs);
        if (type.getSimpleName().equals("UserM")) {
            UserM user = (UserM) t;
            user.setForObjectFactory("forObjectFactory");
        }
        return t;
    }
}
