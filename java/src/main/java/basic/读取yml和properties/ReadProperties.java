package basic.读取yml和properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//读取Properties配置文件
public class ReadProperties {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = ReadProperties.class.getResourceAsStream("/test/test1.properties");
//        InputStream resourceAsStream = ClassLoader.getSystemResourceAsStream("test.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        UtilProperties.display(properties);
    }
}
