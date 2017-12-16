package de.rge.ui.util;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class ViewUtil {
	private View rootView;
	
	public ViewUtil(View rootView) {
		this.rootView = rootView;
	}
	
	public String retrieveTextViewText(int textViewId) {
		TextView tvw = rootView.findViewById(textViewId);
		return tvw.getText().toString();
	}
	
	public void updateTextView(int textViewId, String newText) {
		TextView tvw = rootView.findViewById(textViewId);
		tvw.setText(newText);
	}

	public Integer retrieveSpinnerInteger(int spinnerId) {
		Spinner spnNoOfDice = rootView.findViewById(spinnerId);
		String strNoOfDice = (String) spnNoOfDice.getSelectedItem();
		return Integer.parseInt(strNoOfDice);
	}

}
