package com.androidaddicts.androidtest.sample;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author feilang-liuyansong
 * @date 2018/5/4 10:30
 * @description
 */

public class SubwayCalculatorTest {

    @Test
    public void testSubwayPrice() {
        //边界条件
        assertEquals(0, SubwayCalculator.subwayPrice(-1));
        assertEquals(0, SubwayCalculator.subwayPrice(0));

        // 6 公里以内
        assertEquals(3, SubwayCalculator.subwayPrice(1));
        assertEquals(3, SubwayCalculator.subwayPrice(2));
        assertEquals(3, SubwayCalculator.subwayPrice(6));

        // 12 公里以内
        assertEquals(4, SubwayCalculator.subwayPrice(7));
        assertEquals(4, SubwayCalculator.subwayPrice(9));
        assertEquals(4, SubwayCalculator.subwayPrice(12));

        // 22 公里以内
        assertEquals(5, SubwayCalculator.subwayPrice(13));
        assertEquals(5, SubwayCalculator.subwayPrice(18));
        assertEquals(5, SubwayCalculator.subwayPrice(22));

        // 32公里以内
        assertEquals(6, SubwayCalculator.subwayPrice(23));
        assertEquals(6, SubwayCalculator.subwayPrice(29));
        assertEquals(6, SubwayCalculator.subwayPrice(32));

        // 32公里以上
        assertEquals(7, SubwayCalculator.subwayPrice(33));
        assertEquals(7, SubwayCalculator.subwayPrice(100));
    }

}
