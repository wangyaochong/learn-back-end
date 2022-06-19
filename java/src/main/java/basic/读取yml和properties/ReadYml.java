package basic.读取yml和properties;

import org.junit.Test;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.yaml.snakeyaml.Yaml;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.util.Map;
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

    //从内存中加载配置，从字符串中加载配置
    @Test
    public void testReadFromString() {
        String str = "test1:\n" +
                "  xxx: test1\n" +
                "  ";
        byte[] b = str.getBytes();
        //内存读配置文件
        //内存文件，将文件保存在内存中
        ByteArrayInputStream ba = new ByteArrayInputStream(b);
        InputStreamResource inputStreamResource = new InputStreamResource(ba);

        //可以直接使用byteArrayResource
        //ByteArrayResource byteArrayResource = new ByteArrayResource(b);

        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();

        yamlPropertiesFactoryBean.setResources(inputStreamResource);
        Properties properties = yamlPropertiesFactoryBean.getObject();
        UtilProperties.display(properties);
    }

    @Test
    public void testReadYmlWithSnakeYml(){
        String str = "test1:\n" +
                "  xxx: \n" +
                "    ttt: abc\n ";
        byte[] b = str.getBytes();
        ByteArrayInputStream ba = new ByteArrayInputStream(b);
        Map<String,Object> map = new Yaml().loadAs(ba, Map.class);
        System.out.println(map);
    }
}
