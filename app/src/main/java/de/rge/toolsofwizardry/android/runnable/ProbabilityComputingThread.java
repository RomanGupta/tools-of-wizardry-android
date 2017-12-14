package de.rge.toolsofwizardry.android.runnable;

import java.util.Locale;

import android.app.Activity;
import de.rge.data.FailureResultSets;
import de.rge.toolsofwizardry.R;
import de.rge.ui.util.ActivityUtil;

public class ProbabilityComputingThread implements Runnable {

	private ActivityUtil activityUtil;

	public ProbabilityComputingThread(Activity activity) {
		activityUtil = new ActivityUtil(activity);
	}

	public void run() {
		Integer noOfD6 = activityUtil.retrieveSpinnerInteger(R.id.spnNoOfD6);
		Integer noOfD8 = activityUtil.retrieveSpinnerInteger(R.id.spnNoOfD8);
		Integer spellLevel = activityUtil.retrieveSpinnerInteger(R.id.spnSpellLevel);
		Double probability = FailureResultSets.computeSuccessProbability(spellLevel, noOfD6, noOfD8);
		activityUtil.updateTextView(R.id.tvwProbability, assembleProbabilityString(noOfD6, noOfD8, spellLevel, probability));
	}

	private String assembleProbabilityString(Integer noOfD6, Integer noOfD8, Integer spellLevel, Double probability) {
		return String.format(Locale.ENGLISH, "Success rate for %dD6 & %dD8 at spell level %d: %14.10f%%", noOfD6, noOfD8, spellLevel,
				probability * 100.0);
	}

}
