package com.wangyaochong;

import com.wangyaochong.common.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

/**
 * @author wangyaochong
 * date 2020/5/2 16:24
 */
@RunWith(MockitoJUnitRunner.class)
public class ArgumentMatcherWildcardTest {

    @Mock
    MyService myService;

    @Test
    public void testWildcard() {
        when(myService.method1(anyInt(), anyString(), anyCollection(), isA(Serializable.class))).thenReturn(100);
        int abc = myService.method1(1, "2", new ArrayList(), "abc");
        assertThat(abc, equalTo(100));

        int efg = myService.method1(1, "2", new HashSet(), "efg");
        assertThat(efg, equalTo(100));
    }

    @Test
    public void testSpecial() {
        when(myService.method1(anyInt(), startsWith("abc"), anyCollection(), isA(Serializable.class))).thenReturn(100);

        int abc = myService.method1(1, "abc", new ArrayList(), "abc");
        assertThat(abc, equalTo(100));
        int abcd = myService.method1(1, "abcd", new ArrayList(), "abc");
        assertThat(abcd, equalTo(100));

        int efg = myService.method1(1, "efg", new ArrayList(), "abc");
        assertThat(efg, equalTo(0));//没有匹配上返回默认值
    }

    @Test
    public void testWildcardVoid() {
        doNothing().when(myService).method2(anyInt(), startsWith("abc"), anyCollection(), isA(Serializable.class));
        ArrayList collection = new ArrayList();
        myService.method2(1, "abc", collection, "abc");
        verify(myService, times(1)).method2(1, "abc", collection, "abc");
    }

}
