import entity.UserM;
import mapper.UserMapperWithAnno;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import mapper.UserMapperWithXml;
import service.SessionFactoryService;

import java.io.IOException;
import java.util.List;

public class TestSessionFactory {


    @Test
    public void testGetFromConfig() throws IOException {
        // 2、创建SqlSessionFactory()
        SqlSessionFactory sessionFactory = SessionFactoryService.getFromConfigFile("mybatis-config.xml");
        SqlSession session = null;
        session = sessionFactory.openSession();
        UserMapperWithXml mapper = session.getMapper(UserMapperWithXml.class);
        UserM user = new UserM();
        user.setName("wangyaochong");
        user.setAge(25);
        mapper.insertUser(user);
        session.commit();// 添加、修改、删除操作最后需要提交事务
        List<UserM> userMS = mapper.selectAllUser();
        System.out.println(userMS);

        session.close();
    }
    @Test
    public void testGetFromCode(){
        SqlSessionFactory sessionFactory = SessionFactoryService.getFromCode();
        SqlSession session = null;
        session = sessionFactory.openSession();
        UserMapperWithAnno mapper = session.getMapper(UserMapperWithAnno.class);
        UserM user = new UserM();
        user.setName("wangyaochong");
        user.setAge(25);
        mapper.insertUser(user);
        session.commit();// 添加、修改、删除操作最后需要提交事务
        List<UserM> userMS = mapper.selectAllUser();
        System.out.println(userMS);
        session.close();


    }
    @Test
    public void testGetFromCode2(){
        SqlSessionFactory sessionFactory = SessionFactoryService.getFromCode();
        SqlSession session = null;
        session = sessionFactory.openSession();
        UserMapperWithXml mapper = session.getMapper(UserMapperWithXml.class);
        UserM user = new UserM();
        user.setName("wangyaochong");
        user.setAge(25);
        mapper.insertUser(user);
        session.commit();// 添加、修改、删除操作最后需要提交事务
        session.close();
    }


}
