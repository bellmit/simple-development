package com.spring.simple.development.support.utils;

import java.util.Random;

/**
 * desc:    随机数工具类
 */
public class RandomUtil {

    private final static Random rd = new Random();
    private static final String INT = "0123456789";
    private static final String STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String ALL = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String randomStr(int length) {
        return random(length, RndType.STRING);
    }

    public static int getRandomInt(int value) {
        return rd.nextInt(value);
    }

    public static String randomInt(int length) {
        return random(length, RndType.INT);
    }

    public static String randomAll(int length) {
        return random(length, RndType.ALL);
    }

    private static String random(int length, RndType rndType) {
        StringBuilder s = new StringBuilder();
        char num = 0;
        for (int i = 0; i < length; i++) {
            if (rndType.equals(RndType.INT)) {
                //产生数字0-9的随机数
                num = INT.charAt(rd.nextInt(INT.length()));
            } else if (rndType.equals(RndType.STRING)) {
                //产生字母a-z的随机数
                num = STR.charAt(rd.nextInt(STR.length()));
            } else {
                num = ALL.charAt(rd.nextInt(ALL.length()));
            }
            s.append(num);
        }
        return s.toString();
    }

    public enum RndType {
        INT,
        STRING,
        ALL
    }

}
