package azrhei.net.noiseatlas.Sensors;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;

public class SoundReader {
    static final private double EMA_FILTER = 0.6;

    private double mEMA = 0.0;
    private AudioRecord record = null;
    private int minSize;

    @Deprecated
    private void start()  {
        minSize= AudioRecord.getMinBufferSize(8000, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
        record = new AudioRecord(MediaRecorder.AudioSource.MIC, 8000,AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT,minSize);
        record.startRecording();
    }

    @Deprecated
    private void stop() {
        if (record != null) {
            record.stop();
        }
        this.record = null;
    }

    public double getDecibels()
    {
        return 20 * Math.log( getAmplitude() / 32767);
    }

    private double getAmplitude(){
        this.start();
        short[] buffer = new short[minSize];
        record.read(buffer, 0, minSize);
        int max = 0;
        for (short s : buffer)
        {
            if (Math.abs(s) > max)
            {
                max = Math.abs(s);
            }
        }
        this.stop();
        return max;
    }

    public double getAmplitudeEMA() {
        double amp = getAmplitude();
        mEMA = EMA_FILTER * amp + (1.0 - EMA_FILTER) * mEMA;
        return mEMA;
    }
}