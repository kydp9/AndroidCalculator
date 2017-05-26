package com.k66.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.k66.calculator.calculating.Calculating;
import com.k66.calculator.calculating.TextSizeHelper;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    boolean firstClick;
    private static char lastPush = '0';

    TextView resultText;
    TextView memoryText;
    ///КНОПКИ
    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnZero;

    float textSize = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        resultText = (TextView) findViewById(R.id.resultText);
        memoryText = (TextView) findViewById(R.id.memoryText);

        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnZero = (Button) findViewById(R.id.btnZero);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnZero.setOnClickListener(this);


        firstClick = true;

    }




    public void clickBtnClear(View view) {
        resultText.setText("0");
        memoryText.setText("");
        firstClick = true;
        resultText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
    }

    public void clickBtnBack(View view) {
        int length = resultText.getText().length();
        if (length > 1) {
            String str = resultText.getText().toString();
            str = str.substring(0, str.length() - 1);
            resultText.setText(str);
        } else {
            if (length == 1) {
                resultText.setText("0");
            }
        }
    }


    public void clickBtnChange(View view) {

        if (resultText.getText().toString().equals("0")) return;
        String str = resultText.getText().toString();
        char first_char = str.charAt(0);
        if (first_char == 45) {
            resultText.setText(str.substring(1));
        } else {
            resultText.setText('-' + str);
        }

    }

    public void clickBtnPlus(View view) {
        lastPush = ADDITION;
        if (firstClick) {
            memoryText.setText(resultText.getText());
            resultText.setText("0");
            firstClick = false;
        } else {
            memoryText.setText(Calculating.plus(memoryText, resultText));
            resultText.setText("0");

        }
    }

    public void clickBtnMinus(View view) {
        lastPush = SUBTRACTION;
        if (firstClick) {
            memoryText.setText(resultText.getText());
            resultText.setText("0");
            firstClick = false;
        } else {
            memoryText.setText(Calculating.minus(memoryText, resultText));
            resultText.setText("0");

        }
    }

    public void clickBtnMultiply (View view) {
        lastPush = MULTIPLICATION;
        if (firstClick) {
            memoryText.setText(resultText.getText());
            resultText.setText("0");
            firstClick = false;
        } else {
            memoryText.setText(Calculating.multiply(memoryText, resultText));
            resultText.setText("0");

        }
    }

    public void clickBtnDiviny (View view) {
        lastPush = DIVISION;
        if (firstClick) {
            memoryText.setText(resultText.getText());
            resultText.setText("0");
            firstClick = false;
        } else {
            memoryText.setText(Calculating.divide(memoryText, resultText));
            resultText.setText("0");

        }
    }

    public void clickBtnResult(View view) {

        if (lastPush == ADDITION) {

            resultText.setText(Calculating.plus(memoryText, resultText));
            memoryText.setText("");
        }

        if (lastPush == SUBTRACTION) {

            resultText.setText(Calculating.minus(memoryText, resultText));
            memoryText.setText("");
        }
        if (lastPush == DIVISION) {

            resultText.setText(Calculating.divide(memoryText, resultText));
            memoryText.setText("");
        }
        if (lastPush == MULTIPLICATION) {

            resultText.setText(Calculating.multiply(memoryText, resultText));
            memoryText.setText("");
        }
        resultText.setTextSize(TypedValue.COMPLEX_UNIT_SP, TextSizeHelper.sizeTextis(resultText.length()));
        firstClick = true;


    }


    @Override
    public void onClick(View view) {

        // изменяем размер шрифта в зависимости от кол-ва символов
        resultText.setTextSize(TypedValue.COMPLEX_UNIT_SP, TextSizeHelper.sizeTextis(resultText.length()));
        // по id определеяем кнопку, вызвавшую этот обработчик
        if (resultText.getText().toString().equals("0")) {
            resultText.setText("");
        }
        switch (view.getId()) {
            case R.id.btnOne:
                resultText.append(btnOne.getText());
                break;
            case R.id.btnTwo:
                resultText.append(btnTwo.getText());
                break;
            case R.id.btnThree:
                resultText.append(btnThree.getText());
                break;
            case R.id.btnFour:
                resultText.append(btnFour.getText());
                break;
            case R.id.btnFive:
                resultText.append(btnFive.getText());
                break;
            case R.id.btnSix:
                resultText.append(btnSix.getText());
                break;
            case R.id.btnSeven:
                resultText.append(btnSeven.getText());
                break;
            case R.id.btnEight:
                resultText.append(btnEight.getText());
                break;
            case R.id.btnNine:
                resultText.append(btnNine.getText());
                break;
            case R.id.btnZero:
                resultText.append(btnZero.getText());
                break;
        }

    }


}
