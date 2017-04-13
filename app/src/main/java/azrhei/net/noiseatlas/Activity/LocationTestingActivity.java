package azrhei.net.noiseatlas.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

import azrhei.net.noiseatlas.R;

public class LocationTestingActivity
        extends AppCompatActivity
        implements View.OnClickListener
{

    Set<Button> buttons = new ConcurrentSkipListSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_testing);

        buttons.add((Button) findViewById(R.id.btn_get_location_test));

        for(Button b : buttons)
        {
            b.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch(view.getId())
        {
            case R.id.btn_get_location_test:


        }

    }
}
