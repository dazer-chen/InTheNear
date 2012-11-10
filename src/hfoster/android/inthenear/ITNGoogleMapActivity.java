package hfoster.android.inthenear;

import hfoster.android.inthenear.intent.ITNIntent;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class ITNGoogleMapActivity extends MapActivity {
	
	static GeoPoint currLoc;
	static MapView mapView;
	static MapController mapCtrlr;
	static LocationManager locMgr;
	static Location loc;
	static ITNLocationListener locListener;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.googlemaps);
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        mapCtrlr = mapView.getController();
        locMgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        loc = locMgr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        locListener = new ITNLocationListener();
        locMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locListener);
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable[] mapIcons = new Drawable[11];
        mapIcons[0] = this.getResources().getDrawable(R.drawable.smiley_happy);
        for (int i = 1; i < mapIcons.length; i++) {
        	mapIcons[i] = this.getResources().getDrawable(Integer.parseInt("R.drawable.number_" + i));
        }
        ITNItemizedOverlay itemizedOverlay = new ITNItemizedOverlay(mapIcons[0]);
        // currLoc = new GeoPoint((int) loc.getLatitude(), (int) loc.getLongitude());
        // OverlayItem userIsHere = new OverlayItem(currLoc, null, null);
        // itemizedOverlay.addOverlay(userIsHere);
        // mapOverlays.add(itemizedOverlay);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mainmenu, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection for menu -- i.e. refresh the screen or go to Settings
		switch (item.getItemId()) {
		case R.id.refresh:
			// Refresh mapView to current location and search for active search terms
			return true;
		case R.id.settings:
			// Create and pass an Intent to open the Settings Activity
			ITNIntent intent = new ITNIntent(ITNIntent.ACTION_ITN_SETTINGS);
			startActivity(intent);
			return true;
		default:
			return onOptionsItemSelected(item);
		}
	}

	@Override
	protected boolean isRouteDisplayed() {
		// I don't really know what to do here, so returning false
		return false;
	}

}
