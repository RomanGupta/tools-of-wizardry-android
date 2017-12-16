package de.rge.toolsofwizardry.android;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import de.rge.toolsofwizardry.R;
import de.rge.toolsofwizardry.android.listener.SGSpinnerItemSelectedListenerData;
import de.rge.toolsofwizardry.android.runnable.DiceRollingThread;
import de.rge.toolsofwizardry.android.runnable.SacredGeometrySolvingThread;

public class SacredGeometryFragment extends Fragment {
	private Handler threadHandler = new Handler();

	private Runnable diceRollerThread;

	private Runnable solverThread;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_sacred_geometry, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		initRunnables(view);
		initButtons(view);
		initSpinners(view);
	}

	private void initRunnables(View view) {
		diceRollerThread = new DiceRollingThread(view);
		solverThread = new SacredGeometrySolvingThread(view);
	}

	private void initButtons(View view) {
		setupBtnRollDice(view);
		setupBtnSolveSG(view);
	}

	private void setupBtnRollDice(View view) {
		Button btnRollDice = view.findViewById(R.id.btnRollDice);

		btnRollDice.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				threadHandler.removeCallbacks(solverThread);
				threadHandler.removeCallbacks(diceRollerThread);
				threadHandler.post(diceRollerThread);
			}

		});
	}

	private void setupBtnSolveSG(View view) {
		Button btnSolveSG =view.findViewById(R.id.btnSolveSG);

		btnSolveSG.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				threadHandler.removeCallbacks(diceRollerThread);
				threadHandler.removeCallbacks(solverThread);
				threadHandler.post(solverThread);
			}
		});
	}

	private void initSpinners(View view) {
		addSpinnerItemSelectedListener(view, R.id.spnNoOfD6, new SGSpinnerItemSelectedListenerData(threadHandler, getView(), R.id.spnNoOfD8));
		addSpinnerItemSelectedListener(view, R.id.spnNoOfD8, new SGSpinnerItemSelectedListenerData(threadHandler, getView(), R.id.spnNoOfD6));
		addSpinnerItemSelectedListener(view, R.id.spnSpellLevel, new SGSpinnerItemSelectedListenerData(threadHandler, getView()));
	}

	private void addSpinnerItemSelectedListener(View view, Integer spinnerId, AdapterView.OnItemSelectedListener listener) {
		Spinner spinner = view.findViewById(spinnerId);
		spinner.setOnItemSelectedListener(listener);
	}
}
