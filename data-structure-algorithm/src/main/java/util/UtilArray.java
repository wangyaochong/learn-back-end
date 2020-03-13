package util;

import org.junit.Test;

import java.util.Arrays;

public class UtilArray {
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void display(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
    @Test
    public void test() {
        int[] ints = {1, 2, 3};
        swap(ints, 0, 1);
        display(ints);
    }
}
