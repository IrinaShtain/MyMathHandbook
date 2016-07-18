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

public class ComparingFractions extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolBar;
    private EditText int1, num1, den1;
    private TextView int2, num2, den2, res;
    private Button button_find, button_clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppDefault);
        setContentView(R.layout.activity_comparing_fractions);
        initElements();
        initToolBar();
    }

    @Override
    public void onClick(View v) {
        CommonFraction fractionOne, fractionTwo;
        int intOne = 0;
        int intTwo = 0;
        switch (v.getId())
        {
            case R.id.find2:
                if(TextUtils.isEmpty(num1.getText().toString())
                        || TextUtils.isEmpty(den1.getText().toString())
                        || TextUtils.isEmpty(num2.getText().toString())
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
                res.setText(CommonFraction.comparingFractions(fractionOne, fractionTwo));
                break;
            case R.id.clear2:
                clearData();
                break;

        }

    }
    private void clearData() {
        num1.setText("");
        num2.setText("");
        den1.setText("");
        den2.setText("");
        int1.setText("");
        int2.setText("");
        res.setText("");


    }

    private void initElements() {
        button_find = (Button)findViewById(R.id.find2);
        button_clear = (Button)findViewById(R.id.clear2);
        button_find.setOnClickListener(this);
        button_clear.setOnClickListener(this);

        int1 = (EditText)findViewById(R.id.int1);
        int2 = (TextView)findViewById(R.id.int2);
        num1 = (EditText)findViewById(R.id.num1);
        num2 = (TextView)findViewById(R.id.num2);
        den1 = (EditText)findViewById(R.id.den1);
        den2 = (TextView)findViewById(R.id.den2);
        res = (TextView)findViewById(R.id.sign);
    }
    private void initToolBar() {
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle(R.string.list_math_7);
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

