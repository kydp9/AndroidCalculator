package com.k66.calculator.calculating;


import android.widget.TextView;


public class Calculating {

    private static boolean isMinus(String textView) {
        if (textView.equals("0")) return false;

        char first_char = textView.charAt(0);
        if (first_char == 45) {
            return true;
        } else {
            return false;
        }

    }

    public static String plus(TextView textMemory, TextView textResult) {
        String second = textResult.getText().toString();
        String first = textMemory.getText().toString();
        boolean returnMinus = false;
        String result = "0";
        if (first.isEmpty()) {
            first = new String("0");
        }
        if (second.isEmpty()) {
            second = new String("0");
        }

        if (isMinus(second) && isMinus(first)) {
            second = second.substring(1);
            first = first.substring(1);

            return new String('-' + Addition.plus(second, first));
        } else if (isMinus(second)) {
            second = second.substring(1);
            return Subtraction.minus(first, second);
        } else if (isMinus(first)) {
            first = first.substring(1);
            return Subtraction.minus(second, first);
        } else {
            return Addition.plus(second, first);
        }
    }

    public static String minus(TextView textMemory, TextView textMain) {
        String second = textMain.getText().toString();
        String first = textMemory.getText().toString();
        boolean returnMinus = false;
        String result = "0";
        if (first.isEmpty()) {
            first = new String("0");
        }
        if (second.isEmpty()) {
            second = new String("0");
        }

        if (isMinus(second) && isMinus(first)) {

            first = first.substring(1);
            second = second.substring(1);

            return Subtraction.minus(second, first);
        } else if (isMinus(first)) {
            first = first.substring(1);

            return new String("-" + Addition.plus(first, second));
        } else if (isMinus(second)) {
            second = second.substring(1);
            return Addition.plus(first, second);
        } else {
            return Subtraction.minus(first, second);
        }

    }

    public static String multiply(TextView textMemory, TextView textMain) {
        String second = textMain.getText().toString();
        String first = textMemory.getText().toString();
        boolean returnMinus = false;
        String result = "0";
        if (first.isEmpty()) {
            return new String("0");
        }
        if (second.isEmpty()) {
            return new String("0");
        }

        if (isMinus(second) && isMinus(first)) {

            first = first.substring(1);
            second = second.substring(1);

            return Multiplication.multiply(second, first);
        } else if (isMinus(first)) {
            first = first.substring(1);

            return new String("-" + Multiplication.multiply(second, first));
        } else if (isMinus(second)) {
            second = second.substring(1);
            return new String("-" + Multiplication.multiply(second, first));
        } else {
            return Multiplication.multiply(first, second);
        }

    }

    public static String divide(TextView textMemory, TextView textMain) {
        String second = textMain.getText().toString();
        String first = textMemory.getText().toString();
        boolean returnMinus = false;
        String result = "0";
        if (first.isEmpty()) {
            return new String("0");
        }
        if (second.isEmpty()) {
            return new String("0");
        }

        if (isMinus(second) && isMinus(first)) {

            first = first.substring(1);
            second = second.substring(1);

            return Division.divideString(first, second);
        } else if (isMinus(first)) {
            first = first.substring(1);

            return new String("-" + Division.divideString(first, second));
        } else if (isMinus(second)) {
            second = second.substring(1);
            return new String("-" + Division.divideString(first, second));
        } else {
            return Division.divideString(first, second);
        }

    }

}