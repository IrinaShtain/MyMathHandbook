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
import shtainyky.com.mathhandbook.list_task_geometry.PythagoreanTheorem;

public class GeometryListFragment extends AbstractTabFragment {

    private static String[] listTasks;



    public static GeometryListFragment getInstance(Context context)
    {
        listTasks = new String[] {context.getString(R.string.list_geometry_0)};

        GeometryListFragment mathFragment = new GeometryListFragment();
        mathFragment.setContext(context);
        mathFragment.setTitle(context.getString(R.string.tab_geomertry));
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
            intent = new Intent(context, PythagoreanTheorem.class);
            startActivity(intent);
        }

    }
}
