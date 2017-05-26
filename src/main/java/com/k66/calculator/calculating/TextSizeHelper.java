package com.k66.calculator.calculating;

import android.util.TypedValue;

/**
 * Created by Kydp9 on 25.05.2017.
 */

public class TextSizeHelper {
    final static int SP_SIZE = 36;

    public static float sizeTextis(int leght) {
        float result = SP_SIZE;

        if (leght > 15 && leght < 50) {
            result = (SP_SIZE * 75 / 100);
        } else if (leght > 48 && leght < 145) {
            result = (SP_SIZE * 50 / 100);
        } else if (leght >= 145) {
            result = (SP_SIZE * 25 / 100);
        } else {
            result = SP_SIZE;
        }

        return result;


    }


}
