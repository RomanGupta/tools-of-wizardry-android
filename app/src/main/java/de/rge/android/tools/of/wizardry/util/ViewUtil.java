package de.rge.android.tools.of.wizardry.util;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class ViewUtil {
	private View view;
	
	public ViewUtil(View rootView) {
		this.view = rootView;
	}
	
	public String retrieveTextViewText(int textViewId) {
		TextView tvw = view.findViewById(textViewId);
		return tvw.getText().toString();
	}
	
	public void updateTextView(int textViewId, String newText) {
		TextView tvw = view.findViewById(textViewId);
		tvw.setText(newText);
	}

	public Integer retrieveSpinnerInteger(int spinnerId) {
		Spinner spnNoOfDice = view.findViewById(spinnerId);
		String strNoOfDice = (String) spnNoOfDice.getSelectedItem();
		return Integer.parseInt(strNoOfDice);
	}

}
