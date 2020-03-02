package wangyaochong.service;

import mapper.UserMapperWithAnno;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.IOException;
import java.io.InputStream;

public class SessionFactoryService {

    //从配置文件获取sessionFactory
    public static SqlSessionFactory getFromConfigFile(String configFilePath) {
        InputStream inputstream = null;
        try {
            inputstream = Resources.getResourceAsStream(configFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 2、创建SqlSessionFactory()
        return new SqlSessionFactoryBuilder().build(inputstream);
    }

    public static SqlSessionFactory getFromCode() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/trade?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8", "wangyaochong", "qwerqwer");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, driverManagerDataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(UserMapperWithAnno.class);
        configuration.addMappers("mybatis/UserMapperWithXml.xml");
        configuration.setMapUnderscoreToCamelCase(true);
        return new SqlSessionFactoryBuilder().build(configuration);
    }

}
