package shtainyky.com.mathhandbook;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import shtainyky.com.mathhandbook.adapter.TabsPagerFragmentAdapter;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolBar;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();
        initTabs();
    }

    private void initTabs() {
        viewPager = (ViewPager)findViewById(R.id.viewPger);
        TabsPagerFragmentAdapter adapter = new TabsPagerFragmentAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initToolBar() {
        toolBar = (Toolbar)findViewById(R.id.toolbar);
        toolBar.setTitle(R.string.toolbaar_title);
        toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                finish();
                return false;
            }
        });
        toolBar.inflateMenu(R.menu.menu);
;
    }
}
