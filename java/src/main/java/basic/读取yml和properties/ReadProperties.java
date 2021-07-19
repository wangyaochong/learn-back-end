package basic.读取yml和properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//读取Properties配置文件
public class ReadProperties {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = ReadProperties.class.getResourceAsStream("/test1.properties");
//        InputStream resourceAsStream = ClassLoader.getSystemResourceAsStream("test.properties");
        properties.load(resourceAsStream);
        UtilProperties.display(properties);
    }
}
