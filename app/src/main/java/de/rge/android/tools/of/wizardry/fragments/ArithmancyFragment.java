package de.rge.android.tools.of.wizardry.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import de.rge.toolsofwizardry.R;
import de.rge.android.tools.of.wizardry.runnable.ArithmancySolvingThread;

import static de.rge.android.tools.of.wizardry.ArgumentIdentifier.SECTION_TITLE;

public class ArithmancyFragment extends Fragment {
    private Handler threadHandler = new Handler();

    private Runnable solverThread;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_arithmancy, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        initTitle();
        initRunnables(view);
        initButtons(view);
    }

    private void initTitle() {
        String title = this.getString(R.string.fragment_title_arithmancy);
        Bundle args = this.getArguments();
        args.putString(SECTION_TITLE.name(), title);
    }

    private void initRunnables(View view) {
        solverThread = new ArithmancySolvingThread(view);
    }

    private void initButtons(View view) {
        setupBtnSolveArithmancy(view);
    }

    private void setupBtnSolveArithmancy(View view) {
        Button btnSolve = view.findViewById(R.id.btnSolveArithmancy);

        btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threadHandler.removeCallbacks(solverThread);
                threadHandler.post(solverThread);
            }
        });
    }
}
