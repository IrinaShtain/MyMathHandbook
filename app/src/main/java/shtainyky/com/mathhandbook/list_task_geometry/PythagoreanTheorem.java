package shtainyky.com.mathhandbook.list_task_geometry;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import shtainyky.com.mathhandbook.R;


public class PythagoreanTheorem extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolBar;
    private EditText a, b, c;
    Button button_find, button_clear;
    TextView textResult, numberResult;

    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pythagorean_theorem);
        initElements();
        initToolBar();
    }

    private void initElements() {
        a = (EditText)findViewById(R.id.A);
        b = (EditText)findViewById(R.id.B);
        c = (EditText)findViewById(R.id.C);

        numberResult = (TextView) findViewById(R.id.result_text);
        textResult = (TextView) findViewById(R.id.result_number);

        button_find = (Button)findViewById(R.id.find1);
        button_clear = (Button)findViewById(R.id.clear1);
        button_find.setOnClickListener(this);
        button_clear.setOnClickListener(this);
    }

    private void initToolBar() {
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle(R.string.list_geometry_0);
        toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                finish();
                return false;
            }
        });
        toolBar.inflateMenu(R.menu.menu);
    }

    @Override
    public void onClick(View v) {

        double hypotenuse = 0;
        double a_katet = 0;
        double b_katet = 0;

        switch (v.getId()) {
            case R.id.find1:
                if (TextUtils.isEmpty(a.getText().toString()) && !TextUtils.isEmpty(b.getText().toString())
                        && !TextUtils.isEmpty(c.getText().toString())) {
                    b_katet = Double.parseDouble(b.getText().toString());
                    hypotenuse = Double.parseDouble(c.getText().toString());
                    if(hypotenuse <= b_katet)
                    {
                        clearData();
                        showAlertDialog("Такого прямокутного трикутника не існує, або Ви ввели хибні дані");
                        return;
                    }
                    a_katet = Math.sqrt(hypotenuse * hypotenuse - b_katet * b_katet);
                    if (a_katet % 1 == 0)
                        outputData("Невідомий катет рівний:", (int)a_katet);
                    else
                        outputData("Невідомий катет рівний:", a_katet);
                }
                if (!TextUtils.isEmpty(a.getText().toString()) && TextUtils.isEmpty(b.getText().toString())
                        && !TextUtils.isEmpty(c.getText().toString())) {
                    a_katet = Double.parseDouble(a.getText().toString());
                    hypotenuse = Double.parseDouble(c.getText().toString());
                    if(hypotenuse <= a_katet)
                    {
                        clearData();
                        showAlertDialog("Такого прямокутного трикутника не існує, або Ви ввели хибні дані");
                        return;
                    }
                    b_katet = Math.sqrt(hypotenuse * hypotenuse - a_katet * a_katet);
                    if (b_katet % 1 == 0)
                        outputData("Невідомий катет рівний:", (int)b_katet);
                    else
                        outputData("Невідомий катет рівний:", b_katet);
                }
                if (!TextUtils.isEmpty(a.getText().toString()) && !TextUtils.isEmpty(b.getText().toString())
                        && TextUtils.isEmpty(c.getText().toString())) {
                    a_katet = Double.parseDouble(a.getText().toString());
                    b_katet = Double.parseDouble(b.getText().toString());
                    hypotenuse = Math.sqrt(b_katet * b_katet + a_katet * a_katet);
                    if (hypotenuse % 1 == 0)
                        outputData("Гіпотенуза рівна:", (int)hypotenuse);
                    else
                        outputData("Гіпотенуза рівна:", hypotenuse);
                }
                break;

            case R.id.clear1:
                clearData();
                break;
        }

    }

    private void outputData(String text, double result)
    {
        textResult.setText(text);
        numberResult.setText(String.valueOf(result));
        numberResult.setTextColor(Color.BLUE);
    }
    
    private void outputData(String text, int result)
    {
        textResult.setText(text);
        numberResult.setText(String.valueOf(result));
        numberResult.setTextColor(Color.BLUE);
    }

    private void showAlertDialog(String messageText) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.title_activity_quadratic_equation)
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
        a.setText("");
        b.setText("");
        c.setText("");
        numberResult.setText("");
        textResult.setText("");
    }

}
