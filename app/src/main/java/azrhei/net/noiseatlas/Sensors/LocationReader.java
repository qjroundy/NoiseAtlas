package azrhei.net.noiseatlas.Sensors;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;

import azrhei.net.noiseatlas.DataTypes.LocationData;


/**
 * Created by Azrhei on 4/12/2017.
 */

public class LocationReader implements LocationListener {

    private static float MIN_DISTANCE_INTERVAL = 1;
    private static long MIN_READ_INTERVAL = 1000;
    private LocationData locationData;

    private boolean isGPSEnabled = false;
    private boolean isNetworkEnabled = false;
    private boolean isLocationAvailable = false;
    private boolean hasChanged = false;

    private Context mContext;

    private Location location;

    private LocationManager locationManager;

    public LocationData getLocationData() {
        this.hasChanged = false;
        return locationData;
    }

    public boolean GPSEnabled() {
        return isGPSEnabled;
    }

    public boolean network_enabled() {
        return isNetworkEnabled;
    }

    public boolean location_available() {
        return (location != null);
    }

    public LocationReader() {
        init_gps();
    }

    private void init_gps() {

        if (locationManager == null) {
            locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        }

//        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(Manifest.permission.ACCESS_FINE_LOCATION);
//        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_READ_INTERVAL, MIN_DISTANCE_INTERVAL, this);

        // getting GPS status
        isGPSEnabled = locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER);

        // getting network status
        isNetworkEnabled = locationManager
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

    }

    /**
     * Just in case it stops, this should be used to restart the GPS reader
     */
    public void restart()
    {
        init_gps();
    }

    @Override
    public void onLocationChanged(Location location) {
        this.hasChanged = true;
        this.locationData = new LocationData(
                location.getLongitude(),
                location.getLatitude(),
                location.getAltitude(),
                location.getAccuracy(),
                location.getTime()
        );
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }


    /**
     * Location
     * @param provider
     */
    @Override
    public void onProviderEnabled(String provider) {


    }

    /**
     * Location service disabled while using app
     */
    @Override
    public void onProviderDisabled(String provider) {

        // Attempt to get setting for location service to show
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        mContext.startActivity(intent);
    }
}
