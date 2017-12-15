package de.rge.toolsofwizardry.android.listener;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import de.rge.toolsofwizardry.android.ToolsOfWizardryActivity;
import de.rge.toolsofwizardry.android.runnable.ProbabilityComputingThread;

public class SGSpinnerItemSelectedListenerData implements AdapterView.OnItemSelectedListener {
	private final static int MAX_SUM = 14; 
	
	public ToolsOfWizardryActivity activity;
	private Runnable probabilityThread; 
	public Spinner counterSpinner;

	public SGSpinnerItemSelectedListenerData(ToolsOfWizardryActivity activity) {
		this(activity, null);
	}

	public SGSpinnerItemSelectedListenerData(ToolsOfWizardryActivity activity, Integer counterSpinnerId) {
		this.activity = activity;
		this.probabilityThread = new ProbabilityComputingThread(activity);
		this.counterSpinner = (Spinner) (null != counterSpinnerId ? activity.findViewById(counterSpinnerId) : null);
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1,
			int arg2, long arg3) {
		if (null != counterSpinner) {
			setItemSumToMax((Spinner) arg0);
		}
		activity.getThreadHandler().removeCallbacks(probabilityThread);
		activity.getThreadHandler().post(probabilityThread);
	}

	private void setItemSumToMax(Spinner spinner) {
		Integer spinnerValue = getSelectedItemValue(spinner);
		if(spinnerValue + getSelectedItemValue(counterSpinner) > MAX_SUM) {
			counterSpinner.setSelection(MAX_SUM - spinnerValue);
		}
		
	}

	private int getSelectedItemValue(Spinner spinner) {
		return Integer.parseInt((String)spinner.getSelectedItem());
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
	}
}
