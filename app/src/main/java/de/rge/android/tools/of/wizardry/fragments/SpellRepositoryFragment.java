package de.rge.android.tools.of.wizardry.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import de.rge.toolsofwizardry.R;

public class SpellRepositoryFragment extends Fragment {

    private static final String[] DUMMY_SPELLS = {"Burning Hands", "Scorching Ray", "Fireball"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_spell_repository, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        initListView(view);
    }

    private void initListView(View view) {
        ListView spellRepository = view.findViewById(R.id.lvwSpellRepository);
        spellRepository.setAdapter(createListViewAdapter());
    }

    @NonNull
    private ArrayAdapter<String> createListViewAdapter() {
        return new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_selectable_list_item,
                DUMMY_SPELLS);
    }
}
