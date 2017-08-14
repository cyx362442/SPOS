package com.duowei.spos.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Administrator on 2017-08-12.
 */

public class BdUtil {
    public static float BD(float f,int d){
        BigDecimal bigDecimal = new BigDecimal(f).setScale(d, RoundingMode.HALF_UP);
        return bigDecimal.floatValue();
    }
}
