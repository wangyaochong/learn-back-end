package java8.stream;

import entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestStream {
    @Test
    public void test() {

        List<User> userList = new ArrayList<>();
        long sum = userList.stream().mapToLong(User::getId).sum();
        System.out.println(sum);
    }

    @Test
    public void testFindFirst() {

        User user = new User();
        user.setName("abc");
        user.setId(1L);
        User user2 = new User();
        user2.setName("abc");
        user2.setId(2L);
        User user3 = new User();
        user3.setName("abc");
        user3.setId(3L);
        User user4 = new User();
        user4.setName("xyz");
        user4.setId(4L);

        List<User> list = new ArrayList<>();
        list.add(user4);
        list.add(user3);
        list.add(user2);
        list.add(user);

        System.out.println(list.stream().filter(e -> e.getName().equals("abc")).findFirst().get());
    }
}
