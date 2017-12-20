package de.rge.android.tools.of.wizardry.runnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.view.View;

import de.rge.basic.solver.SacredGeometrySolver;
import de.rge.basic.solver.impl.SacredGeometrySolverImpl;
import de.rge.toolsofwizardry.R;
import de.rge.android.tools.of.wizardry.util.ViewUtil;

public class SacredGeometrySolvingThread implements Runnable {
	
	private SacredGeometrySolver sacredGeometrySolver = new SacredGeometrySolverImpl();

	private ViewUtil viewUtil;
	
	public SacredGeometrySolvingThread(View rootView) {
		viewUtil = new ViewUtil(rootView);
	}

	public void run() {
		Integer spellLevel = viewUtil.retrieveSpinnerInteger(R.id.spnSpellLevel);
		List<Integer> diceValues = retrieveDiceValues();
		viewUtil.updateTextView(R.id.tvwSolution, computeResponse(spellLevel, diceValues));
	}

	private List<Integer> retrieveDiceValues() {
		String strDiceValues = viewUtil.retrieveTextViewText(R.id.edtDiceValues);
		List<Integer> diceValues = new ArrayList<>();
		for (char character : strDiceValues.toCharArray()) {
				diceValues.add(Character.digit(character, 10));
		}
		return diceValues;
	}
	
	private String computeResponse(Integer spellLevel, List<Integer> diceValues) {
		if(diceValues.isEmpty()) {
			return "Please roll the dice or enter dice values!";
		}
		Boolean isSolvable = sacredGeometrySolver.solve(spellLevel, diceValues);
		if (isSolvable) {
			return "Solution:\n" + sacredGeometrySolver.printSolution();
		}
		return String.format(Locale.ENGLISH, "Dice Values %s are not solvable for spellLevel %d.", diceValues, spellLevel);
	}

}
