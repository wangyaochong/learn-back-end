import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import sun.management.MethodInfo;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@Slf4j
public class TestMockito {

    @Test
    public void testMock() {
        // mock creation
        List mockedList = mock(List.class);
// using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();
// selective, explicit, highly readable verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
        when(mockedList.get(0)).thenReturn("hello");
        System.out.println(mockedList.get(0));

    }

    @Test
    public void testNoMock() {
        List<String> list = new ArrayList<>();
        list.add("123");
        when(list.get(0)).thenReturn("hello");//这行代码会抛异常
        System.out.println(list.get(0));
    }


    @Test
    public void testMethodInfo() {
        List<Integer> integerList = new ArrayList<>();
        MethodInfo methodInfo = (MethodInfo) ((Object) integerList.add(0));
        System.out.println(JSON.toJSONString(methodInfo));
    }
}
