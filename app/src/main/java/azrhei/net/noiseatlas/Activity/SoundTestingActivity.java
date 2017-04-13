package azrhei.net.noiseatlas.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

import azrhei.net.noiseatlas.R;
import azrhei.net.noiseatlas.Sensors.SoundReader;

public class SoundTestingActivity
        extends AppCompatActivity
        implements View.OnClickListener
{

    private SoundReader sound = new SoundReader();
    private Set<Button> buttons = new HashSet<>();
    private TextView tv_sound_level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_testing);

        tv_sound_level = (TextView) findViewById(R.id.tv_sound_level);

        buttons.add((Button) findViewById(R.id.btn_get_sound_level));

        for(Button b : buttons)
        {
            b.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btn_get_sound_level:
                tv_sound_level.setText(Double.toString(sound.getDecibels()));
                break;
        }
    }
}
