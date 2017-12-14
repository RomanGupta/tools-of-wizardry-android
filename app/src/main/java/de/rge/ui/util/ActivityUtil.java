package de.rge.ui.util;

import android.app.Activity;
import android.widget.Spinner;
import android.widget.TextView;

public class ActivityUtil {
	private Activity activity;
	
	public ActivityUtil(Activity activity) {
		this.activity = activity;
	}
	
	public String retrieveTextViewText(int textViewId) {
		TextView tvw = (TextView) activity.findViewById(textViewId);
		return tvw.getText().toString();
	}
	
	public void updateTextView(int textViewId, String newText) {
		TextView tvw = (TextView) activity.findViewById(textViewId);
		tvw.setText(newText);
	}

	public Integer retrieveSpinnerInteger(int spinnerId) {
		Spinner spnNoOfDice = (Spinner) activity.findViewById(spinnerId);
		String strNoOfDice = (String) spnNoOfDice.getSelectedItem();
		return Integer.parseInt(strNoOfDice);
	}

}
