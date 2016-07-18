package shtainyky.com.mathhandbook.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.Map;

import shtainyky.com.mathhandbook.list_fragments.AbstractTabFragment;
import shtainyky.com.mathhandbook.list_fragments.AlgebraListFragment;
import shtainyky.com.mathhandbook.list_fragments.GeometryListFragment;
import shtainyky.com.mathhandbook.list_fragments.MathListFragment;

public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;

    public TabsPagerFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        tabs = new HashMap<>();
        tabs.put(0, MathListFragment.getInstance(context));
        tabs.put(1, AlgebraListFragment.getInstance(context));
        tabs.put(2, GeometryListFragment.getInstance(context));

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }
}
