package forCollection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIterator_Iterator {
    /**
     * ListIterator： 可以用来移除数据&插入数据
     * Iterator：        只能用来移除数据
     */

    @Test
    public void testListIterator(){

        List<String> stringList=new ArrayList<>();
        stringList.add("sdf");
        stringList.add("sdf");
        stringList.add("12345");
        stringList.add("47");
        ListIterator<String> listIterator = stringList.listIterator();
        boolean first=true;
        while(listIterator.hasNext()){
            String next = listIterator.next();
            if(next.equals("sdf")){
                listIterator.remove();
            }
            if(first){//调用listIterator的添加方法，可以在当前iterator位置后面添加元素
                listIterator.add("hello");
                listIterator.add("hello2");
                first=false;
            }
            if(!listIterator.hasNext()){
                listIterator.add("last hello");
            }
        }
        System.out.println(stringList);
    }



    @Test
    public void testIterator(){
        List<String> stringList=new ArrayList<>();
        stringList.add("sdf");
        stringList.add("12345");
        stringList.add("47");
        Iterator<String> iterator = stringList.iterator();
        boolean first=true;
        while(iterator.hasNext()){
            String next = iterator.next();
            if(next.equals("sdf")){
                iterator.remove();
            }
            if(first){
                stringList.add("hello");//调用集合的添加方法，会抛ConcurrentModificationException
                first=false;
            }
        }
        System.out.println(stringList);
    }

    @Test
    public void testFor(){
        List<String> stringList=new ArrayList<>();
        stringList.add("sdf");
        stringList.add("12345");
        stringList.add("47");
        stringList.add("472");
        for(int i=0;i<stringList.size();i++){//使用for循环可以同时进行增删，但是不保证能够遍历到所有元素，因为有可能连续删除，但是下标只变化一次
            if(i==1){
                stringList.remove(i);
                stringList.remove(i);
            }
            if(i==1){
                stringList.add("123");
            }
            System.out.println(stringList.get(i));
        }
        System.out.println(stringList);
    }
}
