package de.rge.toolsofwizardry.android.runnable;

import java.util.List;

import android.view.View;

import de.rge.basic.util.DiceUtil;
import de.rge.toolsofwizardry.R;
import de.rge.ui.util.ViewUtil;

public class DiceRollingThread implements Runnable {

	private DiceUtil diceUtil = new DiceUtil();
	
	private ViewUtil activityUtil;
	
	public DiceRollingThread(View rootView) {
		activityUtil = new ViewUtil(rootView);
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
