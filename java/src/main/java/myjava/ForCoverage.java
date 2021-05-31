package myjava;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ForCoverage {


    public int testCoverage(int type) {
        if (type == 0) {
            return method0();
        } else if (type == 1) {
            return method1();
        } else {
            return method2();
        }
    }

    public int testIf(int type, int type2,int c3) {
        int result = 1;
        if (type == 1) {
            System.out.println("这是");
            result += 1;
            if (type2 == 1) {
                result *= 2;
            } else {
                result = 0;
            }
        } else {
            if (type2 == 4) {
                result += 5;
            } else {
                result = testIf2(c3);
            }
        }
        return result;
    }

    public int testSimpleIf(int c1, int c2) {
        int count = 0;
        if (c1 == 1 && c2 == 2) {
            count++;
        }

        return count;
    }

    public int testIf2(int condition) {
        int count = 0;
        if (condition == 1) {
            count++;
        } else {
            if (condition == 3) {
                count += 5;
            } else {
                if (condition > 2) {
                    for (int i = 0; i < 5; i++) {
                        if (condition > 5) {
                            count += condition;
                        } else {
                            count += 2 * condition;
                        }
                    }
                } else {
                    count -= 2;
                }
            }
            System.out.println("");
        }

        return count;
    }


    public int method0() {
        return 0;
    }

    public int method1() {
        return 1;
    }

    public int method2() {
        return 2;
    }

}
