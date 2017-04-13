package azrhei.net.noiseatlas.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import azrhei.net.noiseatlas.Common.GlobalFactory;
import azrhei.net.noiseatlas.R;

public class MainActivity extends AppCompatActivity {

    public static GlobalFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        factory = new GlobalFactory(getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
