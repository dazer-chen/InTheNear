package hfoster.android.inthenear.intent;

import android.content.Intent;

public class ITNIntent extends Intent {
	
	public ITNIntent(String action) {
		super(action);
	}
	
	public static final String ACTION_ITN_SETTINGS = "hfoster.android.inthenear.intent.ITN_SETTINGS";

}
