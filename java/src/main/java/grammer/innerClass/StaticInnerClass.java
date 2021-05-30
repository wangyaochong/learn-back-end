package grammer.innerClass;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class StaticInnerClass {
    public int outerField;

    public void displayOuterFiled() {
        log.info("outerField={}", outerField);
    }

    public static int outerStaticField;

    public static void displayOutStaticField() {
        log.info("outerStaticField={}", outerStaticField);
    }

    @Data
    public static class InnerClass {
        static int i;//普通内部类不能有非静态成员变量

        static void someMethod() {//普通内部类不能有非静态成员变量
        }

        int innerField;

        public void displayInnerField() {
            log.info("innerField={}", innerField);
        }

        public void accessOuter() {
            //静态内部类只能访问静态成员变量以及方法，不需要和具体的类对象绑定，可以直接new对象
            log.info("outerStaticField={}", outerStaticField);
            displayOutStaticField();
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();//静态内部类创建实例不需要构造外部类
        innerClass.displayInnerField();
    }

}
