package myjava;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ForCoverageTest {

    @Test
    public void testSimple() {
        ForCoverage forCoverage = new ForCoverage();
        forCoverage.testSimpleIf(1, 0);
        forCoverage.testSimpleIf(2, 0);
        forCoverage.testSimpleIf(0, 2);
        forCoverage.testSimpleIf(1, 2);
//        int i2 = forCoverage.testSimpleIf(0);
    }

    @Test
    public void test() {
        ForCoverage forCoverage = new ForCoverage();
        int i = forCoverage.testCoverage(1);
        Assert.assertEquals(1, i);
    }

    @Test
    public void test2() {
        ForCoverage forCoverage = new ForCoverage();
        forCoverage.testIf(1, 1, 6);
        forCoverage.testIf(1, 2, 5);
        forCoverage.testIf(2, 4, 4);
        forCoverage.testIf(2, 2, 1);
        forCoverage.testIf(2, 2, 2);
        forCoverage.testIf(2, 2, 3);
        forCoverage.testIf(2, 2, 4);
        forCoverage.testIf(2, 2, 6);
//        int i4 = forCoverage.testIf(2,2);
//        int i3 = forCoverage.testIf(2,2);
//        Assert.assertEquals(-2, i4);

//        int j = forCoverage.testIf(inputB);
//        Assert.assertEquals(j, 0);

    }
}