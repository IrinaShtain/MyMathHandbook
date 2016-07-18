package shtainyky.com.mathhandbook.list_task_math;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import shtainyky.com.mathhandbook.R;

public class Calculator extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolBar;

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    private Button btn_clear, btn_add, btn_minus, btn_mult, btn_div, btn_equal, btn_clear_one, btn_point;

    private TextView textInput, textResult;
    private List<Character> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initElements();
        initToolBar();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button1:
                checkFirstSign();
                list.add('1');
                textInput.setText(returnListAsStringArray(list));
                break;

            case R.id.button2:
                checkFirstSign();
                list.add('2');
                textInput.setText(returnListAsStringArray(list));
                break;

            case R.id.button3:
                checkFirstSign();
                list.add('3');
                textInput.setText(returnListAsStringArray(list));
                break;

            case R.id.button4:
                checkFirstSign();
                list.add('4');
                textInput.setText(returnListAsStringArray(list));
                break;

            case R.id.button5:
                checkFirstSign();
                list.add('5');
                textInput.setText(returnListAsStringArray(list));
                break;

            case R.id.button6:
                checkFirstSign();
                list.add('6');
                textInput.setText(returnListAsStringArray(list));
                break;

            case R.id.button7:
                checkFirstSign();
                list.add('7');
                textInput.setText(returnListAsStringArray(list));
                break;

            case R.id.button8:
                checkFirstSign();
                list.add('8');
                textInput.setText(returnListAsStringArray(list));
                break;

            case R.id.button9:
                checkFirstSign();
                list.add('9');
                textInput.setText(returnListAsStringArray(list));
                break;

            case R.id.button0:
                checkFirstSign();
                list.add('0');
                textInput.setText(returnListAsStringArray(list));
                break;

            case R.id.button_plus:
                checkResultInput();
                checkPreviousSign();
                list.add('+');
                textInput.setText(returnListAsStringArray(list));
                break;

            case R.id.button_minus:
                checkResultInput();
                checkPreviousSign();
                list.add('-');
                textInput.setText(returnListAsStringArray(list));
                break;

            case R.id.button_mult:
                checkResultInput();
                checkPreviousSign();
                list.add('*');
                textInput.setText(returnListAsStringArray(list));
                break;
            case R.id.button_div:
                checkResultInput();
                checkPreviousSign();
                list.add('/');
                textInput.setText(returnListAsStringArray(list));
                break;

            case R.id.button_point:
                if (list.size() == 0)
                    list.add('0');
                else
                if((list.size() == 1)) {
                    if (list.get(0) == '-') {
                        list.add('0');
                    } else {
                        list.remove(0);
                        list.add('0');
                    }
                }
                else
                if (list.size() > 1)
                    if ((!Character.isDigit(list.get(list.size() - 1))))
                        list.add('0');

                list.add('.');
                textInput.setText(returnListAsStringArray(list));
                break;

            case R.id.button_clear_one:
                if (list.size() > 1)
                {
                    list.remove(list.size() - 1);
                    textInput.setText(returnListAsStringArray(list));
                    textResult.setText("");
                }
                else
                {
                    textInput.setText("");
                    list.clear();
                }
                break;

            case R.id.button_clear:
                list.clear();
                clearData();
                break;

            case R.id.button_equal:
                if ((list.size() > 1)) {
                    if (!Character.isDigit(list.get(list.size() - 1)))
                        list.remove(list.size() - 1);
                    if (list.get(0) != '-') {
                        beginList(1);
                    }
                    else
                    {
                        list.remove(0);
                        beginList(-1);
                    }
                }
                break;
        }

    }
    public void checkResultInput()
    {
        if (!TextUtils.isEmpty(textResult.getText().toString()))
        {
            list.clear();
            char[] resultChar = textResult.getText().toString().toCharArray();
            for (int i = 1; i < resultChar.length ; i++) {
                list.add(resultChar[i]);
            }
        }
        textResult.setText("");
    }
    private void beginList(int signedNumber)
    {
        List<String> listSignes = Arrays.asList(returnListAsStringArray(list).split("[^+\\-\\*\\/]+"));
        List<String> listNumbers = Arrays.asList(returnListAsStringArray(list).split("[+\\-\\*\\/]"));
        List<Double> listDoubleNumbers = new ArrayList<>();

        for (int i = 0; i < listNumbers.size(); i++) {
            listDoubleNumbers.add(Double.parseDouble(listNumbers.get(i)));
        }
        double result = signedNumber * listDoubleNumbers.get(0);
        double temp_result = 0;
        for (int i = 1; i < listDoubleNumbers.size(); i++) {
            temp_result = result;
            result = operation(listSignes.get(i), temp_result, listDoubleNumbers.get(i));
        }
        String textint = "=" + (int) result;
        String text = "=" + result;
        if (text.equals("=NaN") || text.equals("=Infinity")||text.equals("=-Infinity") ) {
            showAlertDialog("На нуль ділити не можна");
            clearData();
            list.clear();
        }
        else
        {
            if (result % 1 == 0)
                textResult.setText(textint);
            else
                textResult.setText(text);
        }
    }
    private void checkFirstSign()
    {
        if((list.size()  == 1)&&(list.get(0) != '-'))
            checkPreviousSign();
    }
    private void checkPreviousSign()
    {
        if (list.size() >= 1) {
            if ((!Character.isDigit(list.get(list.size() - 1))))
                list.remove(list.size() - 1);
        }
    }
    private Double operation(String sign, Double a, Double b) throws ArithmeticException
    {
        switch (sign)
        {
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
            default:
                return null;
        }
    }
    private String returnListAsStringArray(List<Character> list) {
        String s = "";
        for (int i = 0; i<list.size(); i++)
        {
          s = s + list.get(i);
        }
        return s;
    }
    private void showAlertDialog(String messageText)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.list_math_0)
                .setMessage(messageText)
                .setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        clearData();
                    }


                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void clearData() {
        textInput.setText("");
        textResult.setText("");
    }

    private void initElements() {
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        btn5 = (Button)findViewById(R.id.button5);
        btn6 = (Button)findViewById(R.id.button6);
        btn7 = (Button)findViewById(R.id.button7);
        btn8 = (Button)findViewById(R.id.button8);
        btn9 = (Button)findViewById(R.id.button9);
        btn0 = (Button)findViewById(R.id.button0);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);

        btn_add = (Button)findViewById(R.id.button_plus);
        btn_minus = (Button)findViewById(R.id.button_minus);
        btn_mult= (Button)findViewById(R.id.button_mult);
        btn_div= (Button)findViewById(R.id.button_div);

        btn_add.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_mult.setOnClickListener(this);
        btn_div.setOnClickListener(this);

        btn_point = (Button)findViewById(R.id.button_point);
        btn_clear= (Button)findViewById(R.id.button_clear);
        btn_clear_one= (Button)findViewById(R.id.button_clear_one);
        btn_equal = (Button)findViewById(R.id.button_equal);

        btn_clear.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_clear_one.setOnClickListener(this);
        btn_equal.setOnClickListener(this);

        textInput = (TextView)findViewById(R.id.input);
        textResult = (TextView)findViewById(R.id.result);

    }

    private void initToolBar() {
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle(R.string.list_math_0);
        toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                finish();
                return false;
            }
        });
        toolBar.inflateMenu(R.menu.menu);
    }



}
