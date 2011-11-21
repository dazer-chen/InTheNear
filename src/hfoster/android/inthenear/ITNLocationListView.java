package hfoster.android.inthenear;

import android.app.ListActivity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ITNLocationListView extends ListActivity {
	
	private LocationManager locationManager;
	private String provider;
	private final Location[] LOCATIONS = new Location[] {	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<Location>(this, R.layout.locationlist, LOCATIONS));
		
		// Get a LocationManager.
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		// Define criteria for selecting location provider.
		Criteria criteria = new Criteria();
		provider = locationManager.getBestProvider(criteria, false);
		Location location = locationManager.getLastKnownLocation(provider);
		
		ListView lv = getListView();
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// When clicked, perform some action
			}
		});
	}
	
}
