package java8.optional;

import entity.Address;
import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import util.UtilLog;

import java.util.Optional;

@Slf4j
public class TestOptional {

    User user = new User(1L, "test", "test", "test@", new Address(1L, "中国", "江西", "南昌"));

    @Test
    public void test() {
        Optional<User> userOptional = Optional.ofNullable(user);
        String userName = userOptional.map(user -> user.getEmailAddress()).orElse("unknown");
        log.info(UtilLog.prefixLog(userName));
    }

    @Test
    public void testNullable() {
        Optional<User> userNotNull = Optional.of(user);//of，参数一定不能为null，否则报错
        Optional<User> userNull = Optional.ofNullable(null);//参数可以null
        log.info(userNull.toString());
        User user = userNull.orElse(getUser());//如果参数为null，则返回另一个值，即使参数不为null
        log.info(user.toString());
        User user1 = userNull.orElseGet(() -> getUser());//这个地方如果参数是null，则调用方法返回的
        log.info(user1.toString());

        User user2 = userNotNull.orElse(getUser());//如果参数不为null，也会生成user
        log.info(user.toString());
        User user3 = userNotNull.orElseGet(() -> getUser());//由于参数不为null，不会调用getUser方法
        log.info(user1.toString());
    }

    private User getUser() {
        log.info("create User");
        return user;
    }

}
