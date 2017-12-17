package de.rge.toolsofwizardry.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;

import de.rge.toolsofwizardry.R;
import de.rge.toolsofwizardry.android.fragments.ArithmancyFragment;
import de.rge.toolsofwizardry.android.fragments.SacredGeometryFragment;

import static de.rge.toolsofwizardry.android.ArgumentIdentifier.SECTION_NUMBER;
import static de.rge.toolsofwizardry.android.ArgumentIdentifier.SECTION_TITLE;

public class Main extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(sectionsPagerAdapter);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private final SparseArray<Fragment> POSITION_TO_FRAGMENT_MAP = new SparseArray<>();
        {
            POSITION_TO_FRAGMENT_MAP.put(0, new SacredGeometryFragment());
            POSITION_TO_FRAGMENT_MAP.put(1, new ArithmancyFragment());
        }
        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = POSITION_TO_FRAGMENT_MAP.get(position);
            Bundle args = new Bundle();
            args.putInt(SECTION_NUMBER.name(), position + 1);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return POSITION_TO_FRAGMENT_MAP.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Fragment fragment = POSITION_TO_FRAGMENT_MAP.get(position);
            return fragment.getArguments().getString(SECTION_TITLE.name());
        }
    }

}
