package azrhei.net.noiseatlas.Common;

import android.content.Context;
import android.util.Log;

import azrhei.net.noiseatlas.BuildConfig;
import azrhei.net.noiseatlas.Sensors.LocationReader;

/**
 * Created by Azrhei on 4/12/2017.
 */

public class GlobalFactory {
    private Context applicationContext;
    private LocationReader location;

    public GlobalFactory(Context applicationContext)
    {
        // initialize
        Log.i("TAG", "Initializing GPS");
        if(location == null) location = new LocationReader();
    }

    public LocationReader getLocationReader()
    {
        if(BuildConfig.DEBUG && location == null) { throw new AssertionError("Failsed to get location service"); }

        return location;
    }

}
