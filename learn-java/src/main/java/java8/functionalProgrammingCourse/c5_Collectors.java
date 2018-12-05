package java8.functionalProgrammingCourse;

import entity.User;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class c5_Collectors {
    private List<User> users = Arrays.asList(
            User.builder().id(1L).name("test1").build(),
            User.builder().id(2L).name("test2").build(),
            User.builder().id(3L).name("test3").build(),
            User.builder().id(3L).name("test3").build());

    @Test
    public void testProducingCollections() {

        List<Long> list = users.stream().map(User::getId).collect(Collectors.toList());
        System.out.println(list);
        List<Long> arrayList = users.stream().map(User::getId).collect(Collectors.toCollection(ArrayList::new));//指定类型
        System.out.println(arrayList);

        Set<String> set = users.stream().map(User::getName).collect(Collectors.toSet());
        System.out.println(set);

        Map<Long, User> collect = users.stream().collect(Collectors.toMap(User::getId, Function.identity(), (e1, e2) -> e1));
        System.out.println(collect);
    }

    @Test
    public void testPartitionAndGrouping() {
        Map<Boolean, List<User>> partition = users.stream().collect(Collectors.partitioningBy((e) -> e.getId() <= 2L));
        System.out.println(partition);

        Map<Long, List<User>> groupBy = users.stream().collect(Collectors.groupingBy(User::getId));
        System.out.println(groupBy);
    }

    @Test
    public void testDownstreamCollectors() {
        Map<Long, Long> groupNumber = users.stream().collect(Collectors.groupingBy(User::getId, Collectors.counting()));//分组求数量
        System.out.println(groupNumber);
        Map<String, Long> groupSum = users.stream().collect(Collectors.groupingBy(User::getName, Collectors.summingLong(User::getId)));
        System.out.println(groupSum);
    }

}
