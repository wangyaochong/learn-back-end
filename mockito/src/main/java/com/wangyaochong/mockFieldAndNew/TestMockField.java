package com.wangyaochong.mockFieldAndNew;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({MyService.class, MyDbOpertation.class})
public class TestMockField {

    String mockDbOperationResult = "operation with mock";

    @Before
    public void prepare() throws Exception {
        MyDbOpertation mockDbOpertation = PowerMockito.mock(MyDbOpertation.class);
        PowerMockito.whenNew(MyDbOpertation.class).withNoArguments().thenReturn(mockDbOpertation);
        PowerMockito.when(mockDbOpertation.dbOperation()).thenReturn(mockDbOperationResult);
    }

    @Test
    public void test() throws Exception {
        MyService myService = new MyService();
        String result = myService.operateDb();
        Assert.assertEquals(result, mockDbOperationResult);
    }
}
