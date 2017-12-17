package de.rge.toolsofwizardry.android.runnable;

import java.util.Locale;

import android.app.Activity;
import android.view.View;

import de.rge.data.FailureResultSets;
import de.rge.toolsofwizardry.R;
import de.rge.ui.util.ViewUtil;

public class ProbabilityComputingThread implements Runnable {

	private ViewUtil viewUtil;

	public ProbabilityComputingThread(View rootView) {
		viewUtil = new ViewUtil(rootView);
	}

	public void run() {
		Integer noOfD6 = viewUtil.retrieveSpinnerInteger(R.id.spnNoOfD6);
		Integer noOfD8 = viewUtil.retrieveSpinnerInteger(R.id.spnNoOfD8);
		Integer spellLevel = viewUtil.retrieveSpinnerInteger(R.id.spnSpellLevel);
		Double probability = FailureResultSets.computeSuccessProbability(spellLevel, noOfD6, noOfD8);
		viewUtil.updateTextView(R.id.tvwProbability, assembleProbabilityString(noOfD6, noOfD8, spellLevel, probability));
	}

	private String assembleProbabilityString(Integer noOfD6, Integer noOfD8, Integer spellLevel, Double probability) {
		return String.format(Locale.ENGLISH, "Success rate for %dD6 & %dD8 at spell level %d: %14.10f%%", noOfD6, noOfD8, spellLevel,
				probability * 100.0);
	}

}
