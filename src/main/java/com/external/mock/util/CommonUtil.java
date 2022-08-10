package com.external.mock.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CommonUtil {
    private static final Random RANDOM = new Random();

    public static long barcodeGenerator(int length) {
        char[] digits = new char[length];
        digits[0] = (char) (RANDOM.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (RANDOM.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
    }
}
