package shtainyky.com.mathhandbook.list_task_math;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import shtainyky.com.mathhandbook.R;

public class AddingDecimals extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolBar;

    private EditText int1, int2, num1, num2, den1, den2;
    private Button button_find, button_clear;
    private TextView int_res, num_res, den_res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_decimals);
        initElements();
        initToolBar();
    }
    @Override
    public void onClick(View v) {

        CommonFraction fractionOne, fractionTwo, fractionsRes;
        int intOne = 0;
        int intTwo = 0;

        switch (v.getId())
        {
            case R.id.find2:
                if(TextUtils.isEmpty(num1.getText().toString())
                        || TextUtils.isEmpty(num2.getText().toString())
                        || TextUtils.isEmpty(den1.getText().toString())
                        || TextUtils.isEmpty(den2.getText().toString()))
                    return;

                if(!TextUtils.isEmpty(int1.getText().toString()))
                    intOne = Integer.parseInt(int1.getText().toString());

                if(!TextUtils.isEmpty(int2.getText().toString()))
                    intTwo = Integer.parseInt(int2.getText().toString());

                fractionOne = new CommonFraction(intOne,
                        Integer.parseInt(num1.getText().toString()),
                        Integer.parseInt(den1.getText().toString()));

                fractionTwo = new CommonFraction(intTwo,
                        Integer.parseInt(num2.getText().toString()),
                        Integer.parseInt(den2.getText().toString()));

                fractionsRes = CommonFraction.addingFractions(fractionOne, fractionTwo);

                if (fractionsRes.getIntegerPart() == 0)
                    int_res.setText("");
                else
                    int_res.setText(String.valueOf(fractionsRes.getIntegerPart()));
                if (fractionsRes.getNumerator() == 0) {
                    num_res.setText("");
                    den_res.setText("");
                }
                else {
                    num_res.setText(String.valueOf(fractionsRes.getNumerator()));
                    den_res.setText(String.valueOf(fractionsRes.getDenominator()));
                }
                break;

            case R.id.clear2:
                clearData();
                break;

        }

    }

    private void clearData() {
        int_res.setText("");
        num_res.setText("");
        den_res.setText("");
        num1.setText("");
        num2.setText("");
        den1.setText("");
        den2.setText("");
        int1.setText("");
        int2.setText("");

    }

    private void initElements() {
        button_find = (Button)findViewById(R.id.find2);
        button_clear = (Button)findViewById(R.id.clear2);
        button_find.setOnClickListener(this);
        button_clear.setOnClickListener(this);

        int1 = (EditText)findViewById(R.id.int1);
        int2 = (EditText)findViewById(R.id.int2);
        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);
        den1 = (EditText)findViewById(R.id.den1);
        den2 = (EditText)findViewById(R.id.den2);

        int_res = (TextView)findViewById(R.id.int_res);
        num_res = (TextView)findViewById(R.id.num_res);
        den_res = (TextView)findViewById(R.id.den_res);

    }
    private void initToolBar() {
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle(R.string.list_math_1);
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
