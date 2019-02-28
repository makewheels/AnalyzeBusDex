package com.e4a.runtime.components.impl.android.p021;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.NaviInfo;
import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechListener;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SpeechUser;
import com.iflytek.cloud.speech.SynthesizerListener;

/* renamed from: com.e4a.runtime.components.impl.android.高德导航类库.TTSController */
public class TTSController implements SynthesizerListener, AMapNaviListener {
    public static TTSController ttsManager;
    boolean isfinish = true;
    private SpeechListener listener = new C08291();
    private Context mContext;
    private SpeechSynthesizer mSpeechSynthesizer;

    /* renamed from: com.e4a.runtime.components.impl.android.高德导航类库.TTSController$1 */
    class C08291 implements SpeechListener {
        C08291() {
        }

        public void onData(byte[] bArr) {
        }

        public void onCompleted(SpeechError speechError) {
            if (speechError == null) {
            }
        }

        public void onEvent(int i, Bundle bundle) {
        }
    }

    TTSController(Context context) {
        this.mContext = context;
    }

    public static TTSController getInstance(Context context) {
        if (ttsManager == null) {
            ttsManager = new TTSController(context);
        }
        return ttsManager;
    }

    public void init() {
        SpeechUser.getUser().login(this.mContext, null, null, "appid=528418e6", this.listener);
        this.mSpeechSynthesizer = SpeechSynthesizer.createSynthesizer(this.mContext);
        initSpeechSynthesizer();
    }

    public void playText(String str) {
        if (this.isfinish) {
            if (this.mSpeechSynthesizer == null) {
                this.mSpeechSynthesizer = SpeechSynthesizer.createSynthesizer(this.mContext);
                initSpeechSynthesizer();
            }
            this.mSpeechSynthesizer.startSpeaking(str, this);
        }
    }

    public void stopSpeaking() {
        if (this.mSpeechSynthesizer != null) {
            this.mSpeechSynthesizer.stopSpeaking();
        }
    }

    public void startSpeaking() {
        this.isfinish = true;
    }

    private void initSpeechSynthesizer() {
        this.mSpeechSynthesizer.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");
        this.mSpeechSynthesizer.setParameter(SpeechConstant.SPEED, "50");
        this.mSpeechSynthesizer.setParameter(SpeechConstant.VOLUME, "100");
        this.mSpeechSynthesizer.setParameter(SpeechConstant.PITCH, "50");
    }

    public void setSpeaker(int i) {
        if (this.mSpeechSynthesizer == null) {
            return;
        }
        if (i == 1) {
            this.mSpeechSynthesizer.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");
        } else {
            this.mSpeechSynthesizer.setParameter(SpeechConstant.VOICE_NAME, "xiaoyu");
        }
    }

    public void onBufferProgress(int i, int i2, int i3, String str) {
    }

    public void onCompleted(SpeechError speechError) {
        this.isfinish = true;
    }

    public void onSpeakBegin() {
        this.isfinish = false;
    }

    public void onSpeakPaused() {
    }

    public void onSpeakProgress(int i, int i2, int i3) {
    }

    public void onSpeakResumed() {
    }

    public void destroy() {
        if (this.mSpeechSynthesizer != null) {
            this.mSpeechSynthesizer.stopSpeaking();
        }
    }

    public void onArriveDestination() {
        playText("到达目的地");
    }

    public void onArrivedWayPoint(int i) {
    }

    public void onCalculateRouteFailure(int i) {
        playText("路线规划失败，请检查网络或输入参数");
    }

    public void onCalculateRouteSuccess() {
        playText("路线规划就绪");
    }

    public void onEndEmulatorNavi() {
        playText("导航结束");
    }

    public void onGetNavigationText(int i, String str) {
        playText(str);
    }

    public void onInitNaviFailure() {
    }

    public void onInitNaviSuccess() {
    }

    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {
    }

    public void onReCalculateRouteForTrafficJam() {
        playText("前方路线拥堵，路线重新规划");
    }

    public void onReCalculateRouteForYaw() {
        playText("您已偏航");
    }

    public void onStartNavi(int i) {
    }

    public void onTrafficStatusUpdate() {
    }

    public void onGpsOpenStatus(boolean z) {
    }

    public void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {
    }

    public void onNaviInfoUpdate(NaviInfo naviInfo) {
    }
}
