package java8.stream;

import entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestStream {
    @Test
    public void test(){

        List<User> userList = new ArrayList<>();
        long sum = userList.stream().mapToLong(User::getId).sum();
        System.out.println(sum);
    }
}
