package com.wangyaochong;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

/**
 * @author wangyaochong
 * date 2020/5/2 16:51
 */
@RunWith(MockitoJUnitRunner.class)
public class AssertMatcherTest {

    @Test
    public void testSimple() {
        int i = 10;
        assertThat(i, equalTo(10));
        assertThat(i, not(equalTo(20)));
        assertThat(i, is(10));
        assertThat(i, is(not(20)));

        double price = 2.35;
        assertThat(price, either(equalTo(2.35)).or(equalTo(2.56)));
        assertThat(price, both(equalTo(2.35)).and(not(equalTo(2))));
        assertThat(price, anyOf(equalTo(2.35), equalTo(2.0)));
        assertThat(price, allOf(equalTo(2.35), not(equalTo(2.0))));
    }

    static class GreaterThen<T extends Number> extends BaseMatcher<T> {

        T value;

        public GreaterThen(T value) {
            this.value = value;
        }

        @Override public boolean matches(Object actual) {
            if (actual instanceof Comparable) {
                return ((Comparable) actual).compareTo(value) > 0;
            }
            throw new RuntimeException();
        }

        @Override public void describeTo(Description description) {
            description.appendText("测试GreaterThen");
        }
    }

    @Test
    public void testGreaterThan() {
        int i = 10;
        assertThat(i, new GreaterThen<>(5));
    }
}
