package shtainyky.com.mathhandbook.list_fragments;

import android.content.Context;
import android.support.v4.app.ListFragment;
import android.view.View;

import shtainyky.com.mathhandbook.R;

public class AbstractTabFragment extends ListFragment {
    private String  title;
    protected Context context;
    protected View view;
    protected static final int LAYOUT = R.layout.fragment_list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContext(Context context) {
        this.context = context;
    }


}
