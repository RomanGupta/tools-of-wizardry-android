package de.rge.android.tools.of.wizardry.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.rge.toolsofwizardry.R;

public class SpellRepositoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_spell_repository, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
    }
}
