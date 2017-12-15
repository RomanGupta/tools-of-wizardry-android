package de.rge.toolsofwizardry.android;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import de.rge.toolsofwizardry.R;
import de.rge.toolsofwizardry.android.listener.SGSpinnerItemSelectedListenerData;
import de.rge.toolsofwizardry.android.runnable.DiceRollingThread;
import de.rge.toolsofwizardry.android.runnable.SacredGeometrySolvingThread;

public class ToolsOfWizardryActivity extends Activity {
	private Handler threadHandler = new Handler();

	private Runnable diceRollerThread = new DiceRollingThread(this);

	private Runnable solverThread = new SacredGeometrySolvingThread(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_tools_of_wizardry);

		setupBtnRollDice();
		setupBtnSolveSG();
		addSpinnerItemSelectedListener(R.id.spnNoOfD6, new SGSpinnerItemSelectedListenerData(this, R.id.spnNoOfD8));
		addSpinnerItemSelectedListener(R.id.spnNoOfD8, new SGSpinnerItemSelectedListenerData(this, R.id.spnNoOfD6));
		addSpinnerItemSelectedListener(R.id.spnSpellLevel, new SGSpinnerItemSelectedListenerData(this));
	}

	private void setupBtnRollDice() {
		Button btnRollDice = (Button) findViewById(R.id.btnRollDice);

		btnRollDice.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				threadHandler.removeCallbacks(solverThread);
				threadHandler.removeCallbacks(diceRollerThread);
				threadHandler.post(diceRollerThread);
			}

		});
	}

	private void setupBtnSolveSG() {
		Button btnSolveSG = (Button) findViewById(R.id.btnSolveSG);

		btnSolveSG.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				threadHandler.removeCallbacks(diceRollerThread);
				threadHandler.removeCallbacks(solverThread);
				threadHandler.post(solverThread);
			}
		});
	}

	private void addSpinnerItemSelectedListener(Integer spinnerId, AdapterView.OnItemSelectedListener listener) {
		Spinner spinner = (Spinner) findViewById(spinnerId);
		spinner.setOnItemSelectedListener(listener);
	}

	public Handler getThreadHandler() {
		return threadHandler;
	}

}
