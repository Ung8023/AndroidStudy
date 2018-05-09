package com.androidaddicts.androidtest.mock;

import org.junit.Test;
import org.mockito.internal.matchers.InstanceOf;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;
import static org.mockito.internal.progress.ThreadSafeMockingProgress.mockingProgress;

/**
 * @author feilang-liuyansong
 * @date 2018/5/4 10:37
 * @description
 */

public class MockSample {

    @Test
    public void behaviorVerify() {
        // 创建Mock对象
        List mockList = mock(List.class);

        // 使用Mock对象
        mockList.add("one");
        mockList.clear();

        //验证函数的调用次数
        verify(mockList).add("one");
        verify(mockList).clear();
    }

    @Test
    public void testStub() {
        //Mock具体的类型
        LinkedList mockList = mock(LinkedList.class);

        //添加测试桩,在调用get(0)时返回"first"
        when(mockList.get(0)).thenReturn("a String");

        //调用get(1)时抛出异常
        when(mockList.get(1)).thenThrow(new RuntimeException("挂了"));

        //输出
        System.out.println(mockList.get(0));
        //抛出异常
        System.out.println(mockList.get(1));
        //输出null，因为没有打桩
        System.out.println(mockList.get(123));
    }

    @Test
    public void testParamMatcher() {
        LinkedList mockList = mock(LinkedList.class);

        //使用内置的anyInt()参数匹配器

        when(mockList.get(anyInt())).thenReturn("A");
        //使用自定义的参数匹配器
        when(mockList.contains(myMatcher())).thenReturn(false);

        assertEquals("A", mockList.get(anyInt()));
        assertFalse(mockList.contains(myMatcher()));

    }

    private String myMatcher() {
        mockingProgress().getArgumentMatcherStorage().reportMatcher((new InstanceOf(String.class, "<aaaaa>")));
        return "";
    }

    @Test
    public void testMethodTimes() {
        LinkedList mockList = mock(LinkedList.class);

        mockList.add("Once");
        mockList.add("Twice");
        mockList.add("Twice");
        mockList.add("Three times");
        mockList.add("Three times");
        mockList.add("Three times");

        verify(mockList).add("Once");
        verify(mockList, times(1)).add("Once");

        verify(mockList, times(2)).add("Twice");
        verify(mockList, times(3)).add("Three times");

        verify(mockList, never()).add("asdfad");

        // 使用atLeast() | atMost()
        verify(mockList, atLeastOnce()).add("Once");
        verify(mockList, atLeast(2)).add("Three times");
        verify(mockList, atMost(2)).add("Twice");

    }

    @Test
    public void testInteractions() {
        List mock = mock(List.class);

        mock.add("one");

        //普通验证
        verify(mock).add("one");
        // 验证某个交互是否从未被执行
        verify(mock, never()).add("two");
        // 验证mock对象没有交互过
        verifyZeroInteractions(mock);

    }

    @Test
    public void testLinkStub() {
        List list = mock(List.class);

        when(list.get(0)).thenReturn(30)
                .thenReturn(10)
                .thenReturn(20);

        //等价于：
        when(list.get(1)).thenReturn(10, 20, 30, 40, 50);

        //第一次调用: 返回30
        System.out.println(list.get(0));
        //第二次调用: 返回10
        System.out.println(list.get(0));
        //第三次调用: 返回20
        System.out.println(list.get(0));
    }

    @Test
    public void testCallBack() {
        MockCallBack mockCallBack = mock(MockCallBack.class);


        MockCallBack.Callback callback = new MockCallBack.Callback() {
            @Override
            public String callBack() {
                return "Zhan";
            }
        };

        when(mockCallBack.doWithCallback(callback)).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                // 获取函数的调用参数
                Object[] args = invocation.getArguments();
                // 获得Mock对象本身
                Object mock = invocation.getMock();
                return "called with argument:" + args;
            }
        });

        System.out.println(mockCallBack.doWithCallback(callback));
    }

    @Test
    public void testSpy() {
        List list = new LinkedList();
        //监控一个真实对象
        List spy = spy(list);

        //为某些函数打桩
        when(spy.size()).thenReturn(100);

        //通过spy对象调用真实对象的函数
        spy.add("one");
        spy.add("tow");

        //输出第一个元素
        System.out.println(spy.get(0));

        System.out.println(spy.size());

        verify(spy).add("one");
        verify(spy).add("two");

        // 这种方式会报指针越界
        // when(spy.get(3)).thenReturn("foo");
        //通过doReturn 打桩
        doReturn("foo").when(spy).get(3);

    }
}
