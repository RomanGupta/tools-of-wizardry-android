package de.rge.android.tools.of.wizardry.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import static de.rge.android.tools.of.wizardry.util.ArgumentUtil.ArgumentIdentifier.TAB_NUMBER;
import static de.rge.android.tools.of.wizardry.util.ArgumentUtil.ArgumentIdentifier.TAB_TITLE;

public class ArgumentUtil {
    public enum ArgumentIdentifier {
        TAB_NUMBER, TAB_TITLE
    }

    public void setTabNumber(Fragment fragment, int tabNumber) {
        Bundle args = getBundle(fragment);
        args.putInt(TAB_NUMBER.name(), tabNumber);
    }

    public void setTabTitle(Fragment fragment, String tabTitle) {
        Bundle args = getBundle(fragment);
        args.putString(TAB_TITLE.name(), tabTitle);
    }

    public String getTabTitle(Fragment fragment) {
        return fragment.getArguments().getString(TAB_TITLE.name());
    }

    private Bundle getBundle(Fragment fragment) {
        Bundle args = fragment.getArguments();
        if (null == args) {
            args = new Bundle();
            fragment.setArguments(args);
        }
        return args;
    }

}
