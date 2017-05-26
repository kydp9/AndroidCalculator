package com.k66.calculator.calculating;

/**
 * Created by Kydp9 on 24.05.2017.
 */

public class Subtraction {

    static String minus(String first, String second) {
        int maxLeghth = 0;
        char[] charMain;
        char[] charMinus;
        boolean isMinus = false;

        if (first.length() < second.length()) {
            isMinus = true;
            maxLeghth = second.length();
        } else if (first.length() > second.length()) {
            isMinus = false;
            maxLeghth = first.length();

        } else {
            maxLeghth = first.length();
            charMain = first.toCharArray();
            charMinus = second.toCharArray();
            for (int i = 0; i < first.length(); i++) {
                if (charMain[i] > charMinus[i]) {
                    isMinus = false;
                    break;
                }
                if (charMinus[i] > charMain[i]) {
                    isMinus = true;
                    break;
                }
            }
        }

        first = new StringBuilder(first).reverse().toString();
        second = new StringBuilder(second).reverse().toString();

        charMain = first.toCharArray();
        charMinus = second.toCharArray();

        int[] mainList = new int[first.length()];
        int test = 0;
        for (char c : charMain) {
            mainList[test] = (Character.getNumericValue(c));
            test++;
        }
        test = 0;
        int[] minusList = new int[second.length()];
        for (char c : charMinus) {
            minusList[test] = (Character.getNumericValue(c));
            test++;
        }

        int[] result;
        if (isMinus)
            result = difference(minusList, mainList, maxLeghth);  //
        else {
            result = difference(mainList, minusList, maxLeghth);// - если первое число больше второго,
            //- если второе число больше первого.
        }
        StringBuilder resultString = new StringBuilder();
        boolean firstZero = true;

        for (int i = result.length - 1; i >= 0; i--) {
            if (result[result.length - 1] == 0 && firstZero) {
                firstZero = false;
                if (i - 1 < 0) {
                    resultString.append(result[i]);
                } else {
                    if (result[i - 1] == 0) {
                        firstZero = true;
                    }
                }
            } else {
                resultString.append(result[i]);
            }

        }
        //ставим минус
        if (isMinus) {
            if (resultString.length() == 1 && resultString.charAt(0) == 48) {
                // если 0 ....то минус не пишем....
            } else {
                resultString.insert(0, "-");
            }

        }

        return resultString.toString();
    }

    private static int[] difference(int[] big, int[] smoll, int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) // проход по всем разрядам числа, начиная с последнего, не доходя до первого
        {
            if (i < (length - 1)) // если текущий разряд чисел не первый
            {
                big[i + 1]--; // в следующуем разряде большего числа занимаем 1.
                result[i] += 10 + big[i]; // в ответ записываем сумму значения текущего разряда большего числа и 10-ти

            } else { // если текущий разряд чисел - первый
                result[i] += big[i];
            }// в ответ суммируем значение текущего разряда большего числа
            if (i < smoll.length) {
                result[i] -= smoll[i]; // вычитаем значение текущего разряда меньшего числа
            }
            if (result[i] / 10 > 0) // если значение в текущем разряде двухразрядное
            {
                result[i + 1]++; // переносим единицу в старший разряд
                result[i] %= 10; // в текущем разряде отсекаем ее
            }
        }


        return result;
    }


}
