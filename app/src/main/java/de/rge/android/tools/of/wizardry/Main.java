package de.rge.android.tools.of.wizardry;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import de.rge.android.tools.of.wizardry.adapter.TabPagerAdapter;
import de.rge.toolsofwizardry.R;

public class Main extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.pager);

        TabPagerAdapter sectionsPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), getApplicationContext());
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }
}
