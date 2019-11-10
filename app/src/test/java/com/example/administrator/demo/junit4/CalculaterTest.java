package com.example.administrator.demo.junit4;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author TangLongHui
 * @data created on 2019/7/2.
 * @describe
 */
public class CalculaterTest {
    /** 计算功能类 */
    private Calculater mCalculator;

    @Before
    public void setUp() {
        mCalculator = new Calculater();
    }

    /**
     * 方法的命名尽量描述详细
     * 测试两个数相加
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1, 1);
        //使用hamcrest进行assert，直观，易读
        assertThat(resultAdd,is(equalTo(2d)));
    }

}