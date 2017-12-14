package de.rge.toolsofwizardry.android.runnable;

import java.util.List;

import android.app.Activity;
import de.rge.basic.util.DiceUtil;
import de.rge.toolsofwizardry.R;
import de.rge.ui.util.ActivityUtil;

public class DiceRollingThread implements Runnable {

	private DiceUtil diceUtil = new DiceUtil();
	
	private ActivityUtil activityUtil;
	
	public DiceRollingThread(Activity activity) {
		activityUtil = new ActivityUtil(activity);
	}

	public void run() {
		Integer noOfD6 = activityUtil.retrieveSpinnerInteger(R.id.spnNoOfD6);
		Integer noOfD8 = activityUtil.retrieveSpinnerInteger(R.id.spnNoOfD8);
		List<Integer> diceValues = rollDice(noOfD6, noOfD8);
		activityUtil.updateTextView(R.id.edtDiceValues, convertToString(diceValues));
	}

	private List<Integer> rollDice(Integer noOfD6, Integer noOfD8) {
		List<Integer> diceValues = diceUtil.rollD6(noOfD6);
		diceValues.addAll(diceUtil.rollD8(noOfD8));
		return diceValues;
	}

	private String convertToString(List<Integer> diceValues) {
		String conversion = "";
		for (Integer value : diceValues) {
			conversion += value;
		}
		return conversion;
	}

}
