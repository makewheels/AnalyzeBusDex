package com.e4a.runtime;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import java.io.File;
import java.io.IOException;

@SimpleObject
/* renamed from: com.e4a.runtime.媒体操作 */
public final class C0850 {
    private static int MAX_VOLUME = 100;
    private static int Progress;
    private static MediaPlayer mp;
    private static boolean over;

    /* renamed from: com.e4a.runtime.媒体操作$1 */
    static class C08481 implements OnBufferingUpdateListener {
        C08481() {
        }

        public void onBufferingUpdate(MediaPlayer mp, int percent) {
            C0850.setProgress(percent);
        }
    }

    /* renamed from: com.e4a.runtime.媒体操作$2 */
    static class C08492 implements OnCompletionListener {
        C08492() {
        }

        public void onCompletion(MediaPlayer mp) {
            C0850.over = true;
            mp.release();
        }
    }

    private C0850() {
    }

    @SimpleFunction
    /* renamed from: 播放音乐 */
    public static void m6647(String mFile) {
        Progress = 0;
        mp = new MediaPlayer();
        over = false;
        try {
            if (mFile.startsWith("/")) {
                if (new File(mFile).exists()) {
                    mp.setDataSource(mFile);
                }
            } else if (mFile.startsWith("http://")) {
                mp.setDataSource(mFile);
                mp.setOnBufferingUpdateListener(new C08481());
            } else {
                AssetFileDescriptor aFD = C0841.m6594().getAssets().openFd(mFile);
                mp.setDataSource(aFD.getFileDescriptor(), aFD.getStartOffset(), aFD.getLength());
                aFD.close();
            }
            mp.prepare();
            mp.start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        mp.setOnCompletionListener(new C08492());
    }

    private static void setProgress(int value) {
        Progress = value;
    }

    @SimpleFunction
    /* renamed from: 取缓冲进度 */
    public static int m6645() {
        return Progress;
    }

    @SimpleFunction
    /* renamed from: 继续播放 */
    public static void m6649() {
        if (!over && mp != null) {
            try {
                mp.start();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    @SimpleFunction
    /* renamed from: 停止播放 */
    public static void m6641() {
        if (!over && mp != null) {
            try {
                over = true;
                mp.stop();
                mp.release();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    @SimpleFunction
    /* renamed from: 暂停播放 */
    public static void m6648() {
        if (!over && mp != null) {
            try {
                mp.pause();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    @SimpleFunction
    /* renamed from: 取循环播放 */
    public static boolean m6642() {
        if (over || mp == null) {
            return false;
        }
        return mp.isLooping();
    }

    @SimpleFunction
    /* renamed from: 置循环播放 */
    public static void m6650(boolean value) {
        if (!over && mp != null) {
            mp.setLooping(value);
        }
    }

    @SimpleFunction
    /* renamed from: 取音乐时长 */
    public static int m6646() {
        if (over || mp == null) {
            return 0;
        }
        return mp.getDuration();
    }

    @SimpleFunction
    /* renamed from: 取播放位置 */
    public static int m6643() {
        if (over || mp == null) {
            return 0;
        }
        return mp.getCurrentPosition();
    }

    @SimpleFunction
    /* renamed from: 置播放位置 */
    public static void m6651(int value) {
        if (!over && mp != null) {
            mp.seekTo(value);
        }
    }

    @SimpleFunction
    /* renamed from: 置播放音量 */
    public static void m6652(int soundVolume) {
        if (!over && mp != null) {
            float volume = (float) (1.0d - (Math.log((double) (MAX_VOLUME - soundVolume)) / Math.log((double) MAX_VOLUME)));
            mp.setVolume(volume, volume);
        }
    }

    @SimpleFunction
    /* renamed from: 取播放状态 */
    public static boolean m6644() {
        if (over || mp == null) {
            return false;
        }
        return mp.isPlaying();
    }
}
