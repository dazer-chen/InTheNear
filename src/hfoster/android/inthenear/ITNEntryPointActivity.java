package hfoster.android.inthenear;

import hfoster.android.inthenear.intent.ITNIntent;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ITNEntryPointActivity extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrypoint);
    }
    
    public void callIntentByView(View view) {
    	ITNIntent intent = null;
    	switch (view.getId()) {
    	case R.id.add_location_button:
    		intent = new ITNIntent(ITNIntent.ACTION_ADD_LOCATION);
    		try {
    			startActivity(intent);
    		}
    		catch (Exception e) {
    			Log.w(this.getClass().getName(), e.getMessage(), e);
    		}
    		break;
    	case R.id.location_list_button:
    		intent = new ITNIntent(ITNIntent.ACTION_SHOW);
    		try {
    			startActivity(intent);
    		}
    		catch (Exception e) {
    			Log.w(this.getClass().getName(), e.getMessage(), e);
    		}
    		break;
    	default:
    		break;
    	}
    }
}