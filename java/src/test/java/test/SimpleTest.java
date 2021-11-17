package test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleTest {
    /**
     * 一道面试题，请问
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Person implements Comparable<Person>{
        Integer id;
        Integer height;
        Integer age;


        @Override public int compareTo(Person o) {
            return String.format("%10s,%10s,%10s",age,height,id)
                    .compareTo(String.format("%10s,%10s,%10s",o.age,o.height,o.id));
        }
    }

    @Test
    public void test() {
        List<Person> list = new ArrayList<>();
        list.add(new Person(2, 2, 1));
        list.add(new Person(1, 2, 2));
        list.add(new Person(4, 3, 3));
        list.add(new Person(3, 3, 4));
        list.add(new Person(11, 3, 4));
        list.add(new Person(5, 3, 5));
        list.add(new Person(6, 3, 6));
        list.add(new Person(0, 4, 6));
        list.add(new Person(6, 3, 7));
        list.add(new Person(7, 3, 7));
        list.add(new Person(9, 8, 7));
        //System.out.println(" ".compareTo("1"));
        System.out.println("第一种方式，通过一次group by然后排序");
        Map<Integer, List<Person>> ageGroup = list.stream().collect(Collectors.groupingBy(Person::getAge));
        for (Map.Entry<Integer, List<Person>> entry : ageGroup.entrySet()) {
            Collections.sort(entry.getValue());
            System.out.println(entry.getValue().get(entry.getValue().size() - 1));
        }

        System.out.println("第二种方式，遍历一次");
        Map<Integer, Person> result = new HashMap<>();
        for (Person person : list) {
            Person mp = result.get(person.getAge());
            if(mp==null){
                result.put(person.getAge(),person);
            }else{
                if(mp.compareTo(person)<0){
                    result.put(person.getAge(), person);
                }
            }
        }
        for (Map.Entry<Integer, Person> integerPersonEntry : result.entrySet()) {
            System.out.println(integerPersonEntry.getValue());
        }
    }
}
