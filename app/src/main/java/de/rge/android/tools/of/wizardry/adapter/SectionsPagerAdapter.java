package de.rge.android.tools.of.wizardry.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import de.rge.android.tools.of.wizardry.fragments.ArithmancyFragment;
import de.rge.android.tools.of.wizardry.fragments.SacredGeometryFragment;
import de.rge.android.tools.of.wizardry.util.ArgumentUtil;
import de.rge.toolsofwizardry.R;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private final SparseArray<Fragment> POSITION_TO_FRAGMENT_MAP = new SparseArray<>();
    {
        POSITION_TO_FRAGMENT_MAP.put(0, attachArguments(
                new SacredGeometryFragment(), 1, R.string.fragment_title_sacred_geometry));
        POSITION_TO_FRAGMENT_MAP.put(1, attachArguments(
                new ArithmancyFragment(), 2, R.string.fragment_title_arithmancy));
    }

    private ArgumentUtil argumentUtil = new ArgumentUtil();

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return POSITION_TO_FRAGMENT_MAP.get(position);
    }

    @Override
    public int getCount() {
        return POSITION_TO_FRAGMENT_MAP.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Fragment fragment = POSITION_TO_FRAGMENT_MAP.get(position);
        return argumentUtil.getTabTitle(fragment);
    }

    private Fragment attachArguments(Fragment fragment, int tabNumber, int tabTitleId) {
        argumentUtil.setTabNumber(fragment, tabNumber);
        argumentUtil.setTabTitle(fragment, fragment.getString(tabTitleId));
        return fragment;
    }
}
