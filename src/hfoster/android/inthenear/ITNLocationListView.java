package hfoster.android.inthenear;

import android.app.ListActivity;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ITNLocationListView extends ListActivity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<Location>(this, R.layout.locationlist, LOCATIONS));
		
		ListView lv = getListView();
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// When clicked, perform some action
			}
		});
	}
	
	static final Location[] LOCATIONS = new Location[] { // Can't really use an Array here, as I'll want to add and remove Locations
		// Some juicy Locations go here
	};

}
