package com.k66.calculator.calculating;



public class Addition {

    static String plus(String first, String second) {
        char[] charSmoll;
        char[] charBig;

        first = new StringBuilder(first).reverse().toString();
        second = new StringBuilder(second).reverse().toString();
        if (first.length() > second.length()) {
            charSmoll = second.toCharArray();
            charBig = first.toCharArray();
        } else {
            charBig = second.toCharArray();
            charSmoll = first.toCharArray();
        }

        int smoll = charSmoll.length;
        int big = charBig.length;
        char[] result = new char[big + 1];

        for (int i = 0; i < big; i++) {

            if (i < smoll) {
                int summ = Character.getNumericValue(charSmoll[i]) + Character.getNumericValue(charBig[i]);
                if (summ > 9) {
                    summ = summ - 10;
                    int subSumm = 0;
                    int k = 1;
                    while (true) {

                        if (i + k < big) {
                            subSumm = (Character.getNumericValue(charBig[i + k]) + 1);
                            if (subSumm > 9) {
                                charBig[i + k] = Character.forDigit(subSumm - 10, 16);
                                k++;
                            } else {
                                charBig[i + k] = Character.forDigit((Character.getNumericValue(charBig[i + k]) + 1), 16);
                                break;
                            }
                        } else {
                            result[i + k] = Character.forDigit(1, 16);
                            break;
                        }
                    }
                }
                result[i] = Character.forDigit(summ, 16);

            } else {
                result[i] = charBig[i];
            }
        }
        return new StringBuilder(new String(result)).reverse().toString();

    }


}
