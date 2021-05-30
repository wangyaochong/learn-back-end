package grammer.innerClass;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class InnerClass {
    public int outerField;

    public void displayOuterFiled() {
        log.info("outerField={}", outerField);
        InnerInnerClass innerClass = new InnerInnerClass();//普通方法可以直接访问，静态方法需要
    }

    public static int outerStaticField;

    public static void displayOutStaticField() {
        log.info("outerStaticField={}", outerStaticField);
    }


    public class InnerInnerClass {


        int innerField;

        public void displayInnerField() {
            log.info("innerField={}", innerField);
        }
//非静态内部类的访问，一定要绑定一个对象
//         static int i;//普通内部类不能有非静态成员变量
//         static void someMethod(){//普通内部类不能有非静态成员变量
//         }

        public void accessOuter() {
            //非静态内部类可以访问所有外部类的字段和方法，包括静态字段方法和非静态字段方法
            log.info("outerField={}", outerField);
            displayOuterFiled();
            log.info("outerStaticField={}", outerStaticField);
            displayOutStaticField();
        }
    }

    public static void main(String[] args) {
        InnerClass outerClass = new InnerClass();
        InnerClass.InnerInnerClass simpleInnerClass = outerClass.new InnerInnerClass();//初始化普通内部类对象需要先创建外部类
        simpleInnerClass.displayInnerField();

        StaticInnerClass.InnerClass staticInnerClass = new StaticInnerClass.InnerClass();
    }
}
