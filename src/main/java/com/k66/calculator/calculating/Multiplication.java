package com.k66.calculator.calculating;

import java.util.ArrayList;


public class Multiplication {

    static String multiply(String num1, String num2) {
        int product, carry = 0, sum = 0;
        String result = new String("");
        String partial = new String("");
        ArrayList<String> partialList = new ArrayList<String>();
if(num1.equals("0") || num2.equals("0"))
{
    return new String("0");
}

        for (int j = num2.length() - 1; j >= 0; j--) {
            for (int i = num1.length() - 1; i >= 0; i--) {

                product = Integer.parseInt((new Character(num1.charAt(i))).toString()) *
                        Integer.parseInt((new Character(num2.charAt(j))).toString()) + carry;
                carry = product / 10;
                partial = Integer.toString(product % 10) + partial;
            }

            if (carry != 0)
                partial = Integer.toString(carry) + partial;

            partialList.add(partial);
            partial = "";
            carry = 0;
        }


        for (int i = 0; i < partialList.size(); i++)
            partialList.set(i, partialList.get(i) + (Long.toString((long) java.lang.Math.pow(10.0, (double) i))).substring(1));

        /* ищем наибольший размер */
        int largestPartial = partialList.get(partialList.size() - 1).length();

        /* обрабатываем нюли */
        int zeroes;
        for (int i = 0; i < partialList.size(); i++) {
            zeroes = largestPartial - partialList.get(i).length();

            if (zeroes >= 1)
                partialList.set(i, (Long.toString((long) java.lang.Math.pow(10.0, (double) zeroes))).substring(1) + partialList.get(i));
        }


        carry = 0;
        for (int i = largestPartial - 1; i >= 0; i--) {

            sum = 0;
            for (int j = 0; j < partialList.size(); j++)
                sum = sum + Integer.parseInt(new Character(partialList.get(j).charAt(i)).toString());

            sum = sum + carry;
            carry = sum / 10;
            result = Integer.toString(sum % 10) + result;
        }

        if (carry != 0)
            result = Integer.toString(carry) + result;

        return result;
    }

}
