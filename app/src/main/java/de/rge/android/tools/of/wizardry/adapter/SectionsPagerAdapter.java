package de.rge.android.tools.of.wizardry.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import de.rge.android.tools.of.wizardry.ArgumentIdentifier;
import de.rge.android.tools.of.wizardry.fragments.ArithmancyFragment;
import de.rge.android.tools.of.wizardry.fragments.SacredGeometryFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private final SparseArray<Fragment> POSITION_TO_FRAGMENT_MAP = new SparseArray<>();

    {
        POSITION_TO_FRAGMENT_MAP.put(0, new SacredGeometryFragment());
        POSITION_TO_FRAGMENT_MAP.put(1, new ArithmancyFragment());
    }

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = POSITION_TO_FRAGMENT_MAP.get(position);
        Bundle args = new Bundle();
        args.putInt(ArgumentIdentifier.SECTION_NUMBER.name(), position + 1);
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
        return fragment.getArguments().getString(ArgumentIdentifier.SECTION_TITLE.name());
    }
}
