package de.rge.android.tools.of.wizardry.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import de.rge.android.tools.of.wizardry.fragments.ArithmancyFragment;
import de.rge.android.tools.of.wizardry.fragments.SacredGeometryFragment;
import de.rge.android.tools.of.wizardry.util.ArgumentUtil;
import de.rge.toolsofwizardry.R;

public class TabPagerAdapter extends FragmentPagerAdapter {

    private ArgumentUtil argumentUtil = new ArgumentUtil();

    private final SparseArray<Fragment> fragments = new SparseArray<>();

    private final Context context;

    public TabPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        initFragments();
    }

    private void initFragments() {
        fragments.put(0, attachArguments(
                new SacredGeometryFragment(),
                1,
                R.string.fragment_title_sacred_geometry));
        fragments.put(1, attachArguments(
                new ArithmancyFragment(),
                2,
                R.string.fragment_title_arithmancy));
    }

    private Fragment attachArguments(Fragment fragment, int tabNumber, int tabTitleId) {
        argumentUtil.setTabNumber(fragment, tabNumber);
        argumentUtil.setTabTitle(fragment, context.getString(tabTitleId));
        return fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Fragment fragment = fragments.get(position);
        return argumentUtil.getTabTitle(fragment);
    }
}
