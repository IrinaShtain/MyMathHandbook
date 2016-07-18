package shtainyky.com.mathhandbook.list_fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import shtainyky.com.mathhandbook.R;
import shtainyky.com.mathhandbook.list_task_math.AddingDecimals;
import shtainyky.com.mathhandbook.list_task_math.Calculator;
import shtainyky.com.mathhandbook.list_task_math.ComparingFractions;
import shtainyky.com.mathhandbook.list_task_math.ConvertingFractions;
import shtainyky.com.mathhandbook.list_task_math.DividingDecimals;
import shtainyky.com.mathhandbook.list_task_math.MultiplyingDecimals;
import shtainyky.com.mathhandbook.list_task_math.ReducingFractions;
import shtainyky.com.mathhandbook.list_task_math.SubtractingDecimals;

public class MathListFragment extends AbstractTabFragment {

    private static String[] listTasks;



    public static MathListFragment getInstance(Context context)
    {
        listTasks = new String[] {
                context.getString(R.string.list_math_0),
                context.getString(R.string.list_math_1),
                context.getString(R.string.list_math_2),
                context.getString(R.string.list_math_3),
                context.getString(R.string.list_math_4),
                context.getString(R.string.list_math_5),
                context.getString(R.string.list_math_6),
                context.getString(R.string.list_math_7)

        };
        MathListFragment mathFragment = new MathListFragment();
        mathFragment.setContext(context);
        mathFragment.setTitle(context.getString(R.string.tab_math));
        return mathFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                R.layout.my_list_item, listTasks);
        setListAdapter(adapter);
        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent;
        if (position == 0) {
            intent = new Intent(context, Calculator.class);
            startActivity(intent);
        }
        else
        if (position == 1) {
            intent = new Intent(context, AddingDecimals.class);
            startActivity(intent);
        }
        else
        if (position == 2) {
            intent = new Intent(context, SubtractingDecimals.class);
            startActivity(intent);

        }
        else
        if (position == 3) {
            intent = new Intent(context, MultiplyingDecimals.class);
            startActivity(intent);
        }
        else
        if (position == 4) {
            intent = new Intent(context, DividingDecimals.class);
            startActivity(intent);
        }
        else
        if (position == 5) {
            intent = new Intent(context, ConvertingFractions.class);
            startActivity(intent);
        }
        else
        if (position == 6) {
            intent = new Intent(context, ReducingFractions.class);
            startActivity(intent);
        }
        else
        if (position == 7) {
            intent = new Intent(context, ComparingFractions.class);
            startActivity(intent);
        }

    }
}
