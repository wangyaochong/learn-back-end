package com.wangyaochong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.*;

/**
 * @author wangyaochong
 * date 2020/5/2 16:08
 */
@RunWith(MockitoJUnitRunner.class)
public class ArgumentMatcherTest {

    @Test
    public void testBasic() {
        List<Integer> list = mock(ArrayList.class);
        when(list.get(0)).thenReturn(100);
        assertThat(list.get(0), equalTo(100));
        assertThat(list.get(1), nullValue());
    }

    @Test
    public void testThen() {
        Foo foo = mock(Foo.class);
        when(foo.function(ArgumentMatchers.isA(Work1.class))).then((Answer<Integer>) invocation -> {
            System.out.println("自定义方法执行");
            return 3;
        });
        int function = foo.function(new Work1());
        assertThat(function, equalTo(3));
    }

    @Test
    public void testComplex() {
        Foo foo = mock(Foo.class);
        when(foo.function(ArgumentMatchers.isA(Work1.class))).thenReturn(100);
        int result = foo.function(new Work1());
        assertThat(result, equalTo(100));

        int result2 = foo.function(new Work2());
        assertThat(result2, equalTo(0));

        reset(foo);

        when(foo.function(ArgumentMatchers.any(Work1.class))).thenReturn(100);
        int result3 = foo.function(new Work1());
        assertThat(result3, equalTo(100));

    }

    static class Foo {
        int function(MyWork myWork) {
            return myWork.work();
        }
    }

    interface MyWork {
        /**
         * 测试方法
         * @return 无
         */
        int work();
    }

    static class Work1 implements MyWork {

        @Override public int work() {
            return 0;
        }
    }

    static class Work2 implements MyWork {

        @Override public int work() {
            throw new RuntimeException();
        }
    }
}
