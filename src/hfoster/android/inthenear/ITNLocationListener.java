package hfoster.android.inthenear;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class ITNLocationListener implements LocationListener {
	
	private double longitude;
	private double latitude;
	private String provider;
	private Location location;

	public ITNLocationListener() {
		// Does nothing special
	}
	
	public ITNLocationListener(Location location) {
		// sets up a new LocationListener with Location properties.
		updateWithNewLocation(location);
	}

	@Override
	public void onLocationChanged(Location location) {
		updateWithNewLocation(location);
	}

	private void updateWithNewLocation(Location location) {
		this.setLatitude(location.getLatitude());
		this.setLongitude(location.getLongitude());
		this.setProvider(location.getProvider());
		this.setLocation(location);
	}

	@Override
	public void onProviderDisabled(String provider) {
		if (provider == LocationManager.GPS_PROVIDER) {
			this.setProvider(LocationManager.NETWORK_PROVIDER);
		}
		else if (provider == LocationManager.NETWORK_PROVIDER) {
			this.setProvider(LocationManager.GPS_PROVIDER);
		}
		else {
			this.setProvider(null);
		}
	}

	@Override
	public void onProviderEnabled(String provider) {
		this.setProvider(provider);
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		this.setProvider(provider);
	}

	// Accessor methods for private fields
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProvider() {
		return provider;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

}
