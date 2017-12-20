package de.rge.android.tools.of.wizardry.runnable;

import android.view.View;

import java.util.Locale;

import de.rge.basic.solver.ArithmancySolver;
import de.rge.basic.solver.impl.ArithmancySolverImpl;
import de.rge.toolsofwizardry.R;
import de.rge.android.tools.of.wizardry.util.ViewUtil;

public class ArithmancySolvingThread implements Runnable {

    private ArithmancySolver arithmancySolver = new ArithmancySolverImpl();

    private ViewUtil viewUtil;

    public ArithmancySolvingThread(View rootView) {
        viewUtil = new ViewUtil(rootView);
    }

    public void run() {
        String spellName = viewUtil.retrieveTextViewText(R.id.edtSpellName);
        viewUtil.updateTextView(R.id.tvwArithmancySolution, computeResponse(spellName));
    }

    private String computeResponse(String spellName) {
        if (spellName.isEmpty()) {
            return "Please enter a spell name!";
        }
        int result = arithmancySolver.solve(spellName);
        return String.format(Locale.ENGLISH,
                "Successful computation:\ninput:\t%s\nresult:\t%d",
                spellName,
                result);
    }

}
