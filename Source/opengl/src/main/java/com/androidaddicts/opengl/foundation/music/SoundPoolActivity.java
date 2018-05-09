package com.androidaddicts.opengl.foundation.music;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.androidaddicts.opengl.R;

import java.util.HashMap;

/**
 1. 在res下创建raw文件夹，将音乐文件放进raw文件夹中
 2. SoundPool只适合播放不大于7秒的音效文件

 */

public class SoundPoolActivity extends AppCompatActivity {

    SoundPool soundPool;

    /**
     * 用来存储音乐文件
     */
     HashMap<Integer, Integer> soundFile;

     int currentScreamId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_pool);
        setTitle("使用SoundPool播放");
        initSoundPool();
    }

    private void initSoundPool() {
        soundPool = new SoundPool.Builder()
                .setMaxStreams(4)
                .setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(AudioManager.STREAM_MUSIC).build())
                .build();

        soundFile = new HashMap<>(1);
        soundFile.put(1, soundPool.load(this, R.raw.gimme_mo_town, 1));

    }

    public void play(View view) {
        playSound(1, 0);
    }
    public void pause(View view) {
        soundPool.pause(currentScreamId);
    }
    public void stop(View view) {
        soundPool.stop(currentScreamId);
    }

    private void playSound(int sound, int loop) {
        AudioManager audioManager = (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);

        //获取当前音量
        float streamVolumeCurrent = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        // 获取系统最大音量
        float streamMaxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        float volume = streamVolumeCurrent / streamMaxVolume;

        //调用soundPool播放音乐
        currentScreamId = soundPool.play(soundFile.get(sound), volume, volume,1, loop, 1.0f);

    }
}
