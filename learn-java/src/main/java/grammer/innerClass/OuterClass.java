package grammer.innerClass;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class OuterClass {
    public int outerField;
    public void displayOuterFiled(){
        log.info("outerField={}",outerField);
    }
    public static int outerStaticField;
    public static void displayOutStaticField(){
        log.info("outerStaticField={}",outerStaticField);
    }


     public class InnerInnerClass{


         int innerField;
         public void displayInnerField(){
             log.info("innerField={}",innerField);
         }

//         static int i;//普通内部类不能有非静态成员变量
//         static void someMethod(){//普通内部类不能有非静态成员变量
//         }

         public void accessOuter(){
             //非静态内部类可以访问所有外部类的字段和方法，包括静态字段方法和非静态字段方法
             log.info("outerField={}",outerField);
             displayOuterFiled();
             log.info("outerStaticField={}",outerStaticField);
             displayOutStaticField();
         }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerInnerClass i = outerClass.new InnerInnerClass();//初始化普通内部类对象需要先创建外部类
        i.displayInnerField();
    }
}
