package com.example.metronomeapp;

import android.app.Activity;
import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.Vibrator;
import android.os.VibrationEffect;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.metronomeapp.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private TextView mTextView;
    private Button mBtnSub;
    private Button mBtnAdd;
    private SeekBar mSeekTempo;
    private ActivityMainBinding binding;
    private int bpm = 120;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityMainBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        mTextView = binding.tvTempoDisplay;
        mBtnSub = binding.btnSub;
        mBtnAdd = binding.btnAdd;
        mSeekTempo = binding.seekBar;

        mTextView.setText(String.valueOf(bpm));

        // get the VIBRATION_SERVICE system service
        final Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTempo();
                mTextView.setText(String.valueOf(bpm));
                mSeekTempo.setProgress(bpm);
            }
        });

        mBtnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subTempo();
                mTextView.setText(String.valueOf(bpm));
                mSeekTempo.setProgress(bpm);
            }
        });

        mSeekTempo.setProgress(bpm);
        mSeekTempo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                bpm = i;
                mTextView.setText(String.valueOf(bpm));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

    }

    public void addTempo()
    {
        if (bpm > 20 && bpm < 220) {
            bpm += 1;
        }
    }

    public void subTempo()
    {
        if (bpm > 20 && bpm < 220) {
            bpm -= 1;
        }
    }

}
