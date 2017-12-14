package de.rge.toolsofwizardry.android.runnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import de.rge.basic.solver.SacredGeometrySolver;
import de.rge.basic.solver.impl.SacredGeometrySolverImpl;
import de.rge.toolsofwizardry.R;
import de.rge.ui.util.ActivityUtil;

public class SacredGeometrySolvingThread implements Runnable {
	
	private SacredGeometrySolver sacredGeometrySolver = new SacredGeometrySolverImpl();

	private ActivityUtil activityUtil;
	
	public SacredGeometrySolvingThread(Activity activity) {
		activityUtil = new ActivityUtil(activity);
	}

	public void run() {
		Integer spellLevel = activityUtil.retrieveSpinnerInteger(R.id.spnSpellLevel);
		List<Integer> diceValues = retrieveDiceValues();
		Boolean isSolvable = sacredGeometrySolver.solve(spellLevel, diceValues);
		activityUtil.updateTextView(R.id.tvwSolution, determineSolution(isSolvable, diceValues, spellLevel));
	}

	private List<Integer> retrieveDiceValues() {
		String strDiceValues = activityUtil.retrieveTextViewText(R.id.edtDiceValues);
		List<Integer> diceValues = new ArrayList<Integer>();
		for (char character : strDiceValues.toCharArray()) {
			if ('1' <= character && character <= '8') {
				diceValues.add(Character.digit(character, 10));
			}
		}
		return diceValues;
	}
	
	private String determineSolution(Boolean isSolvable, List<Integer> diceValues, Integer spellLevel) {
		if (isSolvable) {
			return "Solution:\n" + sacredGeometrySolver.printSolution();
		}
		return String.format(Locale.ENGLISH, "Dice Values %s are not solvable for spellLevel %d.", diceValues, spellLevel);
	}

}
