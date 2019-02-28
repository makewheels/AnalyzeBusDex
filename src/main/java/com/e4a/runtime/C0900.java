package com.e4a.runtime;

import android.media.AudioManager;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;

@SimpleObject
/* renamed from: com.e4a.runtime.音量操作 */
public final class C0900 {
    private C0900() {
    }

    @SimpleFunction
    /* renamed from: 取音量 */
    public static int m6965(int 音量类型) {
        int i;
        mainActivity context = mainActivity.getContext();
        mainActivity.getContext();
        AudioManager am = (AudioManager) context.getSystemService("audio");
        switch (音量类型) {
            case 1:
                i = am.getStreamVolume(1);
                break;
            case 2:
                i = am.getStreamVolume(0);
                break;
            case 3:
                i = am.getStreamVolume(2);
                break;
            case 4:
                i = am.getStreamVolume(3);
                break;
            case 5:
                i = am.getStreamVolume(4);
                break;
            default:
                i = am.getStreamVolume(1);
                break;
        }
        return i;
    }

    @SimpleFunction
    /* renamed from: 取最大音量 */
    public static int m6964(int 音量类型) {
        int i;
        mainActivity context = mainActivity.getContext();
        mainActivity.getContext();
        AudioManager am = (AudioManager) context.getSystemService("audio");
        switch (音量类型) {
            case 1:
                i = am.getStreamMaxVolume(1);
                break;
            case 2:
                i = am.getStreamMaxVolume(0);
                break;
            case 3:
                i = am.getStreamMaxVolume(2);
                break;
            case 4:
                i = am.getStreamMaxVolume(3);
                break;
            case 5:
                i = am.getStreamMaxVolume(4);
                break;
            default:
                i = am.getStreamMaxVolume(1);
                break;
        }
        return i;
    }

    @SimpleFunction
    /* renamed from: 置音量 */
    public static void m6966(int 音量类型, int 音量值) {
        mainActivity context = mainActivity.getContext();
        mainActivity.getContext();
        AudioManager am = (AudioManager) context.getSystemService("audio");
        switch (音量类型) {
            case 1:
                am.setStreamVolume(1, 音量值, 0);
                break;
            case 2:
                am.setStreamVolume(0, 音量值, 0);
                break;
            case 3:
                am.setStreamVolume(2, 音量值, 0);
                break;
            case 4:
                am.setStreamVolume(3, 音量值, 0);
                break;
            case 5:
                am.setStreamVolume(4, 音量值, 0);
                break;
            default:
                am.setStreamVolume(1, 音量值, 0);
                break;
        }
    }

    @SimpleFunction
    /* renamed from: 耳机是否插入 */
    public static boolean m6967() {
        mainActivity context = mainActivity.getContext();
        mainActivity.getContext();
        return ((AudioManager) context.getSystemService("audio")).isWiredHeadsetOn();
    }
}
