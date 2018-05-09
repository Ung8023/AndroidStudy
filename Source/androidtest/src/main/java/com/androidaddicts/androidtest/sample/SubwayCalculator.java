package com.androidaddicts.androidtest.sample;

/**
 * @author feilang-liuyansong
 * @date 2018/5/4 10:27
 * @description
 */

public final class SubwayCalculator {
    public static int subwayPrice(int miles) {
        if (miles <=0) {
            return 0;
        } else if (miles <= 6) {
            return 3;
        }else if (miles > 6 && miles <= 12) {
            return 4;
        }else if (miles > 12 && miles <= 22) {
            return 5;
        }else if (miles > 22 && miles <= 32) {
            return 6;
        }
        return 7;
    }
}
