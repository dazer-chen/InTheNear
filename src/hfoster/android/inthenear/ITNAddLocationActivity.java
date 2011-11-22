package hfoster.android.inthenear;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ITNAddLocationActivity extends Activity {
	
	private LocationManager locationManager;
	private String provider;
	private TextView longitudeField;
	private TextView latitudeField;
	private TextView locationDescField;
	private final Button addLocButton = (Button) findViewById(R.id.add_location_button);
	private final Button getCurrLocButton = (Button) findViewById(R.id.get_curr_loc_button);
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addlocation);
		
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		provider = locationManager.getBestProvider(criteria, false);
		
		longitudeField = (TextView) findViewById(R.id.longitude);
		latitudeField = (TextView) findViewById(R.id.latitude);
		locationDescField = (TextView) findViewById(R.id.label);
		
		getCurrLocButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Location location = locationManager.getLastKnownLocation(provider);
				longitudeField.setText((char) location.getLongitude());
				latitudeField.setText((char) location.getLatitude());
			}
		});
		
		addLocButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			}
		});
	}

}