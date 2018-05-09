package com.androidaddicts.opengl.foundation.music;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.androidaddicts.opengl.R;

import java.io.FileDescriptor;
import java.io.IOException;

/**
 ## MediaPlayer
 MediaPlayer 进行音/视频文件的播放

 ### MediaPlayer 的生命周期

 #### `Idle` 状态。
 使用 `new` 方法创建一个 `MediaPlayer` 对象或者调用了其 `reset` 方法时，该 `MediaPlayer` 对象处 于 `Idle` 状态。
 但通过以上两种不同方式进入的 `Idle` 状态还是有些区别的，主要体现为:如果在此状态下调 用了`getDuration`等方法，并且是通过`reset`方法进入`Idle`状态的话会触发`OnErrorListener.onError`， 同时 `MediaPlayer` 会进入 `Error` 状态;如果是新创建的 `MediaPlayer` 对象，则并不会触发 `onError`， 也不会进入 `Error` 状态。

 􏲋####  `End` 状态。
 通过 `release` 方法可以进入 `End` 状态，只要 `MediaPlayer` 对象不再被使用，就应当尽快将其通
 过 `release` 方法释放掉，以释放其占用的软、硬件资源，这其中有些资源是互斥的(相当于临界资 源)。如果 `MediaPlayer` 对象进入了 `End` 状态，则不会再进入其他任何状态了。

 #### Initialized 状态。
 这个状态比较简单，`MediaPlayer` 调用 `setDataSource` 方法就进入了 `Initialized` 状态，表示此时 要播放的文件已经设置好了。
 􏲋
 #### `Prepared` 状态。
 初始化完成之后还需要通过调用 `prepare` 或 `prepareAsync` 方法进行准备，这两个方法一个是 同步的，一个是异步的。只有进入了 `Prepared` 状态，才表明 `MediaPlayer` 到目前为止都工作正常， 可以进行音乐文件的播放。

 􏲋#### `Preparing` 状态。
 这个状态比较容易理解，主要是与 `prepareAsync` 异步准备方法配合，如果异步准备完成，会 触发 `OnPreparedListener.onPrepared`，进而进入 `Prepared` 状态。

 􏲋#### `Started` 状态。
 `MediaPlayer` 准备完成后，通过调用 `start` 方法，将进入 `Started` 状态。所谓 `Started` 状态，也就 是播放中状态，开发中可以使用 `isPlaying` 方法测试 `MediaPlayer` 是否处于 `Started` 状态。
 如果播放完毕，而又设置了循环播放，则 `MediaPlayer` 仍然会处于 `Started` 状态。类似地，如 果在该状态下 `MediaPlayer` 调用了 `seekTo` 或者 `start` 方法均可以让 `MediaPlayer` 停留在 `Started` 状态。

 #### `Paused` 状态。
 `Started` 状态下调用 `pause` 方法可以暂停播放，从而进入 `Paused` 状态。`MediaPlayer` 暂停后若 再次调用 `start` 方法则可以继续进行播放，并转到 `Started` 状态。暂停状态时可以调用 `seekTo` 方法， 这时此 `MediaPlayer` 的状态是不变的。
 􏲋
 #### `Stopped` 状态。
 `Started` 或 `Paused` 状态下均可调用 `stop` 方法停止播放并进入 `Stopped` 状态，而处于 `Stopped` 状 态的 `MediaPlayer` 要想重新播放，需要通过调用 `prepareAsync` 或 `prepare` 方法返回到先前的 `Prepared` 状态重新开始才可以。
 􏲋
 #### `PlaybackCompleted` 状态。
 文件正常播放完毕，而又没有设置循环播放的话就进入该状态，并会触发 `OnCompletionListener` 接口中的 `onCompletion` 方法。此时可以调用 `start` 方法重新从头播放文件， 也可以调用 `stop` 方法停止播放，或者调用 `seekTo` 方法来重新定位播放位置。

 􏲋#### `Error` 状态。
 由于某种原因 `MediaPlayer` 出现了错误，就会触发 `OnErrorListener.onError` 回调方法，此时 MediaPlayer 将会进入 `Error` 状态。及时捕捉并妥善处理这些错误是很重要的，这可以帮助应用程 序及时释放相关的软、硬件资源，也可以改善用户体验。
 如果 `MediaPlayer` 进入了 `Error` 状态，可以通过调用 reset 方法来恢复，使得 `MediaPlayer` 重新 返回到 `Idle` 状态。


 ## AudioManager
 主要用来进行音/视频播放时的音量控制

 ### 使用步骤
 1. 通过`Activity`对象的`getSystemService(Context.AUDIO_SERVICE)`方法获取 AudioManager 对象
 2. 调用 AudioManager 类中的相关方法进行音量控制

 */


/**
 * 本案例播放 `assets/i_like.mp3`
 */
public class MusicPlayerActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    private int maxVolume;
    private int currentVolume;

    private int stepVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        setTitle("使用MediaPlayer播放");
        initMediaPlayer();
        initAudioManager();
        initVolumes();
    }

    private void initAudioManager() {
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    }

    private void initVolumes() {
        if (mediaPlayer == null) {
            initAudioManager();
        }
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        stepVolume = maxVolume / 20;
    }

    private void initMediaPlayer() {
        mediaPlayer = new MediaPlayer();

        try {
            AssetFileDescriptor filePath = getFilePath();
            if (filePath == null) {
                return;
            }
            mediaPlayer.setDataSource(filePath.getFileDescriptor(), filePath.getStartOffset(), filePath.getLength());
            mediaPlayer.prepare();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private AssetFileDescriptor getFilePath () {
        try {
            return getAssets().openFd("i_like.mp3");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void play(View view) {
        mediaPlayer.start();
        Toast.makeText(this, "开始播放", Toast.LENGTH_SHORT).show();
    }

    public void pause(View view) {
        mediaPlayer.pause();
        Toast.makeText(this, "暂停播放", Toast.LENGTH_SHORT).show();
    }

    public void stop(View view) {
        mediaPlayer.stop();
        try {
            mediaPlayer.prepare();
        }catch (IllegalStateException e) {
          e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "停止播放", Toast.LENGTH_SHORT).show();
    }

    public void volumeUp(View view) {
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        int tmpVolume = currentVolume + stepVolume;
        //增加音量，但不超过最大音量值
        currentVolume = tmpVolume < maxVolume ? tmpVolume:maxVolume;
       //临时音量
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume, AudioManager.FLAG_PLAY_SOUND);
        Toast.makeText(getBaseContext(), "增大音量",
                Toast.LENGTH_SHORT).show();
    }

    public void volumeDown(View view) {
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        //减小音量，但不小于 0
        int tmpVolume = currentVolume - stepVolume;
        //临时音量
        currentVolume = tmpVolume > 0 ? tmpVolume:0;
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume, AudioManager.FLAG_PLAY_SOUND);
        Toast.makeText(getBaseContext(), "减小音量",
                Toast.LENGTH_SHORT).show();
    }
}
