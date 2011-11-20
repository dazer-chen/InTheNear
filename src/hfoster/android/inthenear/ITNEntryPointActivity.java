package hfoster.android.inthenear;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ITNEntryPointActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrypoint);
        
        final Button locListButton = (Button) findViewById(R.id.location_list_button);
        final Button addLocButton = (Button) findViewById(R.id.add_location_button);
        locListButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO On-Click action
				// Call the ITNLocationListView Activity
			}
		});
        addLocButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO On-Click action
				// Call an Activity where the user can add Locations
			}
		});
    }
}