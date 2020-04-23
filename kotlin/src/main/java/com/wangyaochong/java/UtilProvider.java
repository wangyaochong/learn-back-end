package com.wangyaochong.java;

import com.wangyaochong.kotlin.classHiarchey.classExtend.Rect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyaochong
 * @date 2020/4/23 04:39
 */
public class UtilProvider {
    public static List<Integer> provideIntegerList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        return list;
    }

    public static Integer[] provideIntegerArray() {
        return new Integer[]{1, 2, 3, 4, 5};
    }

    public static void callKotlin() {
        Rect rect = new Rect(1, 2);
        rect.say();

    }

    public static void main(String[] args) {
        callKotlin();
    }
}
