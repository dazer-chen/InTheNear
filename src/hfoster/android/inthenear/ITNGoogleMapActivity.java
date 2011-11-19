package hfoster.android.inthenear;

import com.google.android.maps.MapActivity;

import android.os.Bundle;

public class ITNGoogleMapActivity extends MapActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.googlemaps);
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
