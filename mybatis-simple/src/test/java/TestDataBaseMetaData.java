import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestDataBaseMetaData {

    @Test
    public void test() throws IOException, SQLException {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String url = properties.getProperty("jdbc.url");
        String userName = properties.getProperty("jdbc.userName");
        String password = properties.getProperty("jdbc.password");
        Connection connection = DriverManager.getConnection(url, userName, password);
        DatabaseMetaData metaData = connection.getMetaData();

        String databaseProductName = metaData.getDatabaseProductName();//这个方法在配置dataBaseId属性时会使用到
        System.out.println(databaseProductName);//databaseId
    }
}
