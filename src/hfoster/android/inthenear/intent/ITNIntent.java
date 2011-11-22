package hfoster.android.inthenear.intent;

import android.content.Intent;

public class ITNIntent extends Intent {
	
	public ITNIntent(String action) {
		super(action);
	}
	public static final String ACTION_SHOW = "hfoster.android.inthenear.intent.action.SHOW";
	public static final String ACTION_ADD_LOCATION = "hfoster.android.inthenear.intent.action.ADD_LOCATION";

}
