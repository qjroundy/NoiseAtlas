package azrhei.net.noiseatlas.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceActivity;

import azrhei.net.noiseatlas.R;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

/**
 * This will ultimately control preference for the app.
 *
 * ie:
 * SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
 * String strUserName = SP.getString("username", "NA");
 * boolean bAppUpdates = SP.getBoolean("applicationUpdates",false);
 * String downloadType = SP.getString("downloadType","1");
 *
 * https://developer.android.com/guide/topics/ui/settings.html
 *
 */
public class AppPreferences extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
    }

    public static class MyPreferenceFragment extends PreferenceFragment
    {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }

}
