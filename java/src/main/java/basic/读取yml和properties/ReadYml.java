package basic.读取yml和properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Properties;

//读取YML
public class ReadYml {

    public static void main(String[] args) {
        Resource test1 = new ClassPathResource("test/test1.yml");
        Resource test2 = new ClassPathResource("test/test2.yml");
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        // 2:将加载的配置文件交给 YamlPropertiesFactoryBean
        yamlPropertiesFactoryBean.setResources(test1, test2);
        Properties properties = yamlPropertiesFactoryBean.getObject();
        UtilProperties.display(properties);
    }
}
