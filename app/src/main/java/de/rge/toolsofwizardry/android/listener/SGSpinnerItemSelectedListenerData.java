package de.rge.toolsofwizardry.android.listener;

import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import de.rge.toolsofwizardry.android.runnable.ProbabilityComputingThread;

public class SGSpinnerItemSelectedListenerData implements AdapterView.OnItemSelectedListener {
	private final static int MAX_SUM = 14;

	private Handler threadHandler;
	private View rootView;
	private Runnable probabilityThread; 
	private Spinner counterSpinner;

	public SGSpinnerItemSelectedListenerData(Handler threadHandler, View rootView) {
		this(threadHandler, rootView, null);
	}

	public SGSpinnerItemSelectedListenerData(Handler threadHandler, View rootView, Integer counterSpinnerId) {
		this.threadHandler = threadHandler;
		this.rootView = rootView;
		this.probabilityThread = new ProbabilityComputingThread(rootView);
		this.counterSpinner = (Spinner) (null != counterSpinnerId ? rootView.findViewById(counterSpinnerId) : null);
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1,
			int arg2, long arg3) {
		if (null != counterSpinner) {
			setItemSumToMax((Spinner) arg0);
		}
		threadHandler.removeCallbacks(probabilityThread);
		threadHandler.post(probabilityThread);
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
