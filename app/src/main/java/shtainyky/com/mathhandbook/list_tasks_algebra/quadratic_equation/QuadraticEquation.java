package shtainyky.com.mathhandbook.list_tasks_algebra.quadratic_equation;

import android.app.AlertDialog;
import android.content.DialogInterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import shtainyky.com.mathhandbook.R;

public class QuadraticEquation extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolBar;
    private EditText etA, etB, etC;
    private TextView dysRes, x1Res, x2Res;
    private Button btfind, btclear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic_equation);
        initElements();
        initToolBar();
    }

     @Override
    public void onClick(View v) {
        float anum = 0;
        float bnum = 0;
        float cnum = 0;

        float x1 = 0;
        float x2 = 0;

        if(v.getId() == R.id.clear)
        {
            clearData();
        }

        if (TextUtils.isEmpty(etA.getText().toString())|| TextUtils.isEmpty(etB.getText().toString())
                || TextUtils.isEmpty(etC.getText().toString()))
            return;
        if (v.getId() == R.id.find)
        {
                try {
                        anum = Float.parseFloat(etA.getText().toString());
                   if (anum == 0)
                   {
                        showAlertDialog("Число А не може дорівнювати 0.");
                        return;
                    }
                    bnum = Float.parseFloat(etB.getText().toString());
                    cnum = Float.parseFloat(etC.getText().toString());

                    float dys = bnum * bnum - 4 * anum * cnum;
                    dysRes.setText(String.valueOf(dys));
                    if (dys == 0) {
                        x1 = (-bnum + (float) Math.sqrt(dys)) / (2 * anum);
                        x2 = (-bnum + (float) Math.sqrt(dys)) / (2 * anum);
                        x1Res.setText(String.valueOf(x1));
                        x2Res.setText(String.valueOf(x2));
                        Toast.makeText(this, "Корені однакові.", Toast.LENGTH_SHORT).show();
                    }
                    if (dys > 0) {
                        x1 = (-bnum + (float) Math.sqrt(dys)) / (2 * anum);
                        x2 = (-bnum - (float) Math.sqrt(dys)) / (2 * anum);
                        x1Res.setText(String.valueOf(x1));
                        x2Res.setText(String.valueOf(x2));
                        Toast.makeText(this, "Два різні корені.", Toast.LENGTH_SHORT).show();
                    }
                    if (dys < 0) {
                        x1Res.setText("");
                        x2Res.setText("");
                        Toast.makeText(this, "Коренів не має.", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e)
                {
                    showAlertDialog("Числа введені некоректно.");
                }
        }
    }

    private void clearData()
    {
        etA.setText("");
        etB.setText("");
        etC.setText("");
        dysRes.setText("");
        x1Res.setText("");
        x2Res.setText("");
    }
    private void showAlertDialog(String messageText)
    {
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
    private void initElements() {
        etA = (EditText)findViewById(R.id.A);
        etB = (EditText)findViewById(R.id.B);
        etC = (EditText)findViewById(R.id.C);

        dysRes = (TextView)findViewById(R.id.dysres);
        x1Res = (TextView)findViewById(R.id.x1res);
        x2Res = (TextView)findViewById(R.id.x2res);

        btfind = (Button)findViewById(R.id.find);
        btclear = (Button)findViewById(R.id.clear);

        btfind.setOnClickListener(this);
        btclear.setOnClickListener(this);
    }

    private void initToolBar() {
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle(R.string.title_activity_quadratic_equation);
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
