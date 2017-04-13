package azrhei.net.noiseatlas.DataTypes;

/**
 * Created by Azrhei on 4/12/2017.
 */

public class LocationData {
    private double longitude;
    private double latitude;
    private double altitude;
    private double accuracy;
    private long time;

    public LocationData(double longitude, double latitude, double altitude, double accuracy, long time) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.accuracy = accuracy;
        this.time = time;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public long getTime() {
        return time;
    }
}
