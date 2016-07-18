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
import shtainyky.com.mathhandbook.list_tasks_algebra.quadratic_equation.QuadraticEquation;

public class AlgebraListFragment extends AbstractTabFragment {

   private static String[] listTasks;


    public static AlgebraListFragment getInstance(Context context)
    {
        listTasks = new String[] {context.getString(R.string.list_algebra_0)};

        AlgebraListFragment algebraFragment = new AlgebraListFragment();
        algebraFragment.setContext(context);
        algebraFragment.setTitle(context.getString(R.string.tab_algebra));

        return algebraFragment;
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
            intent = new Intent(context, QuadraticEquation.class);
            startActivity(intent);
        }

    }

}
