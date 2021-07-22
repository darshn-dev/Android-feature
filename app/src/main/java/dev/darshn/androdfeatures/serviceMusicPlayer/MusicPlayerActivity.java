package dev.darshn.androdfeatures.serviceMusicPlayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import dev.darshn.androdfeatures.R;
import dev.darshn.androdfeatures.databinding.ActivityMusicPlayerBinding;

public class MusicPlayerActivity extends AppCompatActivity {

    ActivityMusicPlayerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMusicPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUI();
    }

    private void initUI(){
        binding.btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(MusicPlayerActivity.this, MusicService.class));
            }
        });

        binding.btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(MusicPlayerActivity.this, MusicService.class));
            }
        });
    }
}