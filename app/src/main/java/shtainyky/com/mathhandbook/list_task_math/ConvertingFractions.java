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

public class ConvertingFractions extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolBar;
    private EditText int1, int3, num1, num3, den1, den3;
    private TextView int2, num2, den2, int4, num4, den4;
    private Button button_find, button_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppDefault);
        setContentView(R.layout.activity_converting_fractions);
        initElements();
        initToolBar();
    }
    @Override
    public void onClick(View v) {
        CommonFraction fractionOne, fractionTwo, fractionsWrongRes,fractionsWrightRes;
        int intOne = 0;
        int intTwo = 0;
        switch (v.getId())
        {
            case R.id.find2:
                if(!TextUtils.isEmpty(int1.getText().toString()))
                    intOne = Integer.parseInt(int1.getText().toString());

                if(!TextUtils.isEmpty(int3.getText().toString()))
                    intTwo = Integer.parseInt(int3.getText().toString());

                if(!TextUtils.isEmpty(num1.getText().toString())
                        && !TextUtils.isEmpty(den1.getText().toString()))
                {
                    fractionOne = new CommonFraction(intOne,
                            Integer.parseInt(num1.getText().toString()),
                            Integer.parseInt(den1.getText().toString()));
                    fractionsWrongRes = CommonFraction.wrongFraction(fractionOne);
                    num2.setText(String.valueOf(fractionsWrongRes.getNumerator()));
                    den2.setText(String.valueOf(fractionsWrongRes.getDenominator()));

                }
                if(!TextUtils.isEmpty(num3.getText().toString())&& !TextUtils.isEmpty(den3.getText().toString()))
                {
                    fractionTwo = new CommonFraction(intTwo,
                            Integer.parseInt(num3.getText().toString()),
                            Integer.parseInt(den3.getText().toString()));
                    fractionsWrightRes = CommonFraction.wrightFraction(fractionTwo);
                    if (fractionsWrightRes.getIntegerPart()!=0 )
                        int4.setText(String.valueOf(fractionsWrightRes.getIntegerPart()));
                    if (fractionsWrightRes.getNumerator()!=0 ) {
                        num4.setText(String.valueOf(fractionsWrightRes.getNumerator()));
                        den4.setText(String.valueOf(fractionsWrightRes.getDenominator()));
                    }
                }

                break;
            case R.id.clear2:
                clearData();
                break;

        }

    }
    private void clearData() {
        num1.setText("");
        num2.setText("");
        num3.setText("");
        num4.setText("");
        den1.setText("");
        den2.setText("");
        den3.setText("");
        den4.setText("");
        int1.setText("");
        int2.setText("");
        int3.setText("");
        int4.setText("");

    }

    private void initElements() {
        button_find = (Button)findViewById(R.id.find2);
        button_clear = (Button)findViewById(R.id.clear2);
        button_find.setOnClickListener(this);
        button_clear.setOnClickListener(this);

        int1 = (EditText)findViewById(R.id.int1);
        int2 = (TextView)findViewById(R.id.int2);
        int3 = (EditText)findViewById(R.id.int3);
        int4 = (TextView)findViewById(R.id.int4);

        num1 = (EditText)findViewById(R.id.num1);
        num3 = (EditText)findViewById(R.id.num3);
        num2 = (TextView)findViewById(R.id.num2);
        num4 = (TextView)findViewById(R.id.num4);

        den1 = (EditText)findViewById(R.id.den1);
        den3 = (EditText)findViewById(R.id.den3);
        den2 = (TextView)findViewById(R.id.den2);
        den4 = (TextView)findViewById(R.id.den4);
    }
    private void initToolBar() {
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle(R.string.list_math_5);
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
